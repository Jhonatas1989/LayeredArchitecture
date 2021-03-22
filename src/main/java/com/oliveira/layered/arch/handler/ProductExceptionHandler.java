package com.oliveira.layered.arch.handler;

import com.oliveira.layered.arch.exception.ProductNotFoundException;
import com.oliveira.layered.arch.response.ErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class ProductExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
        ErrorResponse error = new ErrorResponse("Product Not Found", "product.not.found");
        return new ResponseEntity(error, HttpStatus.NOT_FOUND);
    }

}
