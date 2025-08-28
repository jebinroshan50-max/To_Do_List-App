package com.example.ToDoApplication.service;

import com.example.ToDoApplication.entity.Todo;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

public interface TodoService {
     Todo createTodo(Todo todo);
     List<Todo> getAllTodos() ;
     Todo getTodobyid(long id);
     Todo updateTodoUser( long id ,Todo todo);
     Todo deleteTodobyid(long id);
     public Todo deleteTodo(Todo todo);
      Page<Todo> getalltodopagewise(int page, int size);
}
