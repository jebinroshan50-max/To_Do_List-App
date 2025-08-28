package com.example.ToDoApplication.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Todo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    long id;
    @Column(nullable = false,unique = true)
    String title;
    @Column(nullable = false,unique = true)
    String description;
    @Column(nullable = false)
    Boolean isCompleted;
}
