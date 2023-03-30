package com.aprianfirlanda.smarthomestay.controller;

import com.aprianfirlanda.smarthomestay.dto.ResponseDto;
import com.aprianfirlanda.smarthomestay.dto.UserDto;
import com.aprianfirlanda.smarthomestay.error.clienterror.BadRequestError;
import com.aprianfirlanda.smarthomestay.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<ResponseDto.Base> registration(@RequestBody UserDto.CreateReq userDto) throws BadRequestError {
        userService.saveUser(userDto);

        ResponseDto.Base response = new ResponseDto.Base();
        response.setStatus("Success");
        response.setMessage("Register User Success");

        return ResponseEntity.ok(response);
    }
}
