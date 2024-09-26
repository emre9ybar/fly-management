package com.flyroute.fly.exception;

import com.flyroute.fly.dto.response.ExceptionResponse;
import com.flyroute.fly.exception.userexcepiton.UserNotFoundException;
import com.flyroute.fly.message.UserMessage;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDate;
import java.time.LocalDateTime;

@RestControllerAdvice
public class GeneralExceptionHandler {
  private  final UserMessage userMessage;

    public GeneralExceptionHandler(UserMessage userMessage) {
        this.userMessage = userMessage;
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ExceptionResponse> handleUserNotFoundException(UserNotFoundException message, WebRequest request){
        ExceptionResponse ExceptionResponse = new ExceptionResponse(message.getMessage(), LocalDateTime.now(),request.getDescription(false),
                userMessage.getUSER_NOT_FOUND());
    return  new ResponseEntity<>(ExceptionResponse, HttpStatus.NOT_FOUND);
    }


}
