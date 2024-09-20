package com.flyroute.fly.controller;

import com.flyroute.fly.dto.UserDto;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.repository.UserRepository;
import com.flyroute.fly.service.UserService;
import lombok.AllArgsConstructor;
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


    @PostMapping
    public ResponseEntity<UserDto> add(@RequestBody UserDto userDto) {
        try {
            userService.add(userDto);
            System.out.println("eklendi");
            return ResponseEntity.status(HttpStatus.CREATED).build();
        } catch (Exception e) {
            System.out.println("kötü istek");
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUserList() {
        try {
            List<UserDto> userDtos = userService.getAllUserList();
            return ResponseEntity.ok(userDtos);
        } catch (Exception e) {
            // Log the exception
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @GetMapping("/search")
    public List<User> searchUsers(
            @RequestParam String name,//emre // COUNTRY DE tur olucak
            @RequestParam String country) {
        System.out.println("controller çalışıyor");
        return userService.getNameList(name, country);
    }



}
