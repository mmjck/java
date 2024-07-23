package org.z.repositories.tweet.jpa;

import java.util.List;
import org.z.domains.tweet.entities.Tweet;
import org.z.domains.tweet.gateway.TweetGateway;
import org.z.repositories.profile.jpa.ProfileJpaRepository;
import org.z.repositories.tweet.jpa.mapper.TweetJpaModel2TweetMapper;
import org.z.repositories.tweet.jpa.model.TweetJpaModel;

public class TweetJpaGateway implements TweetGateway {

    final TweetJpaRepository tweetJpaRepository;
    final ProfileJpaRepository profileJpaRepository;

    private TweetJpaGateway(TweetJpaRepository tweetJpaRepository, final ProfileJpaRepository profileJpaRepository) {
        this.tweetJpaRepository = tweetJpaRepository;
        this.profileJpaRepository = profileJpaRepository;
    }

    public static TweetJpaGateway build(TweetJpaRepository tweetJpaRepository,
            ProfileJpaRepository profileJpaRepository) {
        return new TweetJpaGateway(tweetJpaRepository, profileJpaRepository);
    }

    @Override
    public void create(Tweet tweet) {
        final var profile = this.profileJpaRepository.findById(tweet.getAuthorId()).orElse(null);

        if (profile == null) {
            throw new RuntimeException("Author not fount");
        }

        final var model = new TweetJpaModel(
                tweet.getId(),
                tweet.getContent(),
                tweet.getLikes(),
                tweet.getViews(),
                tweet.getCreatedAt(),
                profile);

        this.tweetJpaRepository.save(model);

    }

    @Override
    public void update(Tweet tweet) {
        final var profile = this.profileJpaRepository.findById(tweet.getAuthorId()).orElse(null);

        if (profile == null) {
            throw new RuntimeException("Author not fount");
        }

        final var model = new TweetJpaModel(
                tweet.getId(),
                tweet.getContent(),
                tweet.getLikes(),
                tweet.getViews(),
                tweet.getCreatedAt(),
                profile);

        this.tweetJpaRepository.save(model);
    }

    @Override
    public Tweet findById(String id) {
        final var model = this.tweetJpaRepository.findById(id);

        if (model == null) {
            return null;
        }

        return TweetJpaModel2TweetMapper.mapper(model.get());
    }

    @Override
    public List<Tweet> findByAuthorId(String authorId) {
        final var tweetsModel = this.tweetJpaRepository.findByAuthorId(authorId);

        final var tweets = tweetsModel
                .stream()
                .map(TweetJpaModel2TweetMapper::mapper)
                .toList();
        return tweets; 
    }

}
