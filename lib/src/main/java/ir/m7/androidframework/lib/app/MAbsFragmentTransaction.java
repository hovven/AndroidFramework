package ir.m7.androidframework.lib.app;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.ViewGroup;

/**
 * Created by Milad on 8/15/2015.
 */
public abstract class MAbsFragmentTransaction extends Fragment implements IMFragmentTransaction {

    public void display(Class fragmentClass, @Nullable Bundle bundle) {
        this.display(MFragmentHolder.getFragments().get(fragmentClass).getChildFragment(), bundle);
    }

    public void display(Fragment fragment, @Nullable Bundle bundle) {
        this.display(getContainerId(), fragment, bundle);
    }

    public void display(int containerId, Fragment fragment, @Nullable Bundle bundle) {
        if (bundle != null) {
            fragment.setArguments(bundle);
        }
        replace(containerId, fragment);
    }

    public void refresh(Class fragmentClass) {
        FragmentTransaction fragTransaction = getSupportedFragmentManager().beginTransaction();
        fragTransaction.detach(MFragmentHolder.getFragments().get(fragmentClass).getChildFragment());
        fragTransaction.attach(MFragmentHolder.getFragments().get(fragmentClass).getChildFragment());
        fragTransaction.commit();
    }

    public FragmentManager getSupportedFragManager() {
        return getSupportedFragmentManager();
    }

    private void replace(int containerId, Fragment fragment) {
        if (fragment != null) {
            // getSupportedFragmentManager().beginTransaction().replace(containerId, fragment, TAG_FRAGMENT).addToBackStack(null).commit();
            getSupportedFragmentManager().beginTransaction().replace(containerId, fragment).commit();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    public void add(int containerId, Fragment fragment) {
        if (fragment != null) {
            getSupportedFragmentManager().beginTransaction().add(containerId, fragment).commit();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    public void attach(Fragment fragment) {
        if (fragment != null) {
            getSupportedFragmentManager().beginTransaction().attach(fragment).commit();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    public void show(int containerId, Fragment fragment) {
        if (fragment != null) {

            getSupportedFragmentManager().beginTransaction().show(fragment).commit();
        } else {
            // error in creating fragment
            Log.e("MainActivity", "Error in creating fragment");
        }
    }

    @Override
    public int getContainerId() {
        try {
            return ((ViewGroup) getView().getParent()).getId();
        } catch (Exception e) {
            return -1;
        }
    }

    @Override
    public FragmentManager getSupportedFragmentManager() {
        return getFragmentManager();
    }

}
