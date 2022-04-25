package com.phil.checkit.repository;

import com.phil.checkit.domain.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepo extends JpaRepository<Todo, Long> {
    Todo getTodoByTitle(String title);
    List<Todo> getTodosByUserId(Long id);
}
