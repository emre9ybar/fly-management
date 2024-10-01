package com.flyroute.fly.service.impl;

import com.flyroute.fly.core.MapperService;
import com.flyroute.fly.dto.request.userre.CreateUserRequest;
import com.flyroute.fly.dto.request.userre.UpdateUserRequest;
import com.flyroute.fly.dto.response.userresponse.GetUsersListResponse;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.repository.UserRepository;
import com.flyroute.fly.rules.UserBusinessRules;
import com.flyroute.fly.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.logging.Logger;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    private final MapperService mapperService;
    private final UserRepository userRepository;
    private final UserBusinessRules userBusinessRules;

    public UserServiceImpl(MapperService mapperService, UserRepository userRepository, UserBusinessRules userBusinessRules) {
        this.mapperService = mapperService;
        this.userRepository = userRepository;
        this.userBusinessRules = userBusinessRules;
    }


    @Override
    public User save(CreateUserRequest createUserRequest) {
        this.userBusinessRules.checkIfEmail(createUserRequest.getEmail());
        User user =this.mapperService.forRequest().map(createUserRequest,User.class);
        userRepository.save(user);
        log.debug("Kullanıcı kaydedildi: {}", user.getName());
        log.info("Yeni kullanıcı eklendi: {}", user.getEmail());

        return user;
    }

    @Override
    public User update(UpdateUserRequest UpdateUserRequest) {
        User user =this.mapperService.forRequest().map(UpdateUserRequest,User.class);
        userRepository.save(user);
        return user;
    }

    @Override
    public List<GetUsersListResponse> getAllUsers() {
        List<User> userList = this.userRepository.findAll();
        List<GetUsersListResponse>getUsersListResponses=userList.stream().map(users -> this.mapperService.forRequest()
                .map(users,GetUsersListResponse.class)).toList();
        return getUsersListResponses;
    }

    @Override
    public Optional<User> getUserById(Long id) {
        userBusinessRules.checkIfUserId(id);
        Optional<User> user = this.userRepository.findById(id);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }
}
