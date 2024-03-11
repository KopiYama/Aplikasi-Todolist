package com.kopiyama.todolistapp.controller;

import com.kopiyama.todolistapp.model.TodoItem;
import com.kopiyama.todolistapp.service.TodoItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todoitems")
public class TodoItemController {

    @Autowired
    private TodoItemService todoItemService;

    @GetMapping
    public List<TodoItem> getAllTodoItems(@RequestParam(value = "status", required = false) Boolean status) {
        return todoItemService.getAllTodoItems(status);
    }

    @PostMapping
    public TodoItem createTodoItem(@RequestBody TodoItem todoItem) {
        return todoItemService.createTodoItem(todoItem);
    }

    @PutMapping("/{id}")
    public TodoItem updateTodoItem(@PathVariable Long id, @RequestBody TodoItem todoItemDetails) {
        return todoItemService.updateTodoItem(id, todoItemDetails);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteTodoItem(@PathVariable Long id) {
        todoItemService.deleteTodoItem(id);
        return ResponseEntity.ok().build();
    }
}
