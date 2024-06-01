package com.notification.core.gateway;

import com.notification.core.entity.Notification;


public interface NotificationGateway {
    public void create(Notification data);
    public void sendEmail(Notification dto);
}
