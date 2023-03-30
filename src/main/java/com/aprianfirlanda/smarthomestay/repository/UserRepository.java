package com.aprianfirlanda.smarthomestay.repository;

import com.aprianfirlanda.smarthomestay.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    User findByEmail(String email);

}
