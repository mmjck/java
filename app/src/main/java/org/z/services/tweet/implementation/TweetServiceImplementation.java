package org.z.services.tweet.implementation;

import java.util.List;

import org.z.domains.profile.gateway.ProfileGateway;
import org.z.domains.tweet.entities.Tweet;
import org.z.domains.tweet.gateway.TweetGateway;
import org.z.services.tweet.TweetService;

public class TweetServiceImplementation implements TweetService {

    private final TweetGateway tweetGateway;
    private final ProfileGateway profileGateway;

    private TweetServiceImplementation(TweetGateway tweetGateway, ProfileGateway profileGateway) {
        this.tweetGateway = tweetGateway;
        this.profileGateway = profileGateway;
    }

    public static TweetServiceImplementation build(TweetGateway tweetGateway, ProfileGateway profileGateway) {
        return new TweetServiceImplementation(tweetGateway, profileGateway);
    }

    @Override
    public Tweet create(final String authorLogin, final String content) {
        final var profile = this.profileGateway.findByLogin(authorLogin);

        if(profile == null){
            throw new IllegalArgumentException("Author not found");
        }
        final var tweet = Tweet.build(content, profile.getId(), profile.getLogin());
        this.tweetGateway.create(tweet);

        return tweet;
    }

    @Override
    public Tweet like(final String id) {
        final var tweet = this.tweetGateway.findById(id);

        if(tweet == null){
            throw new IllegalArgumentException("tweet not found");
        }
        tweet.like();

        this.tweetGateway.update(tweet);

        return tweet;
    }

    @Override
    public Tweet dislike(final String id) {
        final var tweet = this.tweetGateway.findById(id);

        if(tweet == null){
            throw new IllegalArgumentException("tweet not found");
        }
        tweet.dislike();

        this.tweetGateway.update(tweet);

        return tweet;
    }

    @Override
    public Tweet view(final String id) {
        final var tweet = this.tweetGateway.findById(id);

        if(tweet == null){
            throw new IllegalArgumentException("tweet not found");
        }


        tweet.view();
        this.tweetGateway.update(tweet);

        return tweet;
    }

    @Override
    public List<Tweet> findByAuthor(final String authorLogin) {
        final var author = this.profileGateway.findByLogin(authorLogin);

        if(author == null){
            throw new IllegalArgumentException("author not found");
        }

        return this.tweetGateway.findByAuthorId(author.getId());
    }

    @Override
    public List<Tweet> findByFollowed(final String profileLogin) {
        final var profile = this.profileGateway.findByLogin(profileLogin);

        if(profile == null){
            throw new IllegalArgumentException("profile not found");
        }


        final var followed = this.profileGateway.findFollowedByProfileId(profile.getId());

        final var tweets = followed.stream()
            .map(f -> this.tweetGateway.findByAuthorId(f.getId()))
            .flatMap(List::stream)
            .toList();

        return tweets
                .stream()
                .sorted((tweet1, tweet2) -> tweet1.getCreatedAt().compareTo(tweet2.getCreatedAt()))
                .toList();

    }

}
