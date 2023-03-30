package com.aprianfirlanda.smarthomestay.validator;

import com.aprianfirlanda.smarthomestay.dto.UserDto;
import com.aprianfirlanda.smarthomestay.entity.User;
import com.aprianfirlanda.smarthomestay.error.clienterror.BadRequestError;
import com.aprianfirlanda.smarthomestay.repository.UserRepository;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

@Component
@Slf4j
public class UserValidator {

    private final UserRepository userRepository;

    public UserValidator(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void validateCreate(UserDto.CreateReq request, String messageIfNotValid) throws BadRequestError {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();

        Set<ConstraintViolation<UserDto.CreateReq>> violations = validator.validate(request);
        log.info(request.toString());
        log.info(violations.toString());


        boolean error = false;
        List<String> firstName = new ArrayList<>();
        List<String> lastName = new ArrayList<>();
        List<String> email = new ArrayList<>();
        List<String> password = new ArrayList<>();

        for (ConstraintViolation<UserDto.CreateReq> violation : violations) {
            if (Objects.equals(violation.getPropertyPath().toString(), "firstName")) {
                firstName.add(violation.getMessage());
            }
            if (Objects.equals(violation.getPropertyPath().toString(), "lastName")) {
                lastName.add(violation.getMessage());
            }
            if (Objects.equals(violation.getPropertyPath().toString(), "email")) {
                email.add(violation.getMessage());
            }
            if (Objects.equals(violation.getPropertyPath().toString(), "password")) {
                password.add(violation.getMessage());
            }
            error = true;
        }


        User existingUser = userRepository.findByEmail(request.getEmail());

        if(existingUser != null && existingUser.getEmail() != null && !existingUser.getEmail().isEmpty()){
            email.add("There is already an account registered with the same email");
            error = true;
        }

        if (error) {
            UserDto.CreateError errors = new UserDto.CreateError();
            errors.setFirstName(firstName);
            errors.setLastName(lastName);
            errors.setEmail(email);
            errors.setPassword(password);
            throw new BadRequestError(errors, messageIfNotValid);
        }
    }
}
