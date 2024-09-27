package com.flyroute.fly.exception.userexception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserExceptionNotCreated extends RuntimeException {
    public UserExceptionNotCreated(String message){
        super(message);
    }


}
