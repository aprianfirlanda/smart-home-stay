package com.aprianfirlanda.smarthomestay.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

public class OrderDto {

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Create {
        private String email;
        private List<Long> facilityIds;
    }

    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Find {
        private String email;
    }
}
