package ir.m7.androidframework.lib.view.layout.engine;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Milad on 11/16/2015.
 */
public class MLayoutInflater {

    public static View inflate(Context context, int layoutId, ViewGroup viewGroup) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
        return inflater.inflate(layoutId, viewGroup, false);
    }
}
