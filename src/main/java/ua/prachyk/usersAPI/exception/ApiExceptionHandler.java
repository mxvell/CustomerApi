package ua.prachyk.usersAPI.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


import java.time.ZoneId;
import java.time.ZonedDateTime;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(value = {UsersByDateOfBirthBetweenException.class})
    public ResponseEntity<Object> handleDateOfBirthBetweenException(UsersByDateOfBirthBetweenException exception) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(exception.getMessage(),
                badRequest, ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {UserNotFoundException.class})
    public ResponseEntity<Object> handleUserNotFoundException(UserNotFoundException exception) {
        HttpStatus notFound = HttpStatus.NOT_FOUND;
        ApiException apiException = new ApiException(exception.getMessage(),
                notFound, ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, notFound);
    }

    @ExceptionHandler(value = {UnderAgeUserException.class})
    public ResponseEntity<Object> handleUnderAgeUserException(UnderAgeUserException exception) {
        HttpStatus internalServer = HttpStatus.INTERNAL_SERVER_ERROR;
        ApiException apiException = new ApiException(exception.getMessage(),
                internalServer, ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, internalServer);
    }

    @ExceptionHandler(value = {InvalidEmailException.class})
    public ResponseEntity<Object> handlerInvalidEmailUser(InvalidEmailException exception) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiException apiException = new ApiException(exception.getMessage(),
                badRequest, ZonedDateTime.now(ZoneId.of("Z"))
        );
        return new ResponseEntity<>(apiException, badRequest);
    }

}


















