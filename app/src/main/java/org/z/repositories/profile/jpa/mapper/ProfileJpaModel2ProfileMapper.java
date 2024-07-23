package org.z.repositories.profile.jpa.mapper;

import org.z.domains.profile.entities.Profile;
import org.z.repositories.profile.jpa.model.ProfileJpaModel;

import java.util.function.Function;
import java.util.HashMap;
import java.util.stream.Collectors;

public class ProfileJpaModel2ProfileMapper implements Function<ProfileJpaModel, Profile> {

    public static Profile mapper(final ProfileJpaModel model) {
        return new ProfileJpaModel2ProfileMapper().apply(model);
    }

    @Override
    public Profile apply(final ProfileJpaModel model) {
        final var followeds = model
                .getFollows()
                .stream()
                .map((p) -> {

                    final var profileFollows = p
                            .getFollows()
                            .stream()
                            .map((f) -> {
                                return Profile.with(
                                        f.getId(),
                                        f.getName(),
                                        f.getName(),
                                        f.getLogin(),
                                        new HashMap<String, Profile>());
                            })
                            .collect(Collectors.toMap(Profile::getId, Function.identity()));

                    return Profile.with(
                            p.getId(),
                            p.getName(),
                            p.getName(),
                            p.getLogin(),
                            profileFollows);
                })
                .collect(Collectors.toMap(Profile::getId, Function.identity()));

        return Profile.with(model.getId(),
                model.getName(),
                model.getName(),
                model.getLogin(), followeds);
    }

}
