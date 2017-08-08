package ir.m7.androidframework.lib.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ir.m7.androidframework.lib.view.font.MTypeFace;

/**
 * Created by Milad on 8/17/2015.
 */
public class MViewBase {

    public static void setFont(TextView textView, Typeface typeface) {
        textView.setTypeface(typeface);
    }

    public static void setFont(View view, Typeface typeface) {
        setFont((ViewGroup) view, typeface);
    }

    public static void setFont(ViewGroup viewGroup, Typeface typeface) {
        if (viewGroup != null) {

            if (viewGroup.getChildCount() < 1)
                return;

            View view;
            TextView textView;

            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                view = viewGroup.getChildAt(i);

                if (view instanceof ViewGroup) {
                    setFont((ViewGroup) view, typeface);

                } else if (view instanceof TextView) {
                    textView = ((TextView) view);
                    textView.setTypeface(typeface);
                }

            }
        }
    }

    public static void setCurrentViewFont(Context context) {
        Typeface typeFace = MTypeFace.getTypeFace(context);
        MViewBase.setFont(getRootView(((Activity) context)), typeFace);
    }

    public static View getRootView(Activity activity) {
        return activity.getWindow().getDecorView().getRootView();
    }
}
