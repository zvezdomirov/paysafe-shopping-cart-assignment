package main.exceptions;

public class NoSuchItemException extends Throwable {
    private String message;
    public NoSuchItemException(String s) {
        this.message = s;
    }

    @Override
    public String getMessage() {
        return this.message;
    }
}
