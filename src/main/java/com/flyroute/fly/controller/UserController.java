package com.flyroute.fly.controller;
import com.flyroute.fly.dto.request.userre.CreateUserRequest;
import com.flyroute.fly.dto.request.userre.UpdateUserRequest;
import com.flyroute.fly.dto.request.userre.UserDeleteRequest;
import com.flyroute.fly.dto.response.userresponse.GetUsersListResponse;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.service.UserService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<CreateUserRequest> add( @RequestBody @Valid CreateUserRequest userDto) {
        userService.save(userDto);
        System.out.println("contoller çalışıyor."+userDto.getEmail());
        return ResponseEntity.ok(userDto);
    }

    @GetMapping
    public ResponseEntity<List<GetUsersListResponse>> getAllUserList() {
        List<GetUsersListResponse> userDtos = userService.getAllUsers();
        return ResponseEntity.ok(userDtos);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> userGetByIdResponse = userService.getUserById(id);
        return ResponseEntity.ok(userGetByIdResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> update(@RequestBody UpdateUserRequest updateUserRequest) {
        userService.update(updateUserRequest);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@RequestBody UserDeleteRequest deleteRequest) {
        userService.deleteById(deleteRequest.getId());
        return ResponseEntity.ok().build();
    }
}
