package ir.m7.androidframework.lib;

/**
 * Created by Milad on 9/5/2015.
 */
public interface IContextual<T> {

    T getValue();

    void setValue(T... t);
}