package ir.m7.androidframework.lib.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.util.List;

import ir.m7.androidframework.lib.view.layout.engine.IMChangeFont;

/**
 * Created by milad on 10/29/15.
 */
public abstract class MRecyclerViewAdapter<T, VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH> implements IMChangeFont {

    protected Typeface mTypeFace;
    private Context mContext;
    private List<T> mList;

    public MRecyclerViewAdapter(Context context, List<T> list) {
        this.mContext = context;
        this.mList = list;
    }

    public Context getContext() {
        return mContext;
    }

    public List<T> getList() {
        return mList;
    }

    public T getItem(int i) {
        return mList.get(i);
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public static abstract class MViewHolder extends RecyclerView.ViewHolder {

        public MViewHolder(View itemView) {
            super(itemView);
        }
    }

}
