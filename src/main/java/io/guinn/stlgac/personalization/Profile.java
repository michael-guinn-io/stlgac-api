package io.guinn.stlgac.personalization;

import io.guinn.stlgac.GACEntity;
import io.guinn.stlgac.util.conversion.EmailAttributeConverter;

import javax.mail.internet.InternetAddress;
import javax.persistence.*;

@Entity
@NamedQueries(
    @NamedQuery(name = Profile.QUERY_BY_EMAIL, query = "SELECT p FROM Profile p WHERE p.emailAddress = :emailAddress")
)
public class Profile extends GACEntity {

    public static final String QUERY_BY_EMAIL = "profile.byEmail";

    @Basic
    private String name;
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    @Convert(converter = EmailAttributeConverter.class)
    private InternetAddress emailAddress;
    public InternetAddress getEmailAddress() {
        return emailAddress;
    }
    public void setEmailAddress(InternetAddress emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Basic
    private String lastFourDigitsOfDriversLicense;
    public String getLastFourDigitsOfDriversLicense() {
        return lastFourDigitsOfDriversLicense;
    }
    public void setLastFourDigitsOfDriversLicense(String lastFourDigitsOfDriversLicense) {
        this.lastFourDigitsOfDriversLicense = lastFourDigitsOfDriversLicense;
    }
}
