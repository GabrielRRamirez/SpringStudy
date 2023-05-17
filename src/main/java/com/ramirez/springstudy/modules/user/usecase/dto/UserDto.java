package com.ramirez.springstudy.modules.user.usecase.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record UserDto(

        @NotBlank(message = "login should not be empty")
        @Pattern(regexp = "\\w{4,100}", message = "login length must be between 4 and 100 characters")
        String login,

        @NotBlank(message = "password should not be empty")
        @Pattern(regexp = "\\w{4,255}", message = "password length must be between 4 and 100 characters")
        String password) {
}
