package com.aprianfirlanda.smarthomestay.service.impl;

import com.aprianfirlanda.smarthomestay.dto.UserDto;
import com.aprianfirlanda.smarthomestay.entity.Role;
import com.aprianfirlanda.smarthomestay.entity.User;
import com.aprianfirlanda.smarthomestay.error.clienterror.BadRequestError;
import com.aprianfirlanda.smarthomestay.repository.RoleRepository;
import com.aprianfirlanda.smarthomestay.repository.UserRepository;
import com.aprianfirlanda.smarthomestay.service.UserService;
import com.aprianfirlanda.smarthomestay.validator.UserValidator;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserValidator userValidator;
    private final RoleRepository roleRepository;
    private final PasswordEncoder passwordEncoder;

    public UserServiceImpl(UserRepository userRepository,
                           UserValidator userValidator,
                           RoleRepository roleRepository,
                           PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userValidator = userValidator;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public void saveUser(UserDto.CreateReq userDto) throws BadRequestError {
        // validate request
        userValidator.validateCreate(userDto, "Failed register user, please check again your input");

        User user = new User();
        user.setName(userDto.getFirstName() + " " + userDto.getLastName());
        user.setEmail(userDto.getEmail());
        // encrypt the password using spring security
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));

        final String ROLE_USER = "ROLE_USER";
        Role role = roleRepository.findByName(ROLE_USER);
        if (role == null) {
            role = checkRoleExist(ROLE_USER);
        }
        user.setRoles(List.of(role));
        userRepository.save(user);
    }

    private Role checkRoleExist(String name) {
        Role role = new Role();
        role.setName(name);
        return roleRepository.save(role);
    }
}