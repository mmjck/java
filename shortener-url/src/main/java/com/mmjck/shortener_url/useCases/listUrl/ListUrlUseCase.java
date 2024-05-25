package com.mmjck.shortener_url.useCases.listUrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmjck.shortener_url.controllers.entities.UrlEntity;
import com.mmjck.shortener_url.controllers.services.UrlService;

@Service
public class ListUrlUseCase {
    @Autowired
    private UrlService service;

    public List<UrlEntity> execute(){
        return this.service.listAll();
    }
}
