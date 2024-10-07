package com.flyroute.fly.dto.request.airlinerequest;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAirlineRequest {

    @NotBlank(message = "Name is mandatory")
    @Size(min = 3, max = 20, message = "Name must be at least 3 characters long.")
    private String name;

    @NotBlank(message = "Code is mandatory")
    @Size(min = 3, max = 10, message = "Airline code must be at least 3 digits!")
    private String code;

    @NotBlank(message = "Country code is mandatory")
    @Size(min = 2, max = 2, message = "The country code must be two digits!")
    private String country;

    @NotBlank(message = "Website is mandatory")
    @Pattern(message = "Must be a valid URL starting with https://",
            regexp = "^(https?:\\/\\/)?(www\\.)?[-a-zA-Z0-9@:%._\\+~#=]{2,256}\\.[a-z]{2,6}\\b([-a-zA-Z0-9@:%_\\+.~#\\(\\)?&\\/\\/=]*)$")
    private String website;

}
