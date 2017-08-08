package ir.m7.androidframework.lib.exceptions;

/**
 * Created by Milad on 11/7/2015.
 */
public class MFragmentExistException extends Exception {

    public MFragmentExistException(String fragmentKey, String fragmentName) {
        super(String.format("Fragment '%1s' is exist with key: '%2s'.", fragmentName, fragmentKey));
    }

    public MFragmentExistException() {
        super("Fragment is exit.");
    }
}
