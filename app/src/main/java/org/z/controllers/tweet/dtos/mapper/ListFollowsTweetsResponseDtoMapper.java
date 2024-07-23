package org.z.controllers.tweet.dtos.mapper;

import org.z.controllers.tweet.dtos.ListFollowsTweetsResponseDto;
import org.z.controllers.tweet.dtos.TweetDto;
import org.z.domains.tweet.entities.Tweet;


import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ListFollowsTweetsResponseDtoMapper implements Function<List<Tweet>, ListFollowsTweetsResponseDto>  {
    
    public static ListFollowsTweetsResponseDto mapper(final List<Tweet> tweets) {
        return new ListFollowsTweetsResponseDtoMapper().apply(tweets);
    }

    @Override
    public ListFollowsTweetsResponseDto apply(List<Tweet> input) {
        final var aTweets = input.stream()
                .map((tweet) -> {
                    return new TweetDto(
                            tweet.getId(),
                            tweet.getContent(),
                            tweet.getAuthorId(),
                            tweet.getAuthorLogin(),
                            tweet.getLikes(),
                            tweet.getViews(),
                            tweet.getCreatedAt());
                })
                .collect(Collectors.toList());

        return new ListFollowsTweetsResponseDto(aTweets);
    }
}
