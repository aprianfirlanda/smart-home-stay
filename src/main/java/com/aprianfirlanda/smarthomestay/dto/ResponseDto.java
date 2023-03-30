package com.aprianfirlanda.smarthomestay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public class ResponseDto {

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
    public static class WithData<T> {

        private String status;
        private String message;
        private T data;
    }
}
