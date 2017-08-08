package ir.m7.androidframework.lib.net.web.service.client;

import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.Transport;

import ir.m7.androidframework.lib.exceptions.MArgumentNullException;

/**
 * Created by Milad on 9/12/2015.
 */
public class SoapClient {
    private SoapConnection connection;

    public SoapClient() {

    }

    public SoapClient(SoapConnection connection) {
        this.connection = connection;
    }

    public static String invokeMethod(SoapConnection connection, String methodName, ISoapParameter[] args) {
        if (connection == null) throw new MArgumentNullException("connection");
        if (methodName == null) throw new MArgumentNullException("methodName");
        if (args == null) throw new MArgumentNullException("args");
        String url = connection.getUrl();
        String namespace = connection.getNamespace();
        String action = connection.getSoapAction();
        Transport transport = connection.getTransport();
        SoapSerializationEnvelope envelope = connection.getSoapSerializationEnvelope();

        SoapObject soapObject = new SoapObject(namespace, methodName);
        for (ISoapParameter parameter : args) {
            PropertyInfo propertyInfo = new PropertyInfo();

            propertyInfo.setName(parameter.getName());
            //Set Value
            propertyInfo.setValue(parameter.getValue());
            //Set dataType
            propertyInfo.setType(parameter.getValue().getClass());
            //Add the property to request object
            soapObject.addProperty(propertyInfo);
        }

        try {
            //Invole web service
            transport.call(action, envelope);
            //Get the response
            SoapPrimitive response = (SoapPrimitive) envelope.getResponse();
            //Return response
            return response.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static <T extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{});
    }

    public static <T extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName, T arg) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{arg});
    }

    public static <T1 extends ISoapParameter, T2 extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName, T1 arg1, T2 arg2) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{arg1, arg2});
    }

    public static <T1 extends ISoapParameter, T2 extends ISoapParameter, T3 extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName, T1 arg1, T2 arg2, T3 arg3) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{arg1, arg2, arg3});
    }

    public static <T1 extends ISoapParameter, T2 extends ISoapParameter, T3 extends ISoapParameter, T4 extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName, T1 arg1, T2 arg2, T3 arg3, T4 arg4) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{arg1, arg2, arg3, arg4});
    }

    public static <T1 extends ISoapParameter, T2 extends ISoapParameter, T3 extends ISoapParameter, T4 extends ISoapParameter, T5 extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{arg1, arg2, arg3, arg4, arg5});
    }

    public static <T1 extends ISoapParameter, T2 extends ISoapParameter, T3 extends ISoapParameter, T4 extends ISoapParameter, T5 extends ISoapParameter, T6 extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{arg1, arg2, arg3, arg4, arg5, arg6});
    }

    public static <T1 extends ISoapParameter, T2 extends ISoapParameter, T3 extends ISoapParameter, T4 extends ISoapParameter, T5 extends ISoapParameter, T6 extends ISoapParameter, T7 extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{arg1, arg2, arg3, arg4, arg5, arg6, arg7});
    }

    public static <T1 extends ISoapParameter, T2 extends ISoapParameter, T3 extends ISoapParameter, T4 extends ISoapParameter, T5 extends ISoapParameter, T6 extends ISoapParameter, T7 extends ISoapParameter, T8 extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7, T8 arg8) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8});
    }

    public static <T1 extends ISoapParameter, T2 extends ISoapParameter, T3 extends ISoapParameter, T4 extends ISoapParameter, T5 extends ISoapParameter, T6 extends ISoapParameter, T7 extends ISoapParameter, T8 extends ISoapParameter, T9 extends ISoapParameter> String invokeMethod(SoapConnection connection, String methodName, T1 arg1, T2 arg2, T3 arg3, T4 arg4, T5 arg5, T6 arg6, T7 arg7, T8 arg8, T9 arg9) {
        return invokeMethod(connection, methodName, new ISoapParameter[]{arg1, arg2, arg3, arg4, arg5, arg6, arg7, arg8, arg9});
    }

    public <T extends ISoapParameter> String invoke(String methodName) {
        return invokeMethod(this.connection, methodName, new ISoapParameter[]{});
    }

    public <T extends ISoapParameter> String invoke(String methodName, T arg) {
        return invokeMethod(this.connection, methodName, new ISoapParameter[]{arg});
    }

    public <T1 extends ISoapParameter, T2 extends ISoapParameter> String invoke(String methodName, T1 arg1, T2 arg2) {
        return invokeMethod(this.connection, methodName, new ISoapParameter[]{arg1, arg2});
    }
}
