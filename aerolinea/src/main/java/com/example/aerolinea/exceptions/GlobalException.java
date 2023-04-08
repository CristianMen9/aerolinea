package com.example.aerolinea.exceptions;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalException {
    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<ErrorResponse> usernotFoundhandler(UserNotFoundException us, WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocaldatetime(LocalDateTime.now());
        error.setMessage(us.getMessage());
        error.setDescription(wr.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(BookingNotFoundException.class)
    public ResponseEntity<ErrorResponse> bookingNotFoundhandler(BookingNotFoundException bn, WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocaldatetime(LocalDateTime.now());
        error.setMessage(bn.getMessage());
        error.setDescription(wr.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(FlightNotFoundException.class)
    public ResponseEntity<ErrorResponse> flightNotFoundhandler(FlightNotFoundException fn, WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.NOT_FOUND.value());
        error.setLocaldatetime(LocalDateTime.now());
        error.setMessage(fn.getMessage());
        error.setDescription(wr.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }

    @ExceptionHandler(DuplicateCodigoException.class)
    public ResponseEntity<ErrorResponse> duplicateCodigoException(DuplicateCodigoException dc, WebRequest wr){
        ErrorResponse error = new ErrorResponse();
        error.setErrorCode(HttpStatus.CONFLICT.value());
        error.setLocaldatetime(LocalDateTime.now());
        error.setMessage(dc.getMessage());
        error.setDescription(wr.getDescription(false));

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
    }
    
}
