package org.z.controllers.profile.dtos.mapper;

import java.util.function.Function;
import java.util.stream.Collectors;

import org.z.controllers.profile.dtos.CreateProfileResponseDto;
import org.z.controllers.profile.dtos.FollowedDto;
import org.z.domains.profile.entities.Profile;

public class Profile2CreateProfileResponseDtoMapper implements Function<Profile, CreateProfileResponseDto> {
    
    public static CreateProfileResponseDto mapper(final Profile profile){
        return new Profile2CreateProfileResponseDtoMapper().apply(profile);
    }

    @Override
    public CreateProfileResponseDto apply(final Profile t) {
        final var followsDto = 
            t.getFollowed()
            .values()
            .stream()
            .map((p) -> {
                return new FollowedDto(p.getId(), p.getLogin());
            })
            .collect(Collectors.toList());

        return new CreateProfileResponseDto(t.getId(), t.getName(), t.getEmail(), t.getLogin(), followsDto);
    }
    
}
