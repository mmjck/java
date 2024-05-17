package br.com.ms.user.service;

import org.springframework.stereotype.Service;

import br.com.ms.user.model.UserModel;
import br.com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    final UserRepository repository;

    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    @Transactional
    public UserModel save(UserModel user){
        return this.repository.save(user);
    }

}
