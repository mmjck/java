package com.mmjck.shortener_url.useCases;

import java.time.LocalDateTime;

import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mmjck.shortener_url.controllers.dto.ShortenUrlRequest;
import com.mmjck.shortener_url.controllers.dto.ShortenUrlResponse;
import com.mmjck.shortener_url.controllers.entities.UrlEntity;
import com.mmjck.shortener_url.controllers.services.UrlService;

import jakarta.servlet.http.HttpServletRequest;

@Service
public class UrlUseCase {

    @Autowired
    private UrlService service;

    public ShortenUrlResponse execute(ShortenUrlRequest request, HttpServletRequest servletRequest){
        String id;
        do {
            id = RandomStringUtils.randomAlphanumeric(5, 10);
        } while (service.existsById(id));

        var entity = new UrlEntity(id, request.url(), LocalDateTime.now().plusMinutes(1));
        this.service.save(entity);

        var redirectUrl = servletRequest.getRequestURL().toString().replace("shortener", id);

        return new ShortenUrlResponse(redirectUrl);
    }
}
