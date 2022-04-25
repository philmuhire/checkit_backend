package com.phil.checkit.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Todo {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String description;
    @OneToMany(mappedBy = "todo", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private Collection<TodoItem> todoItems = new ArrayList<>();
    private LocalDateTime duetime;
    @Enumerated(EnumType.STRING)
    private TodoStatus status;
    @ManyToOne
    private User user;
}
