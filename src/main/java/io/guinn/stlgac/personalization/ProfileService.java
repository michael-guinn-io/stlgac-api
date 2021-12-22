package io.guinn.stlgac.personalization;

import io.guinn.stlgac.GACException;
import io.guinn.stlgac.GACObject;

import javax.ejb.Stateless;
import javax.mail.internet.InternetAddress;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Stateless
public class ProfileService extends GACObject {

    @PersistenceContext(unitName = "stlgac.persistence")
    private EntityManager entityManager;

    public void createProfile(Profile profile) throws GACException {

        if (profile == null || profile.getName() == null || profile.getEmailAddress() == null) {
            throw new GACException("Cannot create Profile, it does not have required fields.");
        }

        Profile existing = getProfileByEmail(profile.getEmailAddress());
        if (existing != null) {
            throw new GACException("Profile with the email address " + profile.getEmailAddress().getAddress()
                + " already exists.");
        }

        entityManager.persist(profile);
    }

    public Profile updateProfile(Profile profile) throws GACException {

        if (profile == null || profile.getName() == null || profile.getEmailAddress() == null) {
            throw new GACException("Cannot update Profile, it does not have required fields.");
        }

        Profile existing = getProfileByEmail(profile.getEmailAddress());
        if (existing != null) {
            throw new GACException("Profile with the email address " + profile.getEmailAddress().getAddress()
                    + " already exists.");
        }

        return entityManager.merge(profile);
    }

    public void removeProfile(Profile profile) throws GACException {

        if (profile == null || profile.getId() == null) {
            throw new GACException("Unable to delete profile, object is either null or ID not set.");
        }

        Profile retrieved = entityManager.find(Profile.class, profile.getId());
        if (retrieved == null) {
            throw new GACException("Unable to delete profile. Could not find profile with ID " + profile.getId());
        }

        entityManager.remove(retrieved);
    }

    public Profile getProfileByEmail(InternetAddress emailAddress) {

        TypedQuery<Profile> query = entityManager.createNamedQuery(Profile.QUERY_BY_EMAIL, Profile.class);
        query.setParameter("emailAddress", emailAddress);

        List<Profile> result = query.getResultList();
        if (result.size() == 0) {
            return null;
        } else if (result.size() > 1) {
            log.warn("{} profile found with the email address {}. Check the database, a unique key constraint has be violated.",
                result.size(), emailAddress.getAddress());
        }

        return result.get(0);
    }

    public Profile getProfileById(Long id) {
        return entityManager.find(Profile.class, id);
    }
}
