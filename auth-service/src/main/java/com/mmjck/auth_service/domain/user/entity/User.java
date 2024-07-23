package com.mmjck.auth_service.domain.user.entity;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class User {
    private String id;

    private String name;
    private String password;
    private String email;

    private User(String id, String name, String password, String email) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.email = email;
    }


    public static User build(String name, String password, String email) {
        return new User(null, name, password, email);
    }

    public static User with(String id, String name, String password, String email) {
        return new User(id, name, password, email);
    }

    public static User expose(String id, String name, String email) {
        return new User(id, name, null, email);
    }

}
