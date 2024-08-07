package com.security.service.Exceptions;

import org.apache.coyote.Response;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionController {

    @ExceptionHandler
    public ResponseEntity<Map<String,Object>> userNotFoundException(UserNotFoundException u){
        Map<String,Object> response = new HashMap<>();
        response.put("timespan", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        response.put("status",false);
        response.put("message", u.getMessage());

        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<Map<String,Object>> incorrectPasswordException(IncorrectPasswordException ipe){
        Map<String,Object> response = new HashMap<>();
        response.put("timespan", LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        response.put("status",false);
        response.put("message", ipe.getMessage());

        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler
    public ResponseEntity<Map<String,Object>> tokenNotValidException(TokenNotValidException te){
        Map<String,Object> response = new HashMap<>();
        response.put("timespan",LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        response.put("status",false);
        response.put("message",te.getMessage());

        return new ResponseEntity<>(response,HttpStatus.UNAUTHORIZED);
    }
    @ExceptionHandler
    public ResponseEntity<Map<String,Object>> locationIdNotFoundException(LocationIdNotFoundException le){
        Map<String,Object> response = new HashMap<>();
        response.put("timespan",LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        response.put("status",false);
        response.put("message",le.getMessage());

        return new ResponseEntity<>(response,HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler
    public ResponseEntity<Map<String,Object>> fileException(FileExceptionHandler fe){
        Map<String,Object> response = new HashMap<>();
        response.put("timespan",LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        response.put("status",false);
        response.put("message",fe.getMessage());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(ProfilePictureException.class)
    public ResponseEntity<Map<String,Object>> profilePictureException(ProfilePictureException pe){
        Map<String,Object> response = new HashMap<>();
        response.put("timespan",LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        response.put("status",false);
        response.put("message",pe.getMessage());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }
    @ExceptionHandler(CannotBeNullException.class)
    public ResponseEntity<Map<String,Object>> cannotBeNulException(CannotBeNullException cne){
        Map<String,Object> response = new HashMap<>();
        response.put("timespan",LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss")));
        response.put("status",false);
        response.put("message",cne.getMessage());

        return new ResponseEntity<>(response,HttpStatus.NOT_ACCEPTABLE);
    }
}
