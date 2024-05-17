package br.com.ms.user.service;

import org.springframework.stereotype.Service;

import br.com.ms.user.model.UserModel;
import br.com.ms.user.producers.UserProducer;
import br.com.ms.user.repositories.UserRepository;
import jakarta.transaction.Transactional;

@Service
public class UserService {
    final UserRepository repository;

    final UserProducer userProducer;

    public UserService(UserRepository repository, UserProducer userProducer) {
        this.repository = repository;
        this.userProducer = userProducer;
    }

    @Transactional
    public UserModel save(UserModel data){
        var user = this.repository.save(data);
        userProducer.publish(user);
        return user;
    }

}
