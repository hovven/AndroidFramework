package ir.m7.androidframework.lib.app;


import android.annotation.SuppressLint;
import android.support.v4.app.FragmentManager;

/**
 * Created by Milad on 9/17/2015.
 */
public class MFragmentTransaction extends MAbsFragmentTransaction {

    private int containerId;
    private FragmentManager fragmentManager;

    public MFragmentTransaction() {
    }

    @SuppressLint("ValidFragment")
    public MFragmentTransaction(int containerId, FragmentManager fragmentManager) {
        this.containerId = containerId;
        this.fragmentManager = fragmentManager;
    }

    @Override
    public FragmentManager getSupportedFragmentManager() {
        return fragmentManager;
    }

    @Override
    public int getContainerId() {
        return containerId;
    }

}
