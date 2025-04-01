package org.example.auth_multiplatform_service.model.entity.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import lombok.*;
public class UserRequestDto {
    @NotBlank
    String username;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    @NotBlank
    String password;

    public @NotBlank String getUsername() {
        return username;
    }

    public void setUsername(@NotBlank String username) {
        this.username = username;
    }

    public @NotBlank String getPassword() {
        return password;
    }

    public void setPassword(@NotBlank String password) {
        this.password = password;
    }
}
