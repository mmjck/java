package org.z.controllers.profile.dtos.mapper;

import org.z.controllers.profile.dtos.FollowedDto;
import org.z.controllers.profile.dtos.UnfollowProfileResponseDto;
import org.z.domains.profile.entities.Profile;

import java.util.function.Function;
import java.util.stream.Collectors;


public class Profile2UnfollowResponseDtoMapper implements Function<Profile, UnfollowProfileResponseDto> {
    
    public static UnfollowProfileResponseDto mapper(final Profile aProfile) {
        return new Profile2UnfollowResponseDtoMapper().apply(aProfile);
    }

    @Override
    public UnfollowProfileResponseDto apply(final Profile input) {
        final var followsDto = input.getFollowed()
                .values()
                .stream()
                .map((profile) -> {
                    return new FollowedDto(profile.getId(), profile.getLogin());
                })
                .collect(Collectors.toList());

        return new UnfollowProfileResponseDto(
                input.getId(),
                input.getName(),
                input.getEmail(),
                input.getLogin(),
                followsDto);
    }
}
