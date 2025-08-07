package com.abhi.exceptionadvice;

import com.abhi.error.ErrorDetails;
import com.abhi.exception.TouristNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class TouristErrorControllerAdvice {

    @ExceptionHandler(TouristNotFoundException.class)
    public ResponseEntity<ErrorDetails> handleTouristNotFound(TouristNotFoundException te) {
        System.out.println("TouristErrorControllerAdvice.handleTouristNotFound");
        ErrorDetails errorDetails = new ErrorDetails(te.getMessage(), LocalDateTime.now(), "HttpStatus-404 Not Found");
        return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorDetails> handleAllExceptions(Exception e) {
        System.out.println("TouristErrorControllerAdvice.handleAllExceptions");
        ErrorDetails errorDetails = new ErrorDetails(e.getMessage(), LocalDateTime.now(), "Problem occurred while execution");
        return new ResponseEntity<>(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);

    }
}
