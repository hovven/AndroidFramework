package ir.m7.androidframework.lib.net.web.service;

import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.PropertyInfo;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import java.util.List;

/**
 * Created by Milad on 9/5/2015.
 */

public abstract class SoapMaster implements ISoapMaster {

    private String methodName;

    public SoapMaster() {
    }

    public SoapMaster(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    @Override
    public String getSoapAction() {
        return getNameSpace() + getMethodName();
    }

    @Override
    public String getData(List<PropertyInfo> propertyInfoList) {

        //Create request
        SoapObject soapObject = new SoapObject(getNameSpace(), getMethodName());

        setProperties(propertyInfoList, soapObject);

        //Create envelope
        SoapSerializationEnvelope soapSerializationEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
        soapSerializationEnvelope.dotNet = true;
        //Set output SOAP object
        // TODO. dsafsfsf
        soapSerializationEnvelope.setOutputSoapObject(soapObject);
        //Create HTTP call object
        HttpTransportSE androidHttpTransport = new HttpTransportSE(getUrl());

        try {
            //Invole web service
            androidHttpTransport.call(getSoapAction(), soapSerializationEnvelope);
            //Get the response
            SoapPrimitive response = (SoapPrimitive) soapSerializationEnvelope.getResponse();
            //Return response
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return "Error";
        }
    }

    private void setProperties(List<PropertyInfo> list, SoapObject soapObject) {
        for (PropertyInfo propertyInfo : list) {
            //Add the property to request object
            soapObject.addProperty(propertyInfo);
        }
        list.clear();
    }
}
