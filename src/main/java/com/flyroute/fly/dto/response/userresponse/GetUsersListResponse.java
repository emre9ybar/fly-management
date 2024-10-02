package com.flyroute.fly.dto.response.userresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUsersListResponse {

    private int id;

    private String name;

    private String lastname;

    private String phone;

    private String email;


}
