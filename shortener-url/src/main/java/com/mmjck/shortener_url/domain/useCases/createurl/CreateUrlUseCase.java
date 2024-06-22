package com.mmjck.shortener_url.domain.useCases.createurl;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Service;

import com.mmjck.shortener_url.adapters.controllers.model.request.ShortenUrlRequest;
import com.mmjck.shortener_url.adapters.controllers.model.response.ShortenUrlResponse;
import com.mmjck.shortener_url.adapters.gateway.UrlGateway;
import com.mmjck.shortener_url.domain.factory.UrlFactory;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class CreateUrlUseCase {

    
    private final UrlGateway gateway;
    private final UrlFactory urlFactory;
    
    public CreateUrlUseCase(UrlGateway service, UrlFactory urlFactory) {
        this.gateway = service;
        this.urlFactory = urlFactory;
    }

    public ShortenUrlResponse execute(ShortenUrlRequest request, HttpServletRequest servletRequest){
        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (gateway.existsById(id));
        
        var entity = urlFactory.create(id, request.url(), LocalDateTime.now().plusMinutes(1));
        
        this.gateway.save(entity);

        var redirectUrl = servletRequest.getRequestURL().toString().replace("shortener", id);

        return new ShortenUrlResponse(redirectUrl);
    }
}
