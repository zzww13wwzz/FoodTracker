package com.food.food.service.exceptions;

public class ListIsEmptyException extends RuntimeException {
    public ListIsEmptyException(String s) {
        super(s);
    }
}
