package org.example.todolist.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    private Long id;
    private String task;
    private String description;
    private boolean isDone;
    private LocalDateTime createdAt;
}
