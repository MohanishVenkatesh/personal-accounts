package com.mohanish.personalaccounts.exceptions;

import com.mohanish.personalaccounts.dtos.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(EntityAlreadyExistsException.class)
    public ResponseEntity<ErrorResponse> handleEntityAlreadyExistsException(EntityAlreadyExistsException exception){
        ErrorResponse errorResponse = ErrorResponse.builder()
                .error("EntityAlreadyExistsException")
                .message(exception.getMessage())
                .statusCode(HttpStatus.CONFLICT.value())
                .timeStamp(OffsetDateTime.now().format(DateTimeFormatter.ISO_OFFSET_DATE_TIME))
                .build();
        return new ResponseEntity<>(errorResponse,HttpStatus.CONFLICT);
    }
}
