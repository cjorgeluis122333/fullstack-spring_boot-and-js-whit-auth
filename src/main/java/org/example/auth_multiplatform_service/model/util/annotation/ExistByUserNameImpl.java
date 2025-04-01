package org.example.auth_multiplatform_service.model.util.annotation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.example.auth_multiplatform_service.model.service.UserService;
import org.springframework.stereotype.Component;

@Component
public class ExistByUserNameImpl implements ConstraintValidator<ExistByUserName, String> {

   private final UserService userService;

    public ExistByUserNameImpl(UserService service) {
        this.userService = service;
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (userService == null)
            return true;

        return !userService.existsByUsername(value);
    }
}
