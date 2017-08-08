package ir.m7.androidframework.lib.net.web.service.client;

import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.Transport;

import ir.m7.androidframework.lib.exceptions.MArgumentNullException;

/**
 * Created by Milad on 9/12/2015.
 */
public class SoapConnection {
    private String url;
    private String namespace;
    private String soapAction;
    private Transport transport;
    private SoapSerializationEnvelope soapSerializationEnvelope;

    public SoapConnection(String url, String namespace, String soapAction, Transport transport, SoapSerializationEnvelope soapSerializationEnvelope) {
        if (url == null) throw new MArgumentNullException("url");
        if (namespace == null) throw new MArgumentNullException("namespace");
        if (soapAction == null) throw new MArgumentNullException("soapAction");
        if (transport == null) throw new MArgumentNullException("transport");
        if (soapSerializationEnvelope == null)
            throw new MArgumentNullException("soapSerializationEnvelope");
        this.url = url;
        this.namespace = namespace;
        this.soapAction = soapAction;
        this.transport = transport;
        this.soapSerializationEnvelope = soapSerializationEnvelope;
    }

    public String getUrl() {
        return this.url;
    }

    public String getNamespace() {
        return this.namespace;
    }

    public String getSoapAction() {
        return this.soapAction;
    }

    public SoapSerializationEnvelope getSoapSerializationEnvelope() {
        return soapSerializationEnvelope;
    }

    public Transport getTransport() {
        return transport;
    }

    public SoapClient getInvoker() {
        return new SoapClient(this);
    }
}