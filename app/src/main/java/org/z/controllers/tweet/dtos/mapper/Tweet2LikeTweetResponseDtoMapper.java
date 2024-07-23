package org.z.controllers.tweet.dtos.mapper;

import java.util.function.Function;

import org.z.controllers.tweet.dtos.like.LikeTweetResponseDto;
import org.z.domains.tweet.entities.Tweet;


public class Tweet2LikeTweetResponseDtoMapper implements Function<Tweet, LikeTweetResponseDto> {

    public static LikeTweetResponseDto mapper(final Tweet aTweet) {
        return new Tweet2LikeTweetResponseDtoMapper().apply(aTweet);
    }

    @Override
    public LikeTweetResponseDto apply(Tweet input) {
        return new LikeTweetResponseDto(
                input.getId(),
                input.getContent(),
                input.getAuthorId(),
                input.getAuthorLogin(),
                input.getLikes(),
                input.getViews(),
                input.getCreatedAt());
    }

}