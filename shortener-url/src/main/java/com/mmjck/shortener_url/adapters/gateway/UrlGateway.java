package com.mmjck.shortener_url.adapters.gateway;

import java.util.List;
import java.util.Optional;

import com.mmjck.shortener_url.adapters.gateway.database.entities.UrlEntity;

public interface UrlGateway {
    public UrlEntity save(UrlEntity data);
    public List<UrlEntity> listAll();

    public boolean existsById(String id);
    public Optional<UrlEntity> findById(String id);
    
}
