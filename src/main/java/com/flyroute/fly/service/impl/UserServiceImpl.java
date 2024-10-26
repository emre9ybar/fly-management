package com.flyroute.fly.service.impl;

import com.flyroute.fly.core.ApiResponse;
import com.flyroute.fly.core.MapperService;
import com.flyroute.fly.dto.request.userre.CreateUserRequest;
import com.flyroute.fly.dto.request.userre.UpdateUserRequest;
import com.flyroute.fly.dto.response.userresponse.GetUsersListResponse;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.repository.UserRepository;
import com.flyroute.fly.rules.UserBusinessRules;
import com.flyroute.fly.service.UserService;
import jakarta.persistence.EntityNotFoundException;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService, UserDetailsService {

    private final MapperService mapperService;
    private final UserRepository userRepository;
    private final UserBusinessRules userBusinessRules;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;



    public UserServiceImpl(MapperService mapperService, UserRepository userRepository, UserBusinessRules userBusinessRules, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.mapperService = mapperService;
        this.userRepository = userRepository;
        this.userBusinessRules = userBusinessRules;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

//1-userDetails     2-jwtservice  3-jwtautfilter  4-security- config  5- response
    @Override
    public ApiResponse<User> createUser(CreateUserRequest createUserRequest) {
        User user = User.builder()
                .name(createUserRequest.getName())
                .email(createUserRequest.getEmail())
                .password(bCryptPasswordEncoder.encode(createUserRequest.getPassword()))
                .surname(createUserRequest.getSurname())
                .phone(createUserRequest.getPhone())
                .authorities(createUserRequest.getAuthorities())
                .createdTime(LocalDateTime.now())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .isEnabled(true) // Kullanıcı etkinleştirildi mi kontrolü
                .id(1).build();
        User save = userRepository.save(user);
        return new ApiResponse<>(true,"");
    }

    @Override
    public ApiResponse<User> save(CreateUserRequest createUserRequest) {
        this.userBusinessRules.checkIfEmail(createUserRequest.getEmail());
        User user =this.mapperService.forRequest().map(createUserRequest,User.class);
        userRepository.save(user);
        ApiResponse<User> apiResponse = new ApiResponse<>(true,user.getName()+" successfully saved");
        return apiResponse;
    }

    public ApiResponse<User> update(UpdateUserRequest updateUserRequest) {
        User userFind = userRepository.findById(updateUserRequest.getId()).orElseThrow(() ->
                new RuntimeException("User not found with id: " + updateUserRequest.getId()));
        this.mapperService.forRequest().map(updateUserRequest, userFind);
        userRepository.save(userFind);
        ApiResponse<User> apiResponse = new ApiResponse<>(true, "User successfully saved");
        return apiResponse;
    }

    @Override
    public List<GetUsersListResponse> getUsersList() {
        List<User> users = userRepository.findAll();
        List<GetUsersListResponse> usersListResponses=users.stream().map(usersList ->this.mapperService.forRequest().
                map(usersList,GetUsersListResponse.class) ).toList();
        return usersListResponses;
    }


    @Override
    public Optional<User> getUserById(Long id) {
        Optional<User> user = this.userRepository.findById(id);
        return user;
    }

    @Override
    public void deleteById(Long id) {
        this.userRepository.deleteById(id);
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        Optional<User> byEmailEqualsIgnoreCase = userRepository.findByEmailEqualsIgnoreCase(email);

        return  byEmailEqualsIgnoreCase.orElseThrow(EntityNotFoundException::new);

    }



}
