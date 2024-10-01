package com.flyroute.fly.service;

import com.flyroute.fly.dto.request.userre.CreateUserRequest;
import com.flyroute.fly.dto.request.userre.UpdateUserRequest;
import com.flyroute.fly.dto.response.userresponse.GetUsersListResponse;
import com.flyroute.fly.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService  {


    User save(CreateUserRequest CreateUserRequest);

    User update(UpdateUserRequest UpdateUserRequest);

    List<GetUsersListResponse> getAllUsers();

    Optional<User> getUserById(Long id);

    void deleteById(Long id);

}
