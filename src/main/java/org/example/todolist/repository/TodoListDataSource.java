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
        // Initialize and return your static todo list
        List<Todo> todoList = new ArrayList<>();
        // Adding sample todos
        todoList.add(new Todo(1L, "Complete assignment", "Finish the project assignment", true, LocalDateTime.now()));
        todoList.add(new Todo(2L, "Buy groceries", "Buy fruits, vegetables, and milk", false, LocalDateTime.now()));
        todoList.add(new Todo(3L, "Go for a run", "Run for 30 minutes in the park", false, LocalDateTime.now()));
        return todoList;
    }
}
