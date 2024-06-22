package com.mmjck.shortener_url.domain.useCases.redirectUrl;

import java.net.URI;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.http.HttpHeaders;
import com.mmjck.shortener_url.adapters.gateway.UrlGateway;
import com.mmjck.shortener_url.adapters.gateway.database.entities.UrlEntity;

@Service
public class RedirectUrlUseCase {
    @Autowired
    private UrlGateway gateway;

    public HttpHeaders execute(String id) throws RuntimeException {

        Optional<UrlEntity> url = gateway.findById(id);

        if (!url.isPresent()) {
            throw new RuntimeException("Url not found");
        }



        HttpHeaders headers = new org.springframework.http.HttpHeaders();
        headers.setLocation(URI.create(url.get().getFullUrl()));
        return headers;
    }
}
