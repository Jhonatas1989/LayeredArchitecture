package com.oliveira.layered.arch.response;

import lombok.Data;

@Data
public class ErrorResponse {

    private String message;
    private String code;

    public ErrorResponse(String message, String code) {
        super();
        this.message = message;
        this.code = code;
    }
}
