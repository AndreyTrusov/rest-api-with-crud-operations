package com.example.projectone.exeptions;

public class UserNotFoundException extends Exception{
    public UserNotFoundException(String massage){
        super(massage);
    }
}
