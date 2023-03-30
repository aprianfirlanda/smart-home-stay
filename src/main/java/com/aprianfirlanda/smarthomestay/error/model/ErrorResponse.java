package com.aprianfirlanda.smarthomestay.error.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ErrorResponse {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Base {

        private String status;
        private String message;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class BadRequest {

        private String status;
        private String message;
        private Object errors;
    }
}
