package com.flyroute.fly.exception;

import com.flyroute.fly.exception.userexception.UserExceptionNotCreated;
import com.flyroute.fly.message.UserMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GeneralExceptionHandler {
  private  final UserMessage userMessage;

    public GeneralExceptionHandler(UserMessage userMessage) {
        this.userMessage = userMessage;
    }

    @ExceptionHandler(UserExceptionNotCreated.class)
    public ResponseEntity<ProblemDetails> handleUserNotCreatedException(UserExceptionNotCreated ex, WebRequest request){
        ProblemDetails ProblemDetails = new ProblemDetails(ex.getMessage(),
                LocalDateTime.now(),
                request.getDescription(false),
                HttpStatus.CONFLICT
                );
    return  new ResponseEntity<>(ProblemDetails, HttpStatus.CONFLICT);
    }





}
