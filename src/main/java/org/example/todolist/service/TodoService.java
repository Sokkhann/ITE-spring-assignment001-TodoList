package org.example.todolist.service;

import org.example.todolist.model.Todo;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface TodoService {
    List<Todo> getAllTodos();
    Todo getTodoById(Long id);
    void addTodo(Todo todo);
    void editTodo(Long id, Todo todo);
    void deleteTodo(Long id);
    List<Todo> searchTodos(String keyword);
}
