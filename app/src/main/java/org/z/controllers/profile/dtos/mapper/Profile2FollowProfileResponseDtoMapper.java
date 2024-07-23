package org.z.controllers.profile.dtos.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.z.controllers.profile.dtos.CreateProfileResponseDto;
import org.z.controllers.profile.dtos.FollowProfileResponseDto;
import org.z.controllers.profile.dtos.FollowedDto;
import org.z.domains.profile.entities.Profile;

public class Profile2FollowProfileResponseDtoMapper implements Function<Profile, FollowProfileResponseDto> {

    public static FollowProfileResponseDto mapper(final Profile profile) {
        return new Profile2FollowProfileResponseDtoMapper().apply(profile);
    }

    @Override
    public FollowProfileResponseDto apply(Profile input) {
        final var followsDto = input.getFollowed()
                .values()
                .stream()
                .map(p -> {
                    return new FollowedDto(p.getId(), p.getLogin());
                })
                .collect(Collectors.toList());

        return new FollowProfileResponseDto(input.getId(),
                input.getName(),
                input.getEmail(),
                input.getLogin(),
                followsDto);

    }

}
