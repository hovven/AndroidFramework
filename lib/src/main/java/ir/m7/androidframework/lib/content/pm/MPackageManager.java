package ir.m7.androidframework.lib.content.pm;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;

/**
 * Created by Milad on 8/18/2015.
 */
public class MPackageManager {

    public static int getMetaData(Context context, String key, int defaultValue) throws PackageManager.NameNotFoundException {

        Bundle metaDataBundle = getManifestMetaData(context);
        if (metaDataBundle != null) {
            return metaDataBundle.getInt(key, defaultValue);
        } else {
            return defaultValue;
        }

    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public static String getMetaData(Context context, String key, String defaultValue) throws PackageManager.NameNotFoundException {

        Bundle metaDataBundle = getManifestMetaData(context);
        if (metaDataBundle != null) {
            return metaDataBundle.getString(key, defaultValue);
        } else {
            return defaultValue;
        }

    }

    public static String getMetaData(Context context, String key) throws PackageManager.NameNotFoundException {

        Bundle metaDataBundle = getManifestMetaData(context);
        if (metaDataBundle != null) {
            return metaDataBundle.getString(key);
        } else {
            return null;
        }

    }

    public static boolean getMetaData(Context context, String key, Boolean defaultValue) throws PackageManager.NameNotFoundException {

        Bundle metaDataBundle = getManifestMetaData(context);
        if (metaDataBundle != null) {
            return metaDataBundle.getBoolean(key, defaultValue);
        } else {
            return defaultValue;
        }

    }

    public static double getMetaData(Context context, String key, double defaultValue) throws PackageManager.NameNotFoundException {

        Bundle metaDataBundle = getManifestMetaData(context);
        if (metaDataBundle != null) {
            return metaDataBundle.getDouble(key, defaultValue);
        } else {
            return defaultValue;
        }

    }

    public static Bundle getManifestMetaData(Context context) throws PackageManager.NameNotFoundException {
        ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
        return appInfo.metaData;
    }
}
