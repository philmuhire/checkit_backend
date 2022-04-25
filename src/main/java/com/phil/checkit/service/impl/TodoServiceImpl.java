package com.phil.checkit.service.impl;

import com.phil.checkit.domain.Todo;
import com.phil.checkit.service.TodoService;
import org.springframework.http.ResponseEntity;

public class TodoServiceImpl implements TodoService {
    @Override
    public ResponseEntity<?> saveTodo(Todo todo) {
        return null;
    }

    @Override
    public ResponseEntity<?> updateTodo(Todo todo) {
        return null;
    }

    @Override
    public ResponseEntity<?> getTodosByUserId(Long id) {
        return null;
    }

    @Override
    public void completeTodoById(Long id) {

    }
}
