package com.aprianfirlanda.smarthomestay.error.controller;

import com.aprianfirlanda.smarthomestay.error.clienterror.BadRequestError;
import com.aprianfirlanda.smarthomestay.error.clienterror.ForbiddenError;
import com.aprianfirlanda.smarthomestay.error.clienterror.NotFoundError;
import com.aprianfirlanda.smarthomestay.error.model.ErrorResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ErrorController {

    @ExceptionHandler({HttpMessageNotReadableException.class})
    public ResponseEntity<?> badRequestDefaultHandler(HttpMessageNotReadableException exception) {
        ErrorResponse.BadRequest responseBody = new ErrorResponse.BadRequest();
        responseBody.setStatus("Gagal");
        responseBody.setMessage(exception.getMessage());

        return ResponseEntity.status(400).body(responseBody);
    }

    @ExceptionHandler({BadRequestError.class})
    public ResponseEntity<?> badRequestCustomHandler(BadRequestError exception) {
        ErrorResponse.BadRequest responseBody = new ErrorResponse.BadRequest();
        responseBody.setStatus("Gagal");
        responseBody.setMessage(exception.getMessage());
        responseBody.setErrors(exception.getErorrs());

        return ResponseEntity.status(exception.getStatusCode()).body(responseBody);
    }

    @ExceptionHandler({ForbiddenError.class})
    public ResponseEntity<?> forbiddenError(ForbiddenError exception) {
        ErrorResponse.Base responseBody = new ErrorResponse.Base();
        responseBody.setStatus("Gagal");
        responseBody.setMessage(exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(responseBody);
    }

    @ExceptionHandler({NotFoundError.class})
    public ResponseEntity<?> notFoundError(NotFoundError exception) {
        ErrorResponse.Base responseBody = new ErrorResponse.Base();
        responseBody.setStatus("Gagal");
        responseBody.setMessage(exception.getMessage());

        return ResponseEntity.status(exception.getStatusCode()).body(responseBody);
    }
}
