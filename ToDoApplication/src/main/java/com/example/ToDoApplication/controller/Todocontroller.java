package com.example.ToDoApplication.controller;

import com.example.ToDoApplication.customresponse.ApiResponse;
import com.example.ToDoApplication.entity.Todo;
import com.example.ToDoApplication.service.TodoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/todo")
public class Todocontroller {

    public final String TODO_CREATED_SUCCESSFULLY = "Todo created successfully";

    @Autowired
    private TodoService todoService;

    @PostMapping("/create")
    public ResponseEntity<ApiResponse<Todo>> createUser(@RequestBody Todo todo) {
        Todo save = todoService.createTodo(todo);
        ApiResponse<Todo> response = new ApiResponse<>(TODO_CREATED_SUCCESSFULLY, save);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<ApiResponse<List<Todo>>> getAllTodos() {
        List<Todo> get = todoService.getAllTodos(); // calls service
        ApiResponse<List<Todo>> res = new ApiResponse<>("Todo lists are shown successfully", get);
        return new ResponseEntity<>(res, HttpStatus.FOUND);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<Todo>> getTaskByID(@PathVariable long id) {
        try {
            Todo get = todoService.getTodobyid(id); // calls service
            ApiResponse<Todo> res = new ApiResponse<>("Todo for the specified id is shown successfully", get);
            return new ResponseEntity<>(res, HttpStatus.FOUND);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<ApiResponse<Todo>> updateUser(@PathVariable long id,@RequestBody Todo todo) {
        Todo save = todoService.updateTodoUser(id,todo);
        ApiResponse<Todo> response = new ApiResponse<>("Todo updated successfully", save);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<ApiResponse<Todo>> delete(@PathVariable long id) {
        try {
            Todo deleted = todoService.deleteTodobyid(id); // fetches & deletes
            ApiResponse<Todo> res = new ApiResponse<>("Deleted ID successfully", deleted);
            return new ResponseEntity<>(res, HttpStatus.OK);
        } catch (RuntimeException e) {
            ApiResponse<Todo> errorResponse = new ApiResponse<>("Todo not found", null);
            return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
        }
    }
    @DeleteMapping
    public ResponseEntity<ApiResponse<Todo>> deleteuser(@RequestBody Todo todo) {
        Todo deleted = todoService.deleteTodo(todo); // calls repo
        ApiResponse<Todo> response = new ApiResponse<>("Deleted task successfully", deleted);
          return new ResponseEntity<>(response, HttpStatus.OK);
        }
    @GetMapping("/page")
    ResponseEntity<ApiResponse<Page<Todo>>>  getalltodopagewise(@RequestParam int page,@RequestParam int size){
        Page<Todo> pages= todoService.getalltodopagewise(page, size);
        ApiResponse<Page<Todo>> response = new ApiResponse<>("Successfully Fetched",pages);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

}



