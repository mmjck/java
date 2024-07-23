package org.z.controllers.tweet.dtos.mapper;

import org.z.controllers.tweet.dtos.ViewTweetResponseDto;
import org.z.domains.tweet.entities.Tweet;

import java.util.function.Function;

public class Tweet2ViewTweetResponseDto implements Function<Tweet, ViewTweetResponseDto>{

    public static ViewTweetResponseDto mapper(final Tweet aTweet) {
        return new Tweet2ViewTweetResponseDto().apply(aTweet);
    }

    @Override
    public ViewTweetResponseDto apply(final Tweet input) {
        return new ViewTweetResponseDto(
                input.getId(),
                input.getContent(),
                input.getAuthorId(),
                input.getAuthorLogin(),
                input.getLikes(),
                input.getViews(),
                input.getCreatedAt());
    }

}
