package org.example.todolist.service;

import org.example.todolist.model.Todo;
import org.example.todolist.repository.TodoListDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class TodoServiceImpl implements TodoService{
    private List<Todo> todoList = new ArrayList<>();
    private long nextId = 1; // Initialize the nextId counter


    @Autowired
    public TodoServiceImpl(TodoListDataSource todoListDataSource) {
        this.todoList = todoListDataSource.todoList();
        for (Todo todo : todoList) {
            nextId = Math.max(nextId, todo.getId() + 1);
        }
    }

    @Override
    public List<Todo> getAllTodos() {
        return todoList;
    }

    @Override
    public Todo getTodoById(Long id) {
        // Implementation to get a todo by id
        // Iterate through todoList and return the todo with matching id
        return todoList.stream()
                .filter(todo -> todo.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public void addTodo(Todo todo) {
        todo.setId(nextId++);
        // Implementation to add a new todo
        todoList.add(todo);
    }

    @Override
    public void editTodo(Long id, Todo updatedTodo) {
        // Implementation to edit an existing todo
        Todo todoToUpdate = getTodoById(id);
        if (todoToUpdate != null) {
            todoToUpdate.setTask(updatedTodo.getTask());
            todoToUpdate.setDescription(updatedTodo.getDescription());
            todoToUpdate.setDone(updatedTodo.isDone());
            todoToUpdate.setCreatedAt(updatedTodo.getCreatedAt());
        }
    }

    @Override
    public void deleteTodo(Long id) {
        // Implementation to delete a todo by id
        Todo todoToDelete = getTodoById(id);
        if (todoToDelete != null) {
            todoList.remove(todoToDelete);
        }
    }

    @Override
    public List<Todo> searchTodos(String keyword) {
        List<Todo> searchResults = new ArrayList<>();
        for (Todo todo : todoList) {
            if (todo.getTask().contains(keyword) || String.valueOf(todo.isDone()).contains(keyword)) {
                searchResults.add(todo);
            }
        }
        return searchResults;
    }
}
