package ua.prachyk.usersAPI.exception;

public class DeleteUserWithIdException extends RuntimeException{
    public DeleteUserWithIdException(String message) {
        super(message);
    }
}
