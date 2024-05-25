package com.mmjck.shortener_url.controllers.services.serviceImpl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.mmjck.shortener_url.controllers.entities.UrlEntity;
import com.mmjck.shortener_url.controllers.repositories.UrlRepository;
import com.mmjck.shortener_url.controllers.services.UrlService;

@Service
public class UrlServiceImpl implements UrlService {

    @Autowired
    private  UrlRepository repository;


    @Override
    public UrlEntity save(UrlEntity data) {

        return this.repository.save(
            data);
    }

    @Override
    public List<UrlEntity> listAll() {
        throw new UnsupportedOperationException("Unimplemented method 'listAll'");
    }

    @Override
    public boolean existsById(String id) {
        return this.repository.existsById(id);
    }

}
