package com.example.projectone.exeptions;

public class UserAlreadyExistException extends Exception{
    public UserAlreadyExistException(String massage) {
        super(massage);
    }
}
