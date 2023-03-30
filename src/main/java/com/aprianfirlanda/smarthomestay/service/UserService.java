package com.aprianfirlanda.smarthomestay.service;

import com.aprianfirlanda.smarthomestay.dto.UserDto;
import com.aprianfirlanda.smarthomestay.error.clienterror.BadRequestError;

public interface UserService {
    void saveUser(UserDto.CreateReq userDto) throws BadRequestError;
}
