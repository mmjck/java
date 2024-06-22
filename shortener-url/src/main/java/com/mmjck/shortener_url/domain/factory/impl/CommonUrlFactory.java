package com.mmjck.shortener_url.domain.factory.impl;

import java.time.LocalDateTime;

import com.mmjck.shortener_url.adapters.gateway.database.entities.UrlEntity;
import com.mmjck.shortener_url.domain.factory.UrlFactory;

public class CommonUrlFactory implements UrlFactory{

    @Override
    public UrlEntity create(String id, String url, LocalDateTime expiresAt){
        return  new UrlEntity(id, url, expiresAt);
    }
    
}
