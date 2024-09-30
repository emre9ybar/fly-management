package com.flyroute.fly.service.impl;

import com.flyroute.fly.dto.request.userre.CreateUserRequest;
import com.flyroute.fly.dto.request.userre.UpdateUserRequest;
import com.flyroute.fly.dto.response.userresponse.GetUsersListResponse;
import com.flyroute.fly.dto.response.userresponse.UserGetByIdResponse;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.service.UserService;

import java.util.List;
import java.util.Optional;

public class x implements UserService {
    @Override
    public User save(CreateUserRequest t) {
        return null;
    }

    @Override
    public User update(UpdateUserRequest updateUserRequest) {
        return null;
    }

    @Override
    public List<GetUsersListResponse> findAll() {
        return List.of();
    }

    @Override
    public Optional<UserGetByIdResponse> findById(int id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(int id) {

    }
}
