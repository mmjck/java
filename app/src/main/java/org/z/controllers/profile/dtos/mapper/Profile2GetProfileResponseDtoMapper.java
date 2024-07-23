package org.z.controllers.profile.dtos.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;
import org.z.controllers.profile.dtos.FollowedDto;
import org.z.controllers.profile.dtos.GetProfileResponseDto;
import org.z.domains.profile.entities.Profile;;

public class Profile2GetProfileResponseDtoMapper implements Function<Profile, GetProfileResponseDto> {

    public static GetProfileResponseDto mapper(final Profile profile) {
        return new Profile2GetProfileResponseDtoMapper().apply(profile);
    }

    @Override
    public GetProfileResponseDto apply(final Profile profile) {
        final var followsDto = profile
                .getFollowed()
                .values()
                .stream()
                .map((p) -> {
                    return new FollowedDto(p.getId(), p.getLogin());
                })
                .collect(Collectors.toList());

        return new GetProfileResponseDto(
                profile.getId(),
                profile.getName(),
                profile.getEmail(),
                profile.getLogin(),
                followsDto);
    }

}
