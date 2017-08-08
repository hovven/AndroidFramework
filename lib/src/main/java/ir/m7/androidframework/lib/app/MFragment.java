package ir.m7.androidframework.lib.app;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import ir.m7.androidframework.lib.IContextual;
import ir.m7.androidframework.lib.view.MViewBase;
import ir.m7.androidframework.lib.view.layout.engine.IMLayout;

/**
 * Created by Milad on 7/22/2015.
 */

public abstract class MFragment<T> extends MAbsFragmentTransaction implements IMLayout, IContextual<T> {
    public abstract int getLayoutId();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(getLayoutId(), container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        //  addFragment();
        initialize(view, savedInstanceState);
    }

//    @Override
//    public void addFragment() {
//    Fragment currentFragment = getFragmentManager().findFragmentById(getContainerId());
//    registerFragment(currentFragment.getClass(), currentFragment);
//    }


    @Override
    public void initialize(Object... args) {
        changeFont((View) args[0]);
    }

    @Override
    public void onStart() {
        super.onStart();
        load();
        //bindController();
    }

    @Override
    public void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public void changeFont(View... views) {
        MViewBase.setCurrentViewFont(getContext());
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}
