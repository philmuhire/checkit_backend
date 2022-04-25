package com.phil.checkit.service;

import com.phil.checkit.domain.Todo;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TodoService {
    ResponseEntity<?> saveTodo(Todo todo);
    ResponseEntity<?> updateTodo(Todo todo);
    ResponseEntity<?> getTodosByUserId(Long id);
    void completeTodoById(Long id);

}
