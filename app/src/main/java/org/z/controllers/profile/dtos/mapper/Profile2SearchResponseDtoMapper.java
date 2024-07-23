package org.z.controllers.profile.dtos.mapper;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.z.controllers.profile.dtos.ProfileDto;
import org.z.controllers.profile.dtos.SearchProfileResponseDto;
import org.z.domains.profile.entities.Profile;

public class Profile2SearchResponseDtoMapper implements Function<List<Profile>, SearchProfileResponseDto> {

    public static SearchProfileResponseDto mapper(final List<Profile> aProfile) {
        return new Profile2SearchResponseDtoMapper().apply(aProfile);
    }

    @Override
    public SearchProfileResponseDto apply(final List<Profile> input) {
        final var profiles = input.stream()
                .map((profile) -> {
                    return new ProfileDto(
                            profile.getId(),
                            profile.getName(),
                            profile.getEmail(),
                            profile.getLogin());
                })
                .collect(Collectors.toList());

        return new SearchProfileResponseDto(profiles);
    }

}
