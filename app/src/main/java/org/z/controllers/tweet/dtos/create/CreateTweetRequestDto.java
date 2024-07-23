package org.z.controllers.tweet.dtos.create;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateTweetRequestDto(
    @JsonProperty("author_login") String authorLogin,
    String content
) {
    
}
