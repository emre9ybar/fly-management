package com.flyroute.fly.service;

import com.flyroute.fly.core.MapperService;
import com.flyroute.fly.dto.UserDto;
import com.flyroute.fly.entity.User;
import com.flyroute.fly.message.UserMessage;
import com.flyroute.fly.repository.UserRepository;
import lombok.Data;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.nio.file.attribute.UserPrincipalNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class UserServiceImpl implements UserService {

    private final MapperService mapperService;
    private final UserRepository userRepository;

    public UserServiceImpl(MapperService mapperService, UserRepository userRepository) {
        this.mapperService = mapperService;
        this.userRepository = userRepository;
    }

    @Override
    public User add(UserDto userDto) {
       User user = this.mapperService.forRequest().map(userDto, User.class);
       return userRepository.save(user);
    }

    @Override
    public Optional<List<UserDto>> getAllUserList() {
        try {
            List<User> userList = userRepository.findAll();
            return Optional.of(userList.stream()
                    .map(user -> this.mapperService.forResponse().map(user, UserDto.class))
                    .collect(Collectors.toList()));
        } catch (Exception e) {
            throw new RuntimeException(UserMessage.USERS_NOT_FOUND);
        }
    }

    @Override
    public Optional<User> getUserById(int id ) {
        Optional<User> userFindId = userRepository.findById(id);
        if (userFindId.isEmpty()){
            throw new RuntimeException(UserMessage.USER_NOT_FOUND);
        }
        return userFindId;
    }

 /*   @Override
    public User updateUser(int id, UserUpdateDTO userUpdateDTO) {
        // Kullanıcıyı bul
        User existingUser = userRepository.findById(id)
                .orElseThrow(() -> new UserMessage(UserMessage.USER_NOT_FOUND + id));

        // DTO'dan mevcut kullanıcıya alanları haritalama
        ModelMapper modelMapper = mapper.forRequest();
        modelMapper.map(userUpdateDTO, existingUser);

        // Güncellenmiş kullanıcıyı kaydet
        return userRepository.save(existingUser);
    }*/


}






