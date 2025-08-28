package com.example.ToDoApplication.service;

import com.example.ToDoApplication.entity.Todo;
import com.example.ToDoApplication.repository.TodoRepository;
import com.example.ToDoApplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Service
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public Todo createTodo(Todo todo) {
        return todoRepository.save(todo);
    }
    @Override
    public List<Todo> getAllTodos() {
        return todoRepository.findAll(); // calls repository
    }
    @Override
    public Todo getTodobyid(long id){
        return todoRepository.findById(id).orElseThrow(()->new RuntimeException("No id exists"));
    }
    @Override
     public Todo updateTodoUser( long id,Todo todo){
        return todoRepository.save(todo);
    }
    @Override
    public Todo deleteTodobyid(long id) {
        Todo todo = todoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Todo not found with ID: " + id));
        todoRepository.deleteById(id);
        return todo;
    }

    @Override
    public Todo deleteTodo(Todo todo) {
        todoRepository.delete(todo);
        return todo;
    }
    @Override
    public Page <Todo> getalltodopagewise(int page, int size) {
        Pageable pageable= PageRequest.of(page, size);
        return todoRepository.findAll(pageable);
    }


}
