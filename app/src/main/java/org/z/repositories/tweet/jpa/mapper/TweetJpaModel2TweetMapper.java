package org.z.repositories.tweet.jpa.mapper;

import java.util.function.Function;

import org.z.domains.tweet.entities.Tweet;
import org.z.repositories.tweet.jpa.model.TweetJpaModel;

public class TweetJpaModel2TweetMapper implements Function<TweetJpaModel, Tweet> {

    public static Tweet mapper(final TweetJpaModel model) {
        return new TweetJpaModel2TweetMapper().apply(model);
    }

    @Override
    public Tweet apply(TweetJpaModel t) {
        final var tweet = Tweet.with(
                t.getId(),
                t.getContent(),
                t.getAuthor().getId(),
                t.getAuthor().getLogin(),
                t.getLikes(),
                t.getViews(),
                t.getCreatedAt());

        return tweet;
    }

}
