package org.z.controllers.tweet.dtos.mapper;

import java.util.function.Function;


import org.z.controllers.tweet.dtos.create.CreateTweetResponseDto;
import org.z.domains.tweet.entities.Tweet;

public class Tweet2CreateTweetResponseDtoMapper implements Function<Tweet, CreateTweetResponseDto> {
    public static CreateTweetResponseDto mapper(final Tweet aTweet) {
        return new Tweet2CreateTweetResponseDtoMapper().apply(aTweet);
    }

    @Override
    public CreateTweetResponseDto apply(final Tweet input) {
        return new CreateTweetResponseDto(
                input.getId(),
                input.getContent(),
                input.getAuthorId(),
                input.getAuthorLogin(),
                input.getLikes(),
                input.getViews(),
                input.getCreatedAt());
    }
}
