package com.flyroute.fly.service;

import com.flyroute.fly.dto.UserDto;
import com.flyroute.fly.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    User add(UserDto userDto);
   Optional<List<UserDto>> getAllUserList();

    Optional<User> getUserById(int id);

    User updateUser(int id, UserDto userDTO);



}
