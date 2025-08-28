package com.example.ToDoApplication.repository;

import com.example.ToDoApplication.entity.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
//// TodoRepository inherits CRUD methods from JpaRepository, and Spring injects a (jpa runtime proxyclass(noneed to know spring does it just use that  obj for our todorepo))proxy object at runtime.
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
