package ir.m7.androidframework.lib.net.web.service.client;

import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;
import org.ksoap2.transport.Transport;

/**
 * Created by Milad on 9/12/2015.
 */
public class SoapConnectionFactoryHelper {
    protected static String CreateUrl(String host, String route, String serviceName) {
        return String.format("%s/%s/%s", host, route, serviceName);
    }

    protected static SoapSerializationEnvelope DefaultEnvelope() {
        return new SoapSerializationEnvelope(SoapVersion.VER11.getValue());
    }

    protected static SoapSerializationEnvelope DefaultEnvelopeDotNet() {
        SoapSerializationEnvelope envel = new SoapSerializationEnvelope(SoapVersion.VER11.getValue());
        envel.dotNet = true;
        return envel;
    }

    protected static SoapSerializationEnvelope DefaultEnvelope(SoapVersion version) {
        return new SoapSerializationEnvelope(version.getValue());
    }

    protected static SoapSerializationEnvelope DefaultEnvelope(SoapVersion version, boolean isDotNet) {
        SoapSerializationEnvelope envel = new SoapSerializationEnvelope(version.getValue());
        envel.dotNet = isDotNet;
        return envel;
    }

    protected static SoapConnection CreateDotNet(String url, String namespaceAndAction) {
        return new SoapConnection(url, namespaceAndAction, namespaceAndAction, new HttpTransportSE(url), DefaultEnvelopeDotNet());
    }

    protected static SoapConnection Create(String url, String namespaceAndAction) {
        return new SoapConnection(url, namespaceAndAction, namespaceAndAction, new HttpTransportSE(url), DefaultEnvelope());
    }

    protected static SoapConnection Create(String url, String namespaceAndAction, Transport transport) {
        return new SoapConnection(url, namespaceAndAction, namespaceAndAction, transport, DefaultEnvelope());
    }

    protected static SoapConnection Create(String url, String namespaceAndAction, Transport transport, SoapSerializationEnvelope soapSerializationEnvelope) {
        return new SoapConnection(url, namespaceAndAction, namespaceAndAction, transport, soapSerializationEnvelope);
    }

    protected static SoapConnection CreateDotNet(String url, String namespace, String action) {
        return new SoapConnection(url, namespace, action, new HttpTransportSE(url), DefaultEnvelopeDotNet());
    }

    protected static SoapConnection Create(String url, String namespace, String action) {
        return new SoapConnection(url, namespace, action, new HttpTransportSE(url), DefaultEnvelope());
    }

    protected static SoapConnection Create(String url, String namespace, String action, Transport transport) {
        return new SoapConnection(url, namespace, action, transport, DefaultEnvelope());
    }

    protected static SoapConnection Create(String url, String namespace, String action, Transport transport, SoapSerializationEnvelope soapSerializationEnvelope) {
        return new SoapConnection(url, namespace, action, transport, soapSerializationEnvelope);
    }

    public enum SoapVersion {
        VER10(100), VER11(110), VER12(120);

        private final int value;

        private SoapVersion(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }
}
