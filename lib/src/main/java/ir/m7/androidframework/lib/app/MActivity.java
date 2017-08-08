package ir.m7.androidframework.lib.app;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;

import butterknife.ButterKnife;
import ir.m7.androidframework.lib.IContextual;
import ir.m7.androidframework.lib.view.MViewBase;
import ir.m7.androidframework.lib.view.layout.engine.IMLayout;

/**
 * Created by Milad on 7/23/2015.
 */

public abstract class MActivity<T> extends Activity implements IMLayout, IContextual<T> {

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
