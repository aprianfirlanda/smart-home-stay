package com.aprianfirlanda.smarthomestay.service;

import com.aprianfirlanda.smarthomestay.dto.UserDto;
import com.aprianfirlanda.smarthomestay.entity.User;

public interface UserService {
    void saveUser(UserDto userDto);

    User findUserByEmail(String email);
}
