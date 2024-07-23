package org.z.services.profile.implementation;

import java.util.List;
import org.z.domains.profile.entities.Profile;
import org.z.domains.profile.gateway.ProfileGateway;
import org.z.services.profile.ProfileService;

public class ProfileServiceImplementation implements ProfileService {

    private final ProfileGateway profileGateway;

    private ProfileServiceImplementation(ProfileGateway profileGateway) {
        this.profileGateway = profileGateway;
    }

    public static ProfileServiceImplementation build(ProfileGateway gateway) {
        return new ProfileServiceImplementation(gateway);
    }

    @Override
    public Profile get(final String login) {
        final var profile = this.profileGateway.findByLogin(login);
        System.out.println("login " + login);
        return profile;
    }

    @Override
    public Profile follow(final String followerLogin, final String followedLogin) {

        final Profile followerProfile = this.profileGateway.findByLogin(followerLogin);// .orElseThrow(() -> new
                                                                                       // IllegalArgumentException("Follower
                                                                                       // not found"));;
        final Profile followedProfile = this.profileGateway.findByLogin(followedLogin);// .orElseThrow(() -> new
                                                                                       // IllegalArgumentException("Follower
                                                                                       // not found"));;

        followerProfile.follow(followedProfile);
        this.profileGateway.update(followerProfile);

        return followerProfile;

    }

    @Override
    public Profile unfollow(String followerLogin, String followedLogin) {
        final var aFollowerProfile = this.profileGateway.findByLogin(followerLogin);
        final var aFollowedProfile = this.profileGateway.findByLogin(followedLogin);

        if (aFollowerProfile == null) {
            throw new IllegalArgumentException("Follower not found");
        }

        if (aFollowedProfile == null) {
            throw new IllegalArgumentException("Followed not found");
        }

        aFollowerProfile.unfollow(aFollowedProfile);

        this.profileGateway.update(aFollowerProfile);

        return aFollowerProfile;
    }

    @Override
    public Profile create(String name, String login, String email) {
        final var findedProfile = this.profileGateway.findByLogin(login);

        if (findedProfile != null) {
            throw new IllegalArgumentException("Login already exists");
        }

        final var profile = Profile.build(name, email, login);
        this.profileGateway.create(profile);
        return profile;
    }

    @Override
    public List<Profile> search(String login) {
        final List<Profile> profiles = this.profileGateway.searchByLogin(login);
        return profiles;
    }

    @Override
    public boolean isFollowing(final String followerLogin, final String followedLogin) {
        final Profile followerProfile = this.profileGateway.findByLogin(followerLogin);// .orElseThrow(() -> new
                                                                                       // IllegalArgumentException("Follower
                                                                                       // not found"));;
        final Profile followedProfile = this.profileGateway.findByLogin(followedLogin);// .orElseThrow(() -> new
                                                                                       // IllegalArgumentException("Follower
                                                                                       // not found"));;

        if (followerProfile == null) {
            throw new IllegalArgumentException("Follower not found");
        }

        if (followedProfile == null) {
            throw new IllegalArgumentException("Followed not found");
        }

        return followedProfile.getFollowed().containsKey(followedProfile.getId());
    }

}
