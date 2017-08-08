package ir.m7.androidframework.lib.app;

import android.support.v4.app.FragmentManager;

/**
 * Created by Milad on 8/31/2015.
 */
public interface IMFragmentTransaction {
    //void addFragment();
    int getContainerId();

    FragmentManager getSupportedFragmentManager();
}
