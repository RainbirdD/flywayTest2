package test1.flywayTesting.exceptions;

public class BookAlreadyExistException extends Exception {
    public BookAlreadyExistException(String errorMessage) {
        super(errorMessage);
    }
}
