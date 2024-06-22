package com.mmjck.shortener_url.domain.useCases.listUrl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmjck.shortener_url.adapters.gateway.UrlGateway;
import com.mmjck.shortener_url.adapters.gateway.database.entities.UrlEntity;

@Service
public class ListUrlUseCase {
    @Autowired
    private UrlGateway gateway;

    public List<UrlEntity> execute(){
        return this.gateway.listAll();
    }
}
