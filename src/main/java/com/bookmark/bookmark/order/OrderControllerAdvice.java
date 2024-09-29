package com.bookmark.bookmark.order;

import com.bookmark.bookmark.expections.ErrorResponse;
import com.bookmark.bookmark.expections.RecordNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;


@RestControllerAdvice
public class OrderControllerAdvice {
    @ExceptionHandler(OrderValidationException.class)
    public ResponseEntity<ErrorResponse> handlerValidationException(OrderValidationException e) {
        return ResponseEntity.unprocessableEntity().body(new ErrorResponse("Error", e.getMessage()));
    }

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<ErrorResponse> handlerValidationException(RecordNotFoundException e) {
        return ResponseEntity.notFound().build();
    }
}
