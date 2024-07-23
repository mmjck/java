package org.z.controllers.tweet;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.z.controllers.tweet.dtos.ListFollowsTweetsResponseDto;
import org.z.controllers.tweet.dtos.ListTweetResponseDto;
import org.z.controllers.tweet.dtos.ViewTweetResponseDto;
import org.z.controllers.tweet.dtos.create.CreateTweetRequestDto;
import org.z.controllers.tweet.dtos.create.CreateTweetResponseDto;
import org.z.controllers.tweet.dtos.like.LikeTweetResponseDto;
import org.z.controllers.tweet.dtos.like.UnlikeTweetResponseDto;
import org.z.controllers.tweet.dtos.mapper.ListFollowsTweetsResponseDtoMapper;
import org.z.controllers.tweet.dtos.mapper.ListTweetResponseDtoMapper;
import org.z.controllers.tweet.dtos.mapper.Tweet2CreateTweetResponseDtoMapper;
import org.z.controllers.tweet.dtos.mapper.Tweet2LikeTweetResponseDtoMapper;
import org.z.controllers.tweet.dtos.mapper.Tweet2UnlikeTweetResponseDtoMapper;
import org.z.controllers.tweet.dtos.mapper.Tweet2ViewTweetResponseDto;
import org.z.repositories.profile.ProfileJpaGateway;
import org.z.repositories.profile.jpa.ProfileJpaRepository;
import org.z.repositories.tweet.jpa.TweetJpaGateway;
import org.z.repositories.tweet.jpa.TweetJpaRepository;
import org.z.services.tweet.implementation.TweetServiceImplementation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("api/v1/tweet")
public class TweetController {
    final private TweetJpaRepository tweetJpaRepository;
    final private ProfileJpaRepository profileJpaRepository;

    public TweetController(TweetJpaRepository tweetJpaRepository, ProfileJpaRepository profileJpaRepository) {
        this.tweetJpaRepository = tweetJpaRepository;
        this.profileJpaRepository = profileJpaRepository;
    }

    @PostMapping("/create")
    public CreateTweetResponseDto create(@RequestBody final CreateTweetRequestDto request) {
        final var tweetGateway = TweetJpaGateway.build(this.tweetJpaRepository, this.profileJpaRepository);
        final var profileGateway = ProfileJpaGateway.build(this.profileJpaRepository);

        final var service = TweetServiceImplementation.build(tweetGateway, profileGateway);

        final var tweet = service.create(request.authorLogin(), request.content());

        final var response = Tweet2CreateTweetResponseDtoMapper.mapper(tweet);

        return response;
    }

    @GetMapping("/{id}/like")
    public LikeTweetResponseDto like(@PathVariable("id") final String id) {
        final var tweetGateway = TweetJpaGateway.build(this.tweetJpaRepository, this.profileJpaRepository);
        final var profileGateway = ProfileJpaGateway.build(this.profileJpaRepository);

        final var service = TweetServiceImplementation.build(tweetGateway, profileGateway);

        final var tweet = service.like(id);

        final var response = Tweet2LikeTweetResponseDtoMapper.mapper(tweet);

        return response;
    }

    @GetMapping("/{id}/unlike")
    public UnlikeTweetResponseDto unlike(@PathVariable("id") final String id) {
        final var tweetGateway = TweetJpaGateway.build(this.tweetJpaRepository, this.profileJpaRepository);
        final var profileGateway = ProfileJpaGateway.build(this.profileJpaRepository);

        final var service = TweetServiceImplementation.build(tweetGateway, profileGateway);

        final var tweet = service.dislike(id);

        final var response = Tweet2UnlikeTweetResponseDtoMapper.mapper(tweet);

        return response;
    }

    @GetMapping("/{id}/view")
    public ViewTweetResponseDto view(@PathVariable("id") final String id) {
        final var tweetGateway = TweetJpaGateway.build(this.tweetJpaRepository, this.profileJpaRepository);
        final var profileGateway = ProfileJpaGateway.build(this.profileJpaRepository);

        final var service = TweetServiceImplementation.build(tweetGateway, profileGateway);

        final var tweet = service.view(id);

        final var response = Tweet2ViewTweetResponseDto.mapper(tweet);

        return response;
    }

    @GetMapping("/{login}/list")
    public ListTweetResponseDto list(@PathVariable("login") final String login) {
        final var tweetGateway = TweetJpaGateway.build(this.tweetJpaRepository, this.profileJpaRepository);
        final var profileGateway = ProfileJpaGateway.build(this.profileJpaRepository);

        final var service = TweetServiceImplementation.build(tweetGateway, profileGateway);

        final var tweets = service.findByAuthor(login);

        final var response = ListTweetResponseDtoMapper.mapper(tweets);

        return response;
    }

    @GetMapping("/{login}/follows/list")
    public ListFollowsTweetsResponseDto listFollowsTweets(@PathVariable("login") final String login) {
        final var tweetGateway = TweetJpaGateway.build(this.tweetJpaRepository, this.profileJpaRepository);
        final var profileGateway = ProfileJpaGateway.build(this.profileJpaRepository);

        final var service = TweetServiceImplementation.build(tweetGateway, profileGateway);

        final var tweets = service.findByFollowed(login);

        final var response = ListFollowsTweetsResponseDtoMapper.mapper(tweets);

        return response;
    }

}
