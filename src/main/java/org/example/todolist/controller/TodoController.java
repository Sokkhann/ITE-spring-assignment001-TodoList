package org.example.todolist.controller;

import org.example.todolist.model.Todo;
import org.example.todolist.service.TodoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping
public class TodoController {
    private final TodoServiceImpl todoService;

    @Autowired
    public TodoController(TodoServiceImpl todoService) {
        this.todoService = todoService;
    }

    @GetMapping("/todo")
    public String displayTodoList(Model model) {
        List<Todo> todos = todoService.getAllTodos();
        model.addAttribute("todos", todos);
        return "todo-list";
    }

    @GetMapping("/details/{id}")
    public String displayTodoDetailsPage(@PathVariable Long id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "todo-details";
    }

    @GetMapping("/new")
    public String showAddTodoForm(Model model) {
        model.addAttribute("todo", new Todo());
        return "add-todo";
    }

    @PostMapping("/todo/new")
    public String addTodo(@ModelAttribute Todo todo) {
        todoService.addTodo(todo);
        return "redirect:/todo";
    }

    @GetMapping("/edit/{id}")
    public String showEditTodoForm(@PathVariable Long id, Model model) {
        Todo todo = todoService.getTodoById(id);
        model.addAttribute("todo", todo);
        return "edit-todo";
    }

    @PostMapping("/edit/{id}")
    public String editTodo(@PathVariable Long id, @ModelAttribute Todo todo) {
        todoService.editTodo(id, todo);
        return "redirect:/todo";
    }

    @GetMapping("/delete/{id}")
    public String deleteTodo(@PathVariable Long id) {
        todoService.deleteTodo(id);
        return "redirect:/todo";
    }

    @GetMapping("/search")
    public String searchTodo(@RequestParam String keyword, Model model) {
        List<Todo> searchResults = todoService.searchTodos(keyword);
        model.addAttribute("searchResults", searchResults);
        return "search-results";
    }
}
