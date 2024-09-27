package com.flyroute.fly.dto.request.userre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequest {

        @NotNull
        @NotBlank
        @Size(min = 3, max = 20, message = "Name must be at least 3 characters long.")
        private String name;

        @NotBlank(message = "Surname cannot be blank.")
        private String surname;

        @NotBlank(message = "Phone cannot be blank.")
        @Pattern(regexp = "\\+?[0-9]{10,15}", message = "Phone number must be valid and contain between 10 and 15 digits.")
        private String phone;

        @NotBlank(message = "Email cannot be blank.")
        @Email(message = "Email should be valid.")
        private String email;

        @NotNull(message = "Password cannot be null.")
        @NotBlank(message = "Password cannot be blank.")
        @Size(min = 8, max = 20, message = "Password must be between 8 and 20 characters.")
        @Pattern(regexp = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=]).*$",
                message = "Password must contain at least one digit, one lowercase letter, one uppercase letter, and one special character.")
        private String password;

    }


