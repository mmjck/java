package org.z.domains.tweet.gateway;

import java.util.List;

import org.z.domains.tweet.entities.Tweet;

public interface TweetGateway {
    public void create(final Tweet tweet);
    public void update(final Tweet tweet);

    public Tweet findById(final String id);

    public List<Tweet> findByAuthorId(final String authorId);

}
