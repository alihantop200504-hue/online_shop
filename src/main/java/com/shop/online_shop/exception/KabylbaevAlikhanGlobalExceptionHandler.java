package com.shop.online_shop.exception;

import com.shop.online_shop.dto.response.KabylbaevAlikhanErrorResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.stream.Collectors;

@RestControllerAdvice
public class KabylbaevAlikhanGlobalExceptionHandler {

    @ExceptionHandler(KabylbaevAlikhanNotFoundException.class)
    public ResponseEntity<KabylbaevAlikhanErrorResponse> handleNotFound(
            KabylbaevAlikhanNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND)
                .body(new KabylbaevAlikhanErrorResponse(404, ex.getMessage(), LocalDateTime.now()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<KabylbaevAlikhanErrorResponse> handleValidation(
            MethodArgumentNotValidException ex) {
        String message = ex.getBindingResult().getFieldErrors()
                .stream()
                .map(err -> err.getField() + ": " + err.getDefaultMessage())
                .collect(Collectors.joining(", "));
        return ResponseEntity.status(HttpStatus.BAD_REQUEST)
                .body(new KabylbaevAlikhanErrorResponse(400, message, LocalDateTime.now()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<KabylbaevAlikhanErrorResponse> handleGeneral(Exception ex) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new KabylbaevAlikhanErrorResponse(500, ex.getMessage(), LocalDateTime.now()));
    }
}
