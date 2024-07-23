package org.z.repositories.profile.jpa.mapper;

import org.z.domains.profile.entities.Profile;
import org.z.repositories.profile.jpa.model.ProfileJpaModel;

import java.util.function.Function;
import java.util.stream.Collectors;

public class Profile2ProfileJpaModelMapper implements Function<Profile, ProfileJpaModel> {

    public static ProfileJpaModel mapper(final Profile profile) {
        return new Profile2ProfileJpaModelMapper().apply(profile);
    }

    @Override
    public ProfileJpaModel apply(Profile input) {
        final var follows = input.getFollowed().values()
                .stream()
                .map((f) -> {
                    return new ProfileJpaModel(
                            f.getId(),
                            f.getName(),
                            f.getEmail(),
                            f.getLogin(),
                            null, null);
                })
                .collect(Collectors.toSet());

        return new ProfileJpaModel(
                input.getId(),
                input.getName(),
                input.getEmail(),
                input.getLogin(),
                follows,
                null);
    }

}
