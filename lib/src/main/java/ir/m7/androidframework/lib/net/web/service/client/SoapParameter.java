package ir.m7.androidframework.lib.net.web.service.client;

/**
 * Created by Milad on 9/12/2015.
 */
public class SoapParameter<T> implements ISoapParameter {
    private String name;
    private T Value;

    public SoapParameter(String name, T value) {
        this.name = name;
        Value = value;
    }

    @Override
    public String getName() {
        return name;
    }

    public T getValue() {
        return Value;
    }
}
