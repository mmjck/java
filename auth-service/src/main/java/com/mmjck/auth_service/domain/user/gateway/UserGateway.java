package com.mmjck.auth_service.domain.user.gateway;

import com.mmjck.auth_service.domain.user.entity.User;

public interface UserGateway {
    public User save(User user);
    public User findByEmail(String email);
}
