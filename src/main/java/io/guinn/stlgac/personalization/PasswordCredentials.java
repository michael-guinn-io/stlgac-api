package io.guinn.stlgac.personalization;

import io.guinn.stlgac.GACEntity;

import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class PasswordCredentials extends GACEntity {

    @OneToOne(targetEntity = Profile.class, cascade = CascadeType.REMOVE)
    private Profile profile;
    public Profile getProfile() {
        return profile;
    }
    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    @Basic
    private String password;
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    private Integer failedAttempts;
    public Integer getFailedAttempts() {
        return failedAttempts;
    }
    public void setFailedAttempts(Integer failedAttempts) {
        this.failedAttempts = failedAttempts;
    }

    @Basic
    private boolean enabled;
    public boolean isEnabled() {
        return enabled;
    }
    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}
