package ir.m7.androidframework.lib.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ArrayAdapter;

import java.util.List;

import ir.m7.androidframework.lib.view.layout.engine.IMChangeFont;

/**
 * Created by Milad on 12/8/2015.
 */
public abstract class MArrayAdapter<T> extends ArrayAdapter<T> implements IMChangeFont {

    protected Typeface mTypeFace;
    private List<T> mList;

    public MArrayAdapter(Context context, int resource, List<T> objects) {
        super(context, resource, objects);
        this.mList = objects;
    }

    public MArrayAdapter(Context context, int resource, int textViewResourceId, List<T> objects) {
        super(context, resource, textViewResourceId, objects);
        this.mList = objects;
    }

    public List<T> getList() {
        return mList;
    }


    @Override
    public void changeFont(View... views) {

    }
}
