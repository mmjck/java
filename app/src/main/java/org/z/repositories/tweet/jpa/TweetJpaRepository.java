package org.z.repositories.tweet.jpa;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.z.repositories.tweet.jpa.model.TweetJpaModel;

import jakarta.persistence.OrderBy;

import java.util.List;

public interface TweetJpaRepository extends JpaRepository<TweetJpaModel, String> {
    @OrderBy("created_at DESC")
    @Query(nativeQuery = true, value = "SELECT * FROM tweets WHERE author.id=:authorId")
    public List<TweetJpaModel> findByAuthorId(final String authorId);
}
