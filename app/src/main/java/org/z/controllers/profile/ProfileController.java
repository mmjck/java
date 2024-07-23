package org.z.controllers.profile;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.z.controllers.profile.dtos.CreateProfileRequestDto;
import org.z.controllers.profile.dtos.CreateProfileResponseDto;
import org.z.controllers.profile.dtos.FollowProfileRequestDto;
import org.z.controllers.profile.dtos.FollowProfileResponseDto;
import org.z.controllers.profile.dtos.GetProfileResponseDto;
import org.z.controllers.profile.dtos.IsFollowingResponseDto;
import org.z.controllers.profile.dtos.SearchProfileRequestDto;
import org.z.controllers.profile.dtos.SearchProfileResponseDto;
import org.z.controllers.profile.dtos.UnfollowProfileRequestDto;
import org.z.controllers.profile.dtos.mapper.Profile2CreateProfileResponseDtoMapper;
import org.z.controllers.profile.dtos.mapper.Profile2FollowProfileResponseDtoMapper;
import org.z.controllers.profile.dtos.mapper.Profile2GetProfileResponseDtoMapper;
import org.z.controllers.profile.dtos.mapper.Profile2SearchResponseDtoMapper;
import org.z.domains.profile.entities.Profile;
import org.z.repositories.profile.ProfileJpaGateway;
import org.z.repositories.profile.jpa.ProfileJpaRepository;
import org.z.services.profile.implementation.ProfileServiceImplementation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/api/v1/profile")
public class ProfileController {

    final private ProfileJpaRepository profileJpaRepository;

    public ProfileController(ProfileJpaRepository profileJpaRepository) {
        this.profileJpaRepository = profileJpaRepository;
    }

    @GetMapping("/{login}")
    public GetProfileResponseDto get(@PathVariable final String login) {
        final var gateway = ProfileJpaGateway.build(this.profileJpaRepository);
        final var service = ProfileServiceImplementation.build(gateway);
        Profile profile = service.get(login);
        GetProfileResponseDto response = Profile2GetProfileResponseDtoMapper.mapper(profile);
        return response;

    }

    @PostMapping("/create")
    public CreateProfileResponseDto create(@RequestBody CreateProfileRequestDto request) {
        final var gateway = ProfileJpaGateway.build(this.profileJpaRepository);
        final var service = ProfileServiceImplementation.build(gateway);

        final var profile = service.create(request.name(), request.login(), request.email());

        final var response = Profile2CreateProfileResponseDtoMapper.mapper(profile);
        return response;

    }

    @PostMapping("/{login}/follow")
    public FollowProfileResponseDto follow(@PathVariable final String login,
            @RequestBody final FollowProfileRequestDto request) {
        final var gateway = ProfileJpaGateway.build(this.profileJpaRepository);
        final var service = ProfileServiceImplementation.build(gateway);

        final var profile = service.follow(login, request.followed());

        final var response = Profile2FollowProfileResponseDtoMapper.mapper(profile);
        return response;

    }

    @PostMapping("/{login}/unfollow")
    public FollowProfileResponseDto unfollow(@PathVariable final String login,
            @RequestBody final UnfollowProfileRequestDto request) {
        final var gateway = ProfileJpaGateway.build(this.profileJpaRepository);
        final var service = ProfileServiceImplementation.build(gateway);

        final var profile = service.unfollow(login, request.followed());

        final var response = Profile2FollowProfileResponseDtoMapper.mapper(profile);
        return response;

    }

    @PostMapping("/search")
    public SearchProfileResponseDto search(@RequestBody final SearchProfileRequestDto request) {
        final var gateway = ProfileJpaGateway.build(this.profileJpaRepository);
        final var service = ProfileServiceImplementation.build(gateway);

        final var aProfile = service.search(request.login());

        final var aResponse = Profile2SearchResponseDtoMapper.mapper(aProfile);

        return aResponse;
    }

    @GetMapping("/{follower}/follows/{followed}")
    public IsFollowingResponseDto isFollowing(
            @PathVariable("follower") final String follower,
            @PathVariable("followed") final String followed) {

        final var gateway = ProfileJpaGateway.build(this.profileJpaRepository);
        final var service = ProfileServiceImplementation.build(gateway);

        final var isItFollowing = service.isFollowing(follower, followed);

        final var aResponse = new IsFollowingResponseDto(isItFollowing);

        return aResponse;
    }

}
