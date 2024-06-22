package com.mmjck.shortener_url.adapters.gateway.database.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.mmjck.shortener_url.adapters.gateway.database.entities.UrlEntity;


public interface UrlRepository extends MongoRepository<UrlEntity, String>{}
