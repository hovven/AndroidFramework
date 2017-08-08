package ir.m7.androidframework.lib.view.font;/*
package ir.m7.a2m7.view.font;

import android.content.Context;
import android.content.ContextWrapper;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.FileNotFoundException;

public class MFontFace extends ContextWrapper {

    Typeface mTypeface;

    public MFontFace(Context base) {
        super(base);
        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/font.TTF");
    }

    public MFontFace(Context base, String fontName) throws FileNotFoundException {
        super(base);
        mTypeface = Typeface.createFromAsset(getAssets(), "fonts/" + fontName + ".TTF");
    }

    public Typeface getTypeface() {
        return mTypeface;
    }

    public void setFont(TextView textView) {
        textView.setTypeface(mTypeface);
    }

    */
/*public void setFont(@LayoutRes int layoutResID) {
        LayoutInflater mInflater = (LayoutInflater) getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        ViewGroup mViewGroup = (ViewGroup) mInflater.inflate(layoutResID, null);
//        RelativeLayout  v = (RelativeLayout) mViewGroup.findViewById(mViewGroup.getChildAt(0).getId());
        this.setFont(mViewGroup);
    }*//*



    public void setFont(View view) {
        this.setFont((ViewGroup)view);
    }

    public void setFont(ViewGroup viewGroup) {
        if (viewGroup != null) {

            if (viewGroup.getChildCount() < 1)
                return;

            View view;
            TextView textView;

            for (int i = 0; i < viewGroup.getChildCount(); i++) {
                view = viewGroup.getChildAt(i);

                if (view instanceof ViewGroup) {
                    setFont((ViewGroup) view);

                } else if (view instanceof TextView) {
                    textView = ((TextView) view);
                    textView.setTypeface(mTypeface);
                }

            }
        }
    }
}
*/
