package com.flyroute.fly.controller;

import com.flyroute.fly.dto.request.CreateUserRequest;
import com.flyroute.fly.dto.request.UpdateUserRequest;
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
    private final   UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }
    //trylar cacth serviste yazılacak . log serviste .
    //Exception sınıfı oluşturulacak orada .
    @PostMapping
    public ResponseEntity<CreateUserRequest> add(@RequestBody CreateUserRequest userDto) {
        try {
            userService.add(userDto);
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<GetUsersListResponse>> getAllUserList() {
        try {
            List<GetUsersListResponse> userDtos = userService.getAllUserList();
            return ResponseEntity.ok(userDtos);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @GetMapping("/{id}")
    public ResponseEntity<UserGetByIdResponse> getUserById(@PathVariable long id){
       UserGetByIdResponse UserGetByIdResponse = userService.getUserById(id);
        return ResponseEntity.ok(UserGetByIdResponse) ;
    }

    @PutMapping("/{id}")
    public void update(@RequestBody UpdateUserRequest UpdateUserRequest){
        userService.updateUser(UpdateUserRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id){
        userService.deleteUser(id);
    }


}
