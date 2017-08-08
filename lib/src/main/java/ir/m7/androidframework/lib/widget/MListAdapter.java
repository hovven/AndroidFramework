package ir.m7.androidframework.lib.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.BaseAdapter;

import java.util.List;

import ir.m7.androidframework.lib.view.layout.engine.IMChangeFont;

/**
 * Created by Milad on 10/19/2015.
 */
public abstract class MListAdapter<T> extends BaseAdapter implements IMChangeFont {

    protected Typeface mTypeFace;
    private Context mContext;
    private List<T> mList;

    public MListAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mList = list;
    }

    public List<T> getList() {
        return mList;
    }

    public Context getContext() {
        return mContext;
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public T getItem(int i) {
        return mList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public void changeFont(View... views) {

    }

}
