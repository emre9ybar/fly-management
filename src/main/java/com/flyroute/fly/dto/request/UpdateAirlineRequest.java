package com.flyroute.fly.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateAirlineRequest {

    private long id ;

    private String name;

    private String phone;

    private String email;

    private String country;
}
