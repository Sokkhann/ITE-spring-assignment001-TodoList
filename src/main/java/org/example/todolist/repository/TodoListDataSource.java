package org.example.todolist.repository;

import org.example.todolist.model.Todo;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Configuration
public class TodoListDataSource {

    @Bean
    public List<Todo> todoList() {
        List<Todo> todoList = new ArrayList<>();
        // Adding sample todos
        todoList.add(new Todo(1L, "Watch K-drama", "Pyramid Game", true, LocalDateTime.now()));
        todoList.add(new Todo(2L, "Relax", "Go to river side spill some tea", true, LocalDateTime.now()));
        todoList.add(new Todo(3L, "Dance Practice", "Bek sloy dance for KNY", false, LocalDateTime.now()));
        return todoList;
    }
}
