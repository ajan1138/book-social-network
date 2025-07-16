package com.ajan.book.auth;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class RegistrationRequest {

    @NotEmpty(message = "Firstname is not entered correctly")
    @NotBlank(message = "Firstname is not entered correctly")
    private String firstName;
    @NotEmpty(message = "Lastname is not entered correctly")
    @NotBlank(message = "Lastname is not entered correctly")
    private String lastName;
    @NotEmpty(message = "Email is not entered correctly")
    @NotBlank(message = "Email is not entered correctly")
    @Email(message = "Email is not well formatted")
    private String email;
    @NotEmpty(message = "Password is not entered correctly")
    @NotBlank(message = "Password is not entered correctly")
    @Size(min = 8, message = "Password must contain at least 8 chars!")
    private String password;
}
