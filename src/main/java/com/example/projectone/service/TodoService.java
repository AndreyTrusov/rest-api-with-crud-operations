package com.example.projectone.service;

import ch.qos.logback.core.joran.action.AppenderRefAction;
import com.example.projectone.entity.TodoEntity;
import com.example.projectone.entity.UserEntity;
import com.example.projectone.model.Todo;
import com.example.projectone.repository.TodoRepo;
import com.example.projectone.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TodoService {
    @Autowired
    private TodoRepo todoRepo;

    @Autowired
    private UserRepo userRepo;

    public Todo createTodo(TodoEntity todo, Long userId){
        UserEntity user = userRepo.findById(userId).get();
        todo.setUser(user);
        return Todo.toModel(todoRepo.save(todo));
    }

    public Todo complete(Long id){
        TodoEntity todo = todoRepo.findById(id).get();
        todo.setCompleted(!todo.getCompleted());
        return Todo.toModel(todoRepo.save(todo));
    }
}
