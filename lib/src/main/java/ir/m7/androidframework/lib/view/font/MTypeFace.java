package ir.m7.androidframework.lib.view.font;

import android.content.Context;
import android.content.pm.PackageManager;
import android.graphics.Typeface;

import ir.m7.androidframework.lib.content.pm.MPackageManager;

/**
 * Created by Milad on 8/17/2015.
 */
public class MTypeFace {

    public static Typeface getTypeFace(Context context) {
        return getTypeFace(context, "MyriadArabic-Regular.ttf");
    }

    public static Typeface getTypeFace(Context context, String fontName) {
        try {
            Typeface typeface = Typeface.createFromAsset(context.getAssets(), "fonts/" + getFontName(context, fontName));
            if (typeface == null) {
                return Typeface.DEFAULT;
            } else {
                return typeface;
            }
        } catch (Exception e) {
            return Typeface.DEFAULT;
        }
    }

    private static String getFontName(Context context, String fontName) throws PackageManager.NameNotFoundException {
        return MPackageManager.getMetaData(context, fontName);
    }

}
