package com.example.security.model.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public record UserRegistrationDto(@NotBlank String username, @NotBlank String password, @NotNull String email) {
}
