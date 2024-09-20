package com.flyroute.fly.service;

import com.flyroute.fly.core.MapperService;
import com.flyroute.fly.dto.UserDto;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.repository.UserRepository;
import lombok.Data;
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
    public User add(UserDto userDto) {
        User user = this.mapperService.forRequest().map(userDto, User.class);
        System.out.println("Mapped User: " + user); // Burada user verilerini kontrol edin.
        return userRepository.save(user);
    }

    @Override
    public List<UserDto> getAllUserList() {
        List<User> userList = userRepository.findAll();
        List<UserDto> userDtos = userList.stream()
                .map(user -> this.mapperService.forResponse().map(user, UserDto.class)).
                collect(Collectors.toList());
        return userDtos;
    }

    @Override
    public List<User> getNameList(String name, String country) {
        return userRepository.findByNameAndCountry(name,country);
    }


}
