package com.flyroute.fly.service.impl;

import com.flyroute.fly.core.MapperService;
import com.flyroute.fly.dto.request.CreateUserRequest;
import com.flyroute.fly.dto.request.UpdateUserRequest;
import com.flyroute.fly.dto.response.GetUsersListResponse;
import com.flyroute.fly.dto.response.UserGetByIdResponse;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.repository.UserRepository;
import com.flyroute.fly.service.UserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final MapperService mapperService;
    private  final UserRepository userRepository;

    public UserServiceImpl(MapperService mapperService, UserRepository userRepository) {
        this.mapperService = mapperService;
        this.userRepository = userRepository;
    }


    @Override
    public User add(CreateUserRequest CreateUserRequest) {
        User user = this.mapperService.forRequest().map(CreateUserRequest, User.class);
        return userRepository.save(user);
    }

    @Override
    public List<GetUsersListResponse> getAllUserList() {
        List<User> users = userRepository.findAll();
        List<GetUsersListResponse> usersListResponses = users.stream().map(user -> mapperService.forResponse().map(user,GetUsersListResponse.class)).
                collect(Collectors.toList());
        return usersListResponses;
    }

    @Override
    public void updateUser(UpdateUserRequest CreateUserRequest) {
        User user = this.mapperService.forRequest().map(CreateUserRequest, User.class);
       this.userRepository.save(user);

    }

    @Override
    public UserGetByIdResponse getUserById(long id) {
       User user = userRepository.findById(id).orElseThrow();
       UserGetByIdResponse getByIdResponse = mapperService.forResponse().map(user,UserGetByIdResponse.class);

        return getByIdResponse;
    }

    @Override
    public void deleteUser(long id) {
     userRepository.deleteById(id);

    }




}
