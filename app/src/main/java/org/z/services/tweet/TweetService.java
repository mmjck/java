package org.z.services.tweet;

import java.util.List;

import org.z.domains.tweet.entities.Tweet;

public interface TweetService {
    public Tweet create(final String authorLogin, final String content);
    public Tweet like(final String id);
    public Tweet dislike(final String id);
    public Tweet view(final String id);
    public List<Tweet> findByAuthor(final String authorLogin);
    public List<Tweet> findByFollowed(final String profileLogin);
}
