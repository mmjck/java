package org.z.domains.profile.entities;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Profile {
    private String id;
    private String name;
    private String email;
    private String login;

    private Map<String, Profile> followed;

    private Profile(final String id, final String name, final String email, final String login,
            Map<String, Profile> followed) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.login = login;
        this.followed = followed;

        this.validate();
    }

    public static Profile build(final String aName, final String anEmail, final String aLogin) {
        return new Profile(UUID.randomUUID().toString(), aName, anEmail, aLogin, new HashMap<String, Profile>());
    }

    public static Profile with(String id, String name, String email, String login, Map<String, Profile> followed) {
        return new Profile(id, name, email, login, followed);
    }

    private void validate() {
        if (this.id == null) {
            throw new IllegalArgumentException("Profile id should not be null");
        }

        if (this.id.isBlank()) {
            throw new IllegalArgumentException("Profile id should not be blank");
        }

        if (this.id.length() != 36) {
            throw new IllegalArgumentException("Profile id should be a valid uuid");
        }

        if (this.name == null) {
            throw new IllegalArgumentException("Profile name should not be null");
        }

        if (this.name.length() < 3) {
            throw new IllegalArgumentException("Profile name should be at least 3 characters");
        }

        if (this.email == null) {
            throw new IllegalArgumentException("Profile email should not be null");
        }

        if (!this.email.contains("@")) {
            throw new IllegalArgumentException("Profile email should be a valid email");
        }

        if (this.login == null) {
            throw new IllegalArgumentException("Profile login should not be null");
        }

        if (this.login.isBlank()) {
            throw new IllegalArgumentException("Profile login should not be blank");
        }

        if (this.login.length() < 3) {
            throw new IllegalArgumentException("Profile login should be at least 3 characters");
        }

        if (this.followed == null) {
            throw new IllegalArgumentException("Profile followed should not be null");
        }
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getLogin() {
        return login;
    }

    public Map<String, Profile> getFollowed() {
        return followed;
    }

    public void setFollowed(Map<String, Profile> followed) {
        this.followed = followed;
    }

    public void follow(final Profile followed) {
        this.followed.put(followed.getId(), followed);
    }

    public void unfollow(final Profile followed) {
        this.followed.remove(followed.getId());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }

        if (obj == null)
            return false;

        if (getClass() != obj.getClass())
            return false;

        Profile other = (Profile) obj;

        if (id == null) {
            if (other.id != null) {
                return false;
            }
        } else if (!id.equals(other.id)) {
            return false;
        }

        return true;
    }

}
