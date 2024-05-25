package com.mmjck.shortener_url.controllers.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmjck.shortener_url.controllers.entities.UrlEntity;


public interface UrlRepository extends MongoRepository<UrlEntity, String>{}
