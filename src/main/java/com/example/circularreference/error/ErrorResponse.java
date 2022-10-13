package com.example.circularreference.error;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ErrorResponse {

    private String statusCode;
    private String errorContent;
    private List<String> messages = new ArrayList<>();

    public ErrorResponse(String statusCode, String errorContent, String message) {
        this.statusCode = statusCode;
        this.errorContent = errorContent;
        this.messages.add(message);
    }

    public ErrorResponse(String statusCode, String errorContent, List<String> messages) {
        this.statusCode = statusCode;
        this.errorContent = errorContent;
        this.messages = messages;
    }
}
