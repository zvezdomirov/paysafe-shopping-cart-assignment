package main.exceptions;

public class UserNotRegisteredException extends Throwable {
    private String message;

    public UserNotRegisteredException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
