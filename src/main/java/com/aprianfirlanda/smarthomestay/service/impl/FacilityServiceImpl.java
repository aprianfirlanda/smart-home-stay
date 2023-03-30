package com.aprianfirlanda.smarthomestay.service.impl;

import com.aprianfirlanda.smarthomestay.entity.Facility;
import com.aprianfirlanda.smarthomestay.repository.FacilityRepository;
import com.aprianfirlanda.smarthomestay.service.FacilityService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FacilityServiceImpl implements FacilityService {

    private final FacilityRepository facilityRepository;

    public FacilityServiceImpl(FacilityRepository facilityRepository) {
        this.facilityRepository = facilityRepository;
    }

    @Override
    public List<Facility> findFacilitiesByType(String type) {
        return facilityRepository.findFacilitiesByType(type);
    }
}
