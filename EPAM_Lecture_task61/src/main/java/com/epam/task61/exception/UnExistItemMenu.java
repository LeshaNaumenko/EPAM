package com.epam.task61.exception;

public class UnExistItemMenu extends RuntimeException {
    public UnExistItemMenu(String message) {
        super(message);
    }
}
