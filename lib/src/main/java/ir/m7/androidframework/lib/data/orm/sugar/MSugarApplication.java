package ir.m7.androidframework.lib.data.orm.sugar;

import com.orm.SugarApp;

import ir.m7.androidframework.lib.app.MFragmentHolder;
import ir.m7.androidframework.lib.exceptions.MFragmentExistException;
import ir.m7.androidframework.lib.model.to.MFragmentIdentity;

/*
 * Created by Milad on 11/7/2015.
 */

public class MSugarApplication extends SugarApp {

    public void registerFragment(MFragmentIdentity mFragmentIdentity) {
        try {
            MFragmentHolder.putFragment(mFragmentIdentity);
        } catch (MFragmentExistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        MFragmentHolder.getFragments().clear();
    }
}
