package ir.m7.androidframework.lib.net.web.service;


import org.ksoap2.serialization.PropertyInfo;

import java.util.List;

/**
 * Created by Milad on 9/10/2015.
 */
public interface ISoapMaster {

    String getNameSpace();

    String getUrl();

    String getSoapAction();

    String getMethodName();

    void setMethodName(String methodName);

    String getData(List<PropertyInfo> propertyInfoList);
}
