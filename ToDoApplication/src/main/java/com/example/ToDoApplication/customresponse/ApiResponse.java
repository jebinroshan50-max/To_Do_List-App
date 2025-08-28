package com.example.ToDoApplication.customresponse;


// Sending custom response (message, status, data) wrapped in ResponseEntity with HTTP status code.

public class ApiResponse <T>{
     private String message;
     private T data;


    //constructors with no 1,2,3
    public ApiResponse(){

    }
    public ApiResponse( String message ) {
        this.message = message;
    }
    public ApiResponse(String message,T data){
        this.message = message;
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    //)
}
