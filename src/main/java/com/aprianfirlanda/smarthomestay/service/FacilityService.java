package com.aprianfirlanda.smarthomestay.service;

import com.aprianfirlanda.smarthomestay.entity.Facility;

import java.util.List;

public interface FacilityService {
    List<Facility> findFacilitiesByType(String type);
}
