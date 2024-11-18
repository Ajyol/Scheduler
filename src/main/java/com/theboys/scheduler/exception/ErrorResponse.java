package com.theboys.scheduler.exception;

import lombok.Getter;
import lombok.Setter;

public class ErrorResponse {

    @Getter
    @Setter
    private int status;

    @Getter
    @Setter
    private String message;

    @Getter
    @Setter
    private long timestamp;

    public ErrorResponse(int status, String message, long timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }


}
