package ir.m7.androidframework.lib.app;

import android.app.Application;

import ir.m7.androidframework.lib.exceptions.MFragmentExistException;
import ir.m7.androidframework.lib.model.to.MFragmentIdentity;

/**
 * Created by Milad on 11/7/2015.
 */
public class MApplication extends Application {

    protected void registerFragment(MFragmentIdentity mFragmentIdentity) {
        try {
            MFragmentHolder.putFragment(mFragmentIdentity);
        } catch (MFragmentExistException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
//        registerFragment(new MFragmentIdentity(new LoginFragment(), LoginFragment.class, null));
//        registerFragment(new MFragmentIdentity(new MailListFragment(), MailListFragment.class, null));
//        registerFragment(new MFragmentIdentity(new MailContentFragment(), MailContentFragment.class, MailListFragment.class));
//        registerFragment(new MFragmentIdentity(new ComposeFragment(), ComposeFragment.class, MailListFragment.class));
//        registerFragment(new MFragmentIdentity(new SearchResultFragment(), SearchResultFragment.class, MailListFragment.class));
//
//        registerFragment(new MFragmentIdentity(new InboxFragment(), InboxFragment.class, null));
//        registerFragment(new MFragmentIdentity(new SentBoxFragment(), SentBoxFragment.class, InboxFragment.class));
//        registerFragment(new MFragmentIdentity(new TrashFragment(), TrashFragment.class, InboxFragment.class));
//        registerFragment(new MFragmentIdentity(new ArchiveFragment(), ArchiveFragment.class, InboxFragment.class));

    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        MFragmentHolder.getFragments().clear();
    }
}
