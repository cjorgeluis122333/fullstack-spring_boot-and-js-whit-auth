package org.example.auth_multiplatform_service.controller.res.auth;

import jakarta.validation.Valid;
import org.example.auth_multiplatform_service.model.entity.UserEntity;
import org.example.auth_multiplatform_service.model.service.AuthenticationService;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import static org.example.auth_multiplatform_service.controller.utili.RequestValidation.validation;

@RestController()
@RequestMapping("/api")
public class AuthController {

    private final AuthenticationService authenticationService;

    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/register")
    ResponseEntity<?> registerUser(@Valid @RequestBody UserEntity user, BindingResult bindingResult) {
        if (bindingResult.hasErrors())
            return validation(bindingResult);
        return ResponseEntity.ok(authenticationService.register(user));
    }

}
