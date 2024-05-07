package ua.prachyk.usersAPI.exception;

public class UnderAgeUserException extends RuntimeException {
    public UnderAgeUserException(String message) {
        super(message);
    }
}
