package com.mmjck.auth_service.services;

import com.mmjck.auth_service.domain.user.entity.User;
import com.mmjck.auth_service.dto.RegisterRequestDTO;

public interface UserService {
    public User save(RegisterRequestDTO requestDTO);

    public User findByEmail(String email);

}
