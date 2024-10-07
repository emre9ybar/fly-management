package com.flyroute.fly.service;

import com.flyroute.fly.core.ApiResponse;
import com.flyroute.fly.dto.request.userre.CreateUserRequest;
import com.flyroute.fly.dto.request.userre.UpdateUserRequest;
import com.flyroute.fly.dto.response.userresponse.GetUsersListResponse;
import com.flyroute.fly.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService  {


    ApiResponse save(CreateUserRequest CreateUserRequest);

    ApiResponse update(UpdateUserRequest UpdateUserRequest);


    List<GetUsersListResponse> getUsersList();
    Optional<User> getUserById(Long id);

    void deleteById(Long id);

}
