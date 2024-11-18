package com.theboys.scheduler.exception;

public class AttendanceNotFoundException extends RuntimeException {

    // Constructor accepting a custom error message
    public AttendanceNotFoundException(String message) {
        super(message);
    }
}
