package com.aprianfirlanda.smarthomestay.repository;

import com.aprianfirlanda.smarthomestay.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<Role, Long> {

    Role findByName(String name);
}
