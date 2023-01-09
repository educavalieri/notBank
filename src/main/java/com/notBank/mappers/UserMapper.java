package com.notBank.mappers;

import com.notBank.dtos.UserDto;
import com.notBank.entities.User;
import lombok.*;

public class UserMapper {

    public static User toEntity(UserDto dto){
        User user = User
                .builder()
                .name(dto.getName())
                .email(dto.getEmail())
                .password(dto.getPassword())
                .build();
        return user;
    }

    public static UserDto toDto(User user){
        UserDto dto = UserDto
                .builder()
                .name(user.getName())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
        return dto;
    }

}
