package com.mohanish.personalaccounts.exceptions;

import com.mohanish.personalaccounts.dtos.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
@RequiredArgsConstructor
public class CustomExceptionHandler {

    private final String timeStamp = OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME);
    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEntityAlreadyExistsException(EntityAlreadyExistsException exception){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("EntityAlreadyExistsException")
                .message(exception.getMessage())
                .statusCode(HttpStatus.CONFLICT.value()) // need to return this when the same entity exists.
                .timeStamp(timeStamp)
                .build();
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ErrorResponse> handleValidationException(MethodArgumentNotValidException ex) {
        // Extract the error message from the exception
        String errorMessage ;
        FieldError fieldError  = ex.getBindingResult().getFieldError();
        if(fieldError != null && fieldError.getDefaultMessage() != null ){
            errorMessage = fieldError.getDefaultMessage();
        }else{
            errorMessage = "Validation failed for the request ";
        }
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("MethodArgumentNotValidException")
                .message(errorMessage)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timeStamp(timeStamp)
                .build();
        // Build a response entity with the error message and status code
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<ErrorResponse> handleConstraintViolationException(ConstraintViolationException ex) {
        // Extract the error message from the exception
        String errorMessage = ex.getMessage();
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("ConstraintViolationException")
                .message(errorMessage)
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .timeStamp(timeStamp)
                .build();
        // Build a response entity with the error message and status code
        return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }
}
