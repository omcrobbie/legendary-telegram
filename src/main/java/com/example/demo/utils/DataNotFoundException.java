package com.example.demo.utils;

public class DataNotFoundException extends Exception {

    public <T> DataNotFoundException(String id) {
        super(String.format("id %s was not found", id));
    }

}
