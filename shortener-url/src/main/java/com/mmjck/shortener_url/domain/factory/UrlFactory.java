package com.mmjck.shortener_url.domain.factory;

import java.time.LocalDateTime;

import com.mmjck.shortener_url.adapters.gateway.database.entities.UrlEntity;

public interface UrlFactory {
    UrlEntity create(String id, String url, LocalDateTime expiresAt);
}
