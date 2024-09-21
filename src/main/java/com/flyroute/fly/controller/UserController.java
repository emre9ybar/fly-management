package com.flyroute.fly.controller;

import com.flyroute.fly.dto.UserDto;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.message.UserMessage;
import com.flyroute.fly.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private final   UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping
    public ResponseEntity<UserDto> add(@RequestBody UserDto userDto) {
        try {
            userService.add(userDto);
            System.out.println("eklendi");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println("Kullanıcı için farklı veriler giriniz.");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<Optional<List<UserDto>>> getAllUserList() {
        try {
            Optional<List<UserDto>> userDtos = userService.getAllUserList();
            return ResponseEntity.ok(userDtos);
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById(@PathVariable int id){
        return new ResponseEntity<>(userService.getUserById(id),HttpStatus.OK);

    }



}
