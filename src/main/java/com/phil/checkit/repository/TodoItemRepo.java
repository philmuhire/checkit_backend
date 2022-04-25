package com.phil.checkit.repository;

import com.phil.checkit.domain.TodoItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoItemRepo extends JpaRepository<TodoItem, Long> {

}
