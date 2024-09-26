package com.flyroute.fly.controller;

import com.flyroute.fly.dto.request.CreateUserRequest;
import com.flyroute.fly.dto.request.UpdateUserRequest;
import com.flyroute.fly.dto.request.UserDeleteRequest;
import com.flyroute.fly.dto.response.GetUsersListResponse;
import com.flyroute.fly.dto.response.UserGetByIdResponse;
import com.flyroute.fly.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody CreateUserRequest userDto) {
        userService.add(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<List<GetUsersListResponse>> getAllUserList() {
        List<GetUsersListResponse> userDtos = userService.getAllUserList();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetByIdResponse> getUserById(@PathVariable long id) {
        UserGetByIdResponse userGetByIdResponse = userService.getUserById(id);
        return ResponseEntity.ok(userGetByIdResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> update(@RequestBody UpdateUserRequest updateUserRequest) {
        userService.updateUser(updateUserRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@RequestBody UserDeleteRequest deleteRequest) {
        userService.deleteUser(deleteRequest.getId());
        return ResponseEntity.ok().build();
    }
}
