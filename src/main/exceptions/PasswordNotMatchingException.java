package main.exceptions;

public class PasswordNotMatchingException extends Throwable {
    private String message;

    public PasswordNotMatchingException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
