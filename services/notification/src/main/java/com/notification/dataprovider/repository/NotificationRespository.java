package com.notification.dataprovider.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.notification.core.entity.Notification;

public interface NotificationRespository extends MongoRepository<Notification, String>{

}
