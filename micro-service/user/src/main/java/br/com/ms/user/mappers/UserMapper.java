package br.com.ms.user.mappers;

import br.com.ms.user.dtos.UserRecordDto;
import br.com.ms.user.model.UserModel;

public class UserMapper {
    public UserModel execute(UserRecordDto dto){
        UserModel user = new UserModel();

        return user;
    };
}
