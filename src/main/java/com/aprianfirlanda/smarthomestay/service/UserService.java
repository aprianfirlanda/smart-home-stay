package com.aprianfirlanda.smarthomestay.service;

import com.aprianfirlanda.smarthomestay.dto.UserDto;
import com.aprianfirlanda.smarthomestay.entity.User;

import java.util.List;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);

    List<UserDto> findAllUsers();
}
