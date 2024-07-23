package org.z.repositories.profile;

import java.util.List;
import java.util.stream.Collectors;

import org.z.domains.profile.entities.Profile;
import org.z.domains.profile.gateway.ProfileGateway;
import org.z.repositories.profile.jpa.ProfileJpaRepository;
import org.z.repositories.profile.jpa.mapper.Profile2ProfileJpaModelMapper;
import org.z.repositories.profile.jpa.mapper.ProfileJpaModel2ProfileMapper;

public class ProfileJpaGateway implements ProfileGateway {

    private final ProfileJpaRepository repository;

    private ProfileJpaGateway(ProfileJpaRepository repository) {
        this.repository = repository;
    }

    public static ProfileJpaGateway build(final ProfileJpaRepository repository) {
        return new ProfileJpaGateway(repository);

    }

    @Override
    public void create(Profile data) {
        final var entity = Profile2ProfileJpaModelMapper.mapper(data);
        this.repository.save(entity);

        data.getFollowed()
                .values()
                .forEach((f) -> { 
                    this.repository.createFollow(data.getId(), f.getId()); 
                });

    }

    @Override
    public void update(Profile data) {
        final var entity = Profile2ProfileJpaModelMapper.mapper(data);
        this.repository.save(entity);
    }

    @Override
    public Profile findById(final String id) {
        final var profile = this.repository.findById(id).orElse(null);

        if (profile == null) {
            return null;
        }

        return ProfileJpaModel2ProfileMapper.mapper(profile);

    }

    @Override
    public Profile findByLogin(final String login) {
        final var profile = this.repository.findByLogin(login).orElse(null);

        if (profile == null) {
            return null;
        }

        return ProfileJpaModel2ProfileMapper.mapper(profile);

    }

    @Override
    public List<Profile> searchByLogin(String login) {
        final var profiles = this.repository.findByLoginContains(login);
        return profiles
                .stream()
                .map(ProfileJpaModel2ProfileMapper::mapper)
                .collect(Collectors.toList());
    }

    @Override
    public List<Profile> findFollowedByProfileId(String login) {
        final var followsModel = this.repository.findFollowByProfileId(login);

        final var follows = followsModel
            .stream()
            .map(ProfileJpaModel2ProfileMapper::mapper)
            .collect(Collectors.toList());

        return follows;
    }

}
