package com.flyroute.fly.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AirlineDto {

    private long id;

    private String name;

    private String code;

    private String country;

    private String website;

}
