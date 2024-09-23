package com.flyroute.fly.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetAirlineListResponse {

    private long id;

    private String name;

    private String code;

}
