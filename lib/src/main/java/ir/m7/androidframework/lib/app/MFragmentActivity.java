package ir.m7.androidframework.lib.app;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import butterknife.ButterKnife;
import ir.m7.androidframework.lib.IContextual;
import ir.m7.androidframework.lib.view.MViewBase;
import ir.m7.androidframework.lib.view.layout.engine.IMLayout;

/**
 * Created by milad on 10/29/15.
 */
public abstract class MFragmentActivity<T> extends FragmentActivity implements IMLayout, IContextual<T> {

    public abstract int getLayoutId();

    public abstract Context getContext();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutId());
        ButterKnife.bind(this);
        initialize(savedInstanceState);
    }

    @Override
    public void initialize(Object... args) {
        changeFont();
    }

    @Override
    public void onStart() {
        super.onStart();
        load();
        //bindController();
    }

    @Override
    protected void onResume() {
        super.onResume();
        refresh();
    }

    @Override
    public void changeFont(View... views) {
        MViewBase.setCurrentViewFont(getContext());
    }
}