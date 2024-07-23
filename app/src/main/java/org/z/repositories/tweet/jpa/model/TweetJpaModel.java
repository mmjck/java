package org.z.repositories.tweet.jpa.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinColumns;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import java.time.Instant;

import org.z.repositories.profile.jpa.model.ProfileJpaModel;

@Entity(name = "Tweet")
@Table(name = "tb_tweets")
public class TweetJpaModel {
    @Id
    @Column(name = "id", nullable = false, updatable = false, columnDefinition = "VARCHAR(36)")
    private String id;

    @Column(name = "content", nullable = false, updatable = false)
    private String content;

    @Column(name = "likes", nullable = false)
    private int likes;

    @Column(name = "views", nullable = false)
    private int views;

    @Column(name = "created_at", nullable = false)
    private Instant createdAt;

    @ManyToOne(targetEntity = ProfileJpaModel.class, optional = false, fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(name = "author_id", referencedColumnName = "id", nullable = false),
            @JoinColumn(name = "author_login", referencedColumnName = "login", nullable = false),
    })
    private ProfileJpaModel author;

    public TweetJpaModel() {
    }

    public TweetJpaModel(String id, String content, int likes, int views, Instant createdAt, ProfileJpaModel author) {
        this.id = id;
        this.content = content;
        this.likes = likes;
        this.views = views;
        this.createdAt = createdAt;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public ProfileJpaModel getAuthor() {
        return author;
    }

    public void setAuthor(ProfileJpaModel author) {
        this.author = author;
    }

}
