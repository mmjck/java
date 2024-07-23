package org.z.services.profile;

import java.util.List;
import org.z.domains.profile.entities.Profile;

public interface ProfileService {
    public Profile get(final String login);
    public Profile follow(final String followerLogin, final String followedLogin);
    public Profile unfollow(final String followerLogin, final String followedLogin);
    public Profile create(final String name, final String login, final String email);

    public List<Profile> search(final String login);
    public boolean isFollowing(final String followerLogin, final String followedLogin);
}
