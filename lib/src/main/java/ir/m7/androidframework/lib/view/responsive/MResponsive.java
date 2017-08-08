package ir.m7.androidframework.lib.view.responsive;

import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import ir.m7.androidframework.lib.exceptions.MArgumentNullException;

/**
 * Created by Milad on 10/23/2014.
 */
public class MResponsive {

    public static MResponsive mResponsiveInstance;
    private float mTargetHeight;
    private float mTargetWidth;
    private float mOriginalWidth = 720f;
    private float mOriginalHeight = 1280f;
    private float mAspectRatio;
    private float mWidthRatio;
    private float mHeightRatio;
    private Context context;

    private MResponsive(Context context) {
        this.context = context;
        getDisplaySize();
        aspectRatioCalculator();
    }

    private MResponsive(Context context, float originalWidth, float originalHeight) {
        this(context);
        this.mOriginalWidth = originalWidth;
        this.mOriginalHeight = originalHeight;
    }

    public static void init(Context context) {
        if (mResponsiveInstance == null)
            mResponsiveInstance = new MResponsive(context);
    }

    public static void init(Context context, float originalWidth, float originalHeight) {
        if (mResponsiveInstance == null)
            mResponsiveInstance = new MResponsive(context, originalWidth, originalHeight);
    }

    public static MResponsive getInstance() {
        if (mResponsiveInstance == null)
            throw new MArgumentNullException("mResponsiveInstance");
        else return mResponsiveInstance;
    }

    private void aspectRatioCalculator() {
        mWidthRatio = mTargetWidth / mOriginalWidth;
        mHeightRatio = mTargetHeight / mOriginalHeight;
        mAspectRatio = Math.min(mHeightRatio, mHeightRatio);
    }

    private void getDisplaySize() {
        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB_MR2) {
            Point point = new Point();
            display.getSize(point);
            mTargetHeight = point.y;
            mTargetWidth = point.x;
        } else {
            mTargetHeight = display.getHeight();
            mTargetWidth = display.getHeight();
        }

    }

    public int convertDpToPixel(float dp) {
        DisplayMetrics metrics = context.getResources().getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return (int) px;
    }

    public float getHeightRatio() {
        return mHeightRatio;
    }

    public float getWidthRatio() {
        return mWidthRatio;
    }

    public float getAspectRatio() {
        return mAspectRatio;
    }

    public void resize(View view, float width, float height) {
        if (width != 0)
            view.getLayoutParams().width = (int) (width * mAspectRatio);
        if (height != 0)
            view.getLayoutParams().height = (int) (height * mAspectRatio);
        if (view instanceof ImageView)
            ((ImageView) view).setAdjustViewBounds(true);
    }

    public void setMargins(View view, float top, float bottom, float right, float left) {
        top = (top * mHeightRatio);
        bottom = (bottom * mHeightRatio);
        right = (right * mWidthRatio);
        left = (left * mWidthRatio);

        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins((int) left, (int) top, (int) right, (int) bottom);
        view.setLayoutParams(marginLayoutParams);
    }

    public void padding(View view, float top, float bottom, float right, float left) {
        top = (top * mHeightRatio);
        bottom = (bottom * mHeightRatio);
        right = (right * mWidthRatio);
        left = (left * mWidthRatio);

        view.setPadding((int) left, (int) top, (int) right, (int) bottom);
    }

    public void centerHorizontal(View view, float top, float bottom) {
        top = (top * mHeightRatio);
        bottom = (bottom * mHeightRatio);
        float margin = (mTargetWidth - (view.getLayoutParams().width * mAspectRatio)) / 2;

        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins((int) margin, (int) top, (int) margin, (int) bottom);
        view.setLayoutParams(marginLayoutParams);
    }

    public void centerVertical(View view, float left, float right) {
        left = (left * mWidthRatio);
        right = (right * mWidthRatio);
        float margin = (mTargetHeight - (view.getLayoutParams().height * mAspectRatio)) / 2;

        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.setMargins((int) left, (int) margin, (int) right, (int) margin);
        view.setLayoutParams(marginLayoutParams);
    }

    public void textSize(TextView textView, float fontSize) {
        float newSize = fontSize * mAspectRatio; // new size is twice bigger than default one
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, newSize);
    }
}
