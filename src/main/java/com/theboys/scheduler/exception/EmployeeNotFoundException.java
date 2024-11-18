package com.theboys.scheduler.exception;

public class EmployeeNotFoundException extends RuntimeException {

    // Constructor accepting a custom error message
    public EmployeeNotFoundException(String message) {
        super(message);
    }

    // Constructor accepting a custom error message and a cause
    public EmployeeNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    // Constructor accepting a cause
    public EmployeeNotFoundException(Throwable cause) {
        super(cause);
    }
}
