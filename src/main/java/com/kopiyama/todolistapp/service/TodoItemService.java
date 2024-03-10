package com.kopiyama.todolistapp.service;

import com.kopiyama.todolistapp.model.TodoItem;
import com.kopiyama.todolistapp.repository.TodoItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TodoItemService {
    @Autowired
    private TodoItemRepository todoItemRepository;

    public List<TodoItem> getAllTodoItems(){
        return todoItemRepository.findAll();
    }

    public TodoItem createTodoItem(TodoItem todoItem){
        return todoItemRepository.save(todoItem);
    }

    public TodoItem updateTodoItem(Long id, TodoItem todoItemDetails){
        TodoItem todoItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TodoItem not found with id" + id));

        todoItem.setTitle(todoItemDetails.getTitle());
        todoItem.setDescription(todoItemDetails.getDescription());
        todoItem.setStatus(todoItemDetails.getStatus());

        return todoItemRepository.save(todoItem);
    }

    public void deleteTodoItem(Long id){
        TodoItem todoItem = todoItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("TodoItem not found with id" + id));

        todoItemRepository.delete(todoItem);
    }


}
