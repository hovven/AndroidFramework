package ir.m7.androidframework.lib.telephony;

import android.content.Context;
import android.telephony.TelephonyManager;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created by Milad on 9/16/2015.
 */
public class MTelephonyManager {

    public static String getSimSerialNumber() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Class<?> c = Class.forName("android.os.SystemProperties");
        Method get = c.getMethod("get", String.class);
        String serial = (String) get.invoke(c, "ro.serialno");
        return serial;
    }

    @Deprecated
    public static String getSimSerialNumber(Context context) {
        return getTelephonyManager(context).getSimSerialNumber();
    }

    public static String getIMEI(Context context) {
        return getTelephonyManager(context).getDeviceId();
    }

    public static TelephonyManager getTelephonyManager(Context context) {
        return (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
    }
}
