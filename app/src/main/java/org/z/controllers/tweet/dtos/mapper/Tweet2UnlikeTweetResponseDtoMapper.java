package org.z.controllers.tweet.dtos.mapper;

import java.util.function.Function;

import org.z.controllers.tweet.dtos.like.UnlikeTweetResponseDto;
import org.z.domains.tweet.entities.Tweet;


public class Tweet2UnlikeTweetResponseDtoMapper implements Function<Tweet, UnlikeTweetResponseDto> {

    public static UnlikeTweetResponseDto mapper(final Tweet aTweet) {
        return new Tweet2UnlikeTweetResponseDtoMapper().apply(aTweet);
    }

    @Override
    public UnlikeTweetResponseDto apply(final Tweet input) {
        return new UnlikeTweetResponseDto(
                input.getId(),
                input.getContent(),
                input.getAuthorId(),
                input.getAuthorLogin(),
                input.getLikes(),
                input.getViews(),
                input.getCreatedAt());
    }

}