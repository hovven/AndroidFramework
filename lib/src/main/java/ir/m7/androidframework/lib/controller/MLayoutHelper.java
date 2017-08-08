package ir.m7.androidframework.lib.controller;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

import ir.m7.androidframework.lib.view.layout.engine.MLayoutInflater;

/**
 * Created by Milad on 12/8/2015.
 */
public class MLayoutHelper {

    public static View layoutInflater(Context context, int layoutId, ViewGroup viewGroup) {
        return MLayoutInflater.inflate(context, layoutId, viewGroup);
    }
}
