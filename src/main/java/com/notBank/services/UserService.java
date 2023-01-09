package com.notBank.services;

import com.notBank.dtos.UserDto;

import java.util.List;

public interface UserService {

    UserDto findById(Long id) throws Exception;

    UserDto findByEmail(String email);

    List<UserDto> findAll();

    void delete(Long id) throws Exception;

    UserDto update(UserDto dto);

    UserDto save(UserDto dto);


}
