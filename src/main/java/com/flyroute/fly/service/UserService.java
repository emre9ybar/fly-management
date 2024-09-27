package com.flyroute.fly.service;

import com.flyroute.fly.dto.request.userre.CreateUserRequest;
import com.flyroute.fly.dto.request.userre.UpdateUserRequest;
import com.flyroute.fly.dto.response.userresponse.GetUsersListResponse;
import com.flyroute.fly.dto.response.userresponse.UserGetByIdResponse;
import com.flyroute.fly.entity.User;

import java.util.List;

public interface UserService {

    User add(CreateUserRequest CreateUserRequest);
    List<GetUsersListResponse> getAllUserList();
    void updateUser(UpdateUserRequest UpdateUserRequest);
    UserGetByIdResponse getUserById(long id);
    void deleteUser(long  id);

    }
