package com.test.api.exceptions.post;

public class PostNotFoundException extends Exception {
    public PostNotFoundException(String message) {
        super(message);
    }
}
