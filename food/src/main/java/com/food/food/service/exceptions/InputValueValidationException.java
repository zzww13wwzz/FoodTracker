package com.food.food.service.exceptions;


public class InputValueValidationException extends Exception {
    public InputValueValidationException(String s) {
        super(s);
        System.out.println("InputValueValidationException");
    }
}