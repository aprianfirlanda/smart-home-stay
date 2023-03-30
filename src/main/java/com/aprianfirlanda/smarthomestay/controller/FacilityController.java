package com.aprianfirlanda.smarthomestay.controller;

import com.aprianfirlanda.smarthomestay.dto.ResponseDto;
import com.aprianfirlanda.smarthomestay.entity.Facility;
import com.aprianfirlanda.smarthomestay.service.FacilityService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/facilities")
public class FacilityController {

    private final FacilityService facilityService;

    public FacilityController(FacilityService facilityService) {
        this.facilityService = facilityService;
    }

    @GetMapping("/{type}")
    public ResponseEntity<ResponseDto.WithData<List<Facility>>> findFacilitiesByType(@PathVariable String type) {
        ResponseDto.WithData<List<Facility>> response = new ResponseDto.WithData<>();
        response.setStatus("Success");
        response.setMessage("Successfully get facilities by type");
        response.setData(facilityService.findFacilitiesByType(type));

        return ResponseEntity.ok(response);
    }
}