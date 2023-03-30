package com.aprianfirlanda.smarthomestay.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class UserDto {

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateReq {
        @NotEmpty
        private String firstName;
        @NotEmpty
        private String lastName;
        @NotEmpty(message = "Email should not be empty")
        @Email
        private String email;
        @NotEmpty(message = "Password should not be empty")
        private String password;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class CreateError {
        private List<String> firstName;
        private List<String> lastName;
        private List<String> email;
        private List<String> password;
    }

}
