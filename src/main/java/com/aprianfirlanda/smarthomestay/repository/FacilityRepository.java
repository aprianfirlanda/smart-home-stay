package com.aprianfirlanda.smarthomestay.repository;

import com.aprianfirlanda.smarthomestay.entity.Facility;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FacilityRepository extends JpaRepository<Facility,Long> {

    List<Facility> findFacilitiesByType(String type);
}
