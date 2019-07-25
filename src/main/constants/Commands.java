package main.constants;

public enum Commands {
    REGISTER,
    LOGIN,
    ADD,
    REMOVE,
    REVIEW,
    CHECKOUT;

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
