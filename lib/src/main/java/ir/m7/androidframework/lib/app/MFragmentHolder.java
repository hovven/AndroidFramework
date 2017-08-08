package ir.m7.androidframework.lib.app;

import java.util.HashMap;
import java.util.Map;

import ir.m7.androidframework.lib.exceptions.MArgumentNullException;
import ir.m7.androidframework.lib.exceptions.MFragmentExistException;
import ir.m7.androidframework.lib.model.to.MFragmentIdentity;

/**
 * Created by Milad on 11/7/2015.
 */
public class MFragmentHolder {

    private static Map<Class, MFragmentIdentity> mFragmentIdentities;

    public static void putFragment(MFragmentIdentity mFragmentIdentity) throws MFragmentExistException {
        if (mFragmentIdentity == null)
            throw new MArgumentNullException("MFragmentIdentity");

        if (mFragmentIdentity.getChildFragmentClass() == null)
            throw new MArgumentNullException("ChildFragmentClass");

        if (mFragmentIdentity.getChildFragment() == null)
            throw new MArgumentNullException("ChildFragment");

        if (mFragmentIdentities == null)
            mFragmentIdentities = new HashMap<Class, MFragmentIdentity>();

        if (!mFragmentIdentities.containsKey(mFragmentIdentity.getChildFragmentClass()))
            mFragmentIdentities.put(mFragmentIdentity.getChildFragmentClass(), mFragmentIdentity);
        else
            throw new MFragmentExistException(mFragmentIdentity.getChildFragmentClass().getSimpleName(), mFragmentIdentity.getChildFragment().getClass().getSimpleName());
    }

    public static Map<Class, MFragmentIdentity> getFragments() {
        return mFragmentIdentities;
    }
}
