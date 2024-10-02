package com.flyroute.fly.controller;
import com.flyroute.fly.core.ApiResponse;
import com.flyroute.fly.dto.request.userre.CreateUserRequest;
import com.flyroute.fly.dto.request.userre.UpdateUserRequest;
import com.flyroute.fly.dto.response.userresponse.GetUsersListResponse;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.service.UserService;
import jakarta.validation.Valid;
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
    public ResponseEntity<?> add( @RequestBody @Valid CreateUserRequest CreateUserRequest) {
      ApiResponse apiResponse = userService.save(CreateUserRequest);
        return apiResponse.getResponseJson(apiResponse);
    }
    @GetMapping
    public ResponseEntity<List<GetUsersListResponse>> getAllUserList() {
        List<GetUsersListResponse> usersList = userService.getUsersList();
        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable Long id) {
        Optional<User> userGetByIdResponse = userService.getUserById(id);
        return ResponseEntity.ok(userGetByIdResponse);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UpdateUserRequest> update(@RequestBody UpdateUserRequest updateUserRequest) {
     ApiResponse apiResponse =  userService.update(updateUserRequest);
        return apiResponse.getResponseJson(apiResponse);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> delete(@PathVariable long id) {
       userService.deleteById(id);
        return ResponseEntity.ok().build();
    }
}
