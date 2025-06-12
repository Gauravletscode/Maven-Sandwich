package be.abis.MavenSandwich.Exceptions;

public class TooManyOrderedException extends Exception {
    public TooManyOrderedException(String message) {
        super(message);
    }
}
