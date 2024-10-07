package com.flyroute.fly.exception;

import com.flyroute.fly.exception.userexception.UserExceptionNotCreated;
import com.flyroute.fly.message.UserMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, String>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage())
        );
        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }

}
