package com.flyroute.fly.core;

import lombok.Data;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;


@Data
public class ApiResponse<T>  {
    private Boolean success;
    private String message;
    private T i;
    private List<T> list;

    public ResponseEntity<?> getResponseJson(ApiResponse<T> apiResponse){
        return new ResponseEntity<>(this, HttpStatus.OK);
    }

    public ApiResponse(){
    }

    public ApiResponse(Boolean success, String message) {
        this.success = success;
        this.message = message;
    }

    public ApiResponse(Boolean success, String message, T i) {
        this.success = success;
        this.message = message;
        this.i = i;
    }

    public ApiResponse(Boolean success, String message, List<T> list) {
        this.success = success;
        this.message = message;
        this.list = list;
    }
}
