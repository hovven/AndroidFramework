package ir.m7.androidframework.lib.exceptions;

/**
 * Created by Milad on 9/12/2015.
 */
public class MArgumentNullException extends NullPointerException {

    public MArgumentNullException(String argument) {
        super(String.format("Argument '%s' is null.", argument));
    }

    public MArgumentNullException() {
        super("Argument is null.");
    }
}
