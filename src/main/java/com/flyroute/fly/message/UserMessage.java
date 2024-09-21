package com.flyroute.fly.message;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Getter
@AllArgsConstructor
public class UserMessage {
   public static final String USER_FOUND = "User has been successfully found.";
    public  static final String USER_NOT_FOUND = "User could not be found.";
 public  static final String USERS_NOT_FOUND = "Users could not be found.";
    public static final String USER_CREATED = "User has been successfully created.";
    public static final String USER_UPDATED = "User has been successfully updated.";
    public  static final String USER_DELETED = "User has been successfully deleted.";
    public static final String USER_CREATION_FAILED = "Failed to create user.";
    public static final String USER_UPDATE_FAILED = "Failed to update user.";
    public  static final String USER_DELETION_FAILED = "Failed to delete user.";



}
