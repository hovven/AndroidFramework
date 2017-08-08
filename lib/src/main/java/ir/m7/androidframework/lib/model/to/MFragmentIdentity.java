package ir.m7.androidframework.lib.model.to;

import android.support.v4.app.Fragment;

/**
 * Created by Milad on 12/9/2015.
 */
public class MFragmentIdentity {

    private Fragment childFragment;
    private Class parentFragmentClass;
    private Class childFragmentClass;

    public MFragmentIdentity(Fragment childFragment, Class childFragmentClass, Class parentFragmentClass) {
        this.childFragment = childFragment;
        this.parentFragmentClass = parentFragmentClass;
        this.childFragmentClass = childFragmentClass;
    }

    public Fragment getChildFragment() {
        return childFragment;
    }

    public Class getParentFragmentClass() {
        return parentFragmentClass;
    }

    public Class getChildFragmentClass() {
        return childFragmentClass;
    }
}
