package com.flyroute.fly.service;

import com.flyroute.fly.dto.UserDto;
import com.flyroute.fly.entity.User;

import java.util.List;

public interface UserService {

    User add(UserDto userDto);
    List<UserDto> getAllUserList();

    List<User> getNameList(String name,String country);


    }
