package com.flyroute.fly.dto.request.userre;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UpdateUserRequest {

    private Long id;

    private String name;

    private String phone;

    private String email;

    private String country;
}
