package org.z.domains.tweet.entities;

import java.time.Instant;
import java.util.UUID;

import org.z.utils.InstantUtils;

public class Tweet {
    private String id;
    private String content;

    private String authorId;
    private String authorLogin;
    private int likes;
    private int views;

    private Instant createdAt;

    public Tweet(String id, String content, String authorId, String authorLogin, int likes, int views,
            Instant createdAt) {
        this.id = id;
        this.content = content;
        this.authorId = authorId;
        this.authorLogin = authorLogin;
        this.likes = likes;
        this.views = views;
        this.createdAt = createdAt;

        this.validate();
    }

    public static Tweet build(String content, String authorId, String authorLogin) {
        return new Tweet(UUID.randomUUID().toString(),
                content,
                authorId,
                authorLogin,
                0,
                0,
                InstantUtils.now());
    }

    public static Tweet with(String id, String content, String authorId, String authorLogin, int likes, int views,
            Instant createdAt) {
        return new Tweet(UUID.randomUUID().toString(),
                id,
                authorId,
                authorLogin,
                likes,
                views,
                createdAt);
    }

    private void validate() {
        if (this.id == null) {
            throw new IllegalArgumentException("Profile id should not be null");
        }

        if (this.id.isBlank()) {
            throw new IllegalArgumentException("Profile id should not be blank");
        }

        if (this.id.length() != 36) {
            throw new IllegalArgumentException("Profile id should be a valid uuid");
        }

        if (this.content == null) {
            throw new IllegalArgumentException("Tweet content should not be null");
        }

        if (this.content.isBlank()) {
            throw new IllegalArgumentException("Tweet content should not be blank");
        }

        if (this.content.length() > 255) {
            throw new IllegalArgumentException("Tweet content should not be longer than 255 characters");
        }

        if (this.authorId == null) {
            throw new IllegalArgumentException("Tweet author id should not be null");
        }

        if (this.authorId.length() != 36) {
            throw new IllegalArgumentException("Tweet author id should be a valid uuid");
        }

        if (this.authorLogin == null) {
            throw new IllegalArgumentException("Tweet author login should not be null");
        }

        if (this.authorLogin.isBlank()) {
            throw new IllegalArgumentException("Tweet author login should not be blank");
        }
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

    public String getAuthorId() {
        return authorId;
    }

    public void setAuthorId(String authorId) {
        this.authorId = authorId;
    }

    public String getAuthorLogin() {
        return authorLogin;
    }

    public void setAuthorLogin(String authorLogin) {
        this.authorLogin = authorLogin;
    }

    public int getLikes() {
        return likes;
    }

    public int getViews() {
        return views;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }


    public void like(){
        this.likes++;
    }

    public void view(){
        this.views++;
    }

    public void dislike(){
        this.likes--;
    }

    public Instant getPastTimeSinceCreation() {
        return InstantUtils.now().minusSeconds(this.createdAt.getEpochSecond());
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tweet other = (Tweet) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }

    
}
