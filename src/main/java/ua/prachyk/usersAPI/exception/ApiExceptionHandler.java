package ua.prachyk.usersAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {CustomerNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(CustomerNotFoundException exception) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(exception.getMessage(), notFound, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, notFound);
    }



    @ExceptionHandler(value = {InvalidEmailException.class})
    public ResponseEntity<Object> handlerInvalidEmailUser(InvalidEmailException exception) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(exception.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {InvalidPhoneException.class})
    public ResponseEntity<Object> handlerInvalidPhone(InvalidPhoneException exception) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(exception.getMessage(), badRequest, ZonedDateTime.now(ZoneId.of("Z")));
        return new ResponseEntity<>(apiException, badRequest);
    }


}


















