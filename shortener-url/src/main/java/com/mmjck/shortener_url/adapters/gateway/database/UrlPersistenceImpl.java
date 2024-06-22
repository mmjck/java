package com.mmjck.shortener_url.adapters.gateway.database;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.mmjck.shortener_url.adapters.gateway.UrlGateway;
import com.mmjck.shortener_url.adapters.gateway.database.entities.UrlEntity;
import com.mmjck.shortener_url.adapters.gateway.database.repository.UrlRepository;

@Service
public class UrlPersistenceImpl implements UrlGateway {

    
    private final UrlRepository repository;
    public UrlPersistenceImpl(UrlRepository repository) {
        this.repository = repository;
    }

    @Override
    public UrlEntity save(UrlEntity data) {
        return this.repository.save(data);
    }

    @Override
    public List<UrlEntity> listAll() {
        return this.repository.findAll();
    }

    @Override
    public boolean existsById(String id) {
        return this.repository.existsById(id);
    }

    @Override
    public Optional<UrlEntity>  findById(String id) {
        return this.repository.findById(id);
    }

}
