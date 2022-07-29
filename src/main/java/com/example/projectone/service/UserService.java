package com.example.projectone.service;

import com.example.projectone.entity.UserEntity;
import com.example.projectone.exeptions.UserAlreadyExistException;
import com.example.projectone.exeptions.UserNotFoundException;
import com.example.projectone.model.User;
import com.example.projectone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public UserEntity registration(UserEntity user) throws UserAlreadyExistException{
        if (userRepo.findByUsername(user.getUsername()) != null)
            throw new UserAlreadyExistException("User with the same name already exist. ");
        return userRepo.save(user);
    }

    public User getOne(Long id) throws UserNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if (user == null){
            throw new UserNotFoundException("User not found. ");
        }
        return User.toModel(user);
    }

    public Long delete(Long id){
        userRepo.deleteById(id);
        return id;
    }
}
