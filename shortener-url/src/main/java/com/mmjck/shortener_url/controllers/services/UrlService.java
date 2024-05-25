package com.mmjck.shortener_url.controllers.services;

import java.util.List;

import com.mmjck.shortener_url.controllers.entities.UrlEntity;

public interface UrlService {
    public UrlEntity save(UrlEntity data);
    public List<UrlEntity> listAll();

    public boolean existsById(String id);
    
}
