package com.example.transactions.mapper;

import com.example.transactions.dto.response.UserDtoResponse;
import com.example.transactions.module.User;

public class UserMapper {

    public static UserDtoResponse userToDto(User user){
        UserDtoResponse userDtoResponse = new UserDtoResponse();

        userDtoResponse.setId(user.getId());
        userDtoResponse.setUsername(user.getUsername());

        return userDtoResponse;
    }
}
