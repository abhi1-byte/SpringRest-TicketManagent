package com.abhi.error;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
public class ErrorDetails {
    private String msg;
    private LocalDateTime dateTime;
    private String status;
}
