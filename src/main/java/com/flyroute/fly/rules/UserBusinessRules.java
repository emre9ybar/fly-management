package com.flyroute.fly.rules;

import com.flyroute.fly.entity.User;
import com.flyroute.fly.exception.userexception.UserExceptionNotCreated;
import com.flyroute.fly.message.UserMessage;
import com.flyroute.fly.repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@AllArgsConstructor

public class UserBusinessRules {

    private final  UserRepository userRepository;
    public void checkIfEmail(String email){
        Optional<User> user= this.userRepository.findByEmailEqualsIgnoreCase(email);
        if (user.isPresent()){
            throw new UserExceptionNotCreated(UserMessage.EMAIL_ALREADY_EXISTS);
        }
    }
    public void checkIfUserId(long id){
        if (this.userRepository.existsById(id)){
            throw new UserExceptionNotCreated(UserMessage.USER_NOT_FOUND);
        }
    }
}
