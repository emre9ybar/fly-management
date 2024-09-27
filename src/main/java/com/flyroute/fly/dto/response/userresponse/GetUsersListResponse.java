package com.flyroute.fly.dto.response.userresponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GetUsersListResponse {

    private String name;

    private String phone;
}
