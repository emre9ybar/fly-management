package com.flyroute.fly.service;

import com.flyroute.fly.dto.request.CreateUserRequest;
import com.flyroute.fly.dto.request.UpdateUserRequest;
import com.flyroute.fly.dto.response.GetUsersListResponse;
import com.flyroute.fly.dto.response.UserGetByIdResponse;
import com.flyroute.fly.entity.User;

import java.util.List;

public interface UserService {

    User add(CreateUserRequest CreateUserRequest);
    List<GetUsersListResponse> getAllUserList();
    void updateUser(UpdateUserRequest UpdateUserRequest);
    UserGetByIdResponse getUserById(long id);
    void deleteUser(long  id);

    }
