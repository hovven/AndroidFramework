package ir.m7.androidframework.lib.app;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;

import java.util.List;

/**
 * Created by Milad on 12/9/2015.
 */
public class MFragmentHelper {

    public static List<Fragment> getFragmentList(FragmentManager fragmentManager) {
        return fragmentManager.getFragments();
    }

}
