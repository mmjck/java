package org.z.controllers.tweet.dtos.like;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;

public record UnlikeTweetResponseDto(
        String id,
        String content,
        @JsonProperty("author_id") String authorId,
        @JsonProperty("author_login") String authorLogin,
        int likes,
        int views,
        @JsonProperty("created_at") Instant createdAt) {

}
