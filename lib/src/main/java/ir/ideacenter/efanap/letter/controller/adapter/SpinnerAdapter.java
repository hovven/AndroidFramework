package ir.ideacenter.efanap.letter.controller.adapter;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by hoven on 6/26/16.
 */
public class SpinnerAdapter extends ArrayAdapter<String> {

    // Initialise custom font, for example:
    Typeface font = Typeface.createFromAsset(getContext().getAssets(), "MyriadArabic-Bold.ttf");
    // (In reality I used a manager which caches the Typeface objects)

    public SpinnerAdapter(Context context, int resource, List<String> items) {
        super(context, resource, items);
    }

    // Affects default (closed) state of the spinner
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getView(position, convertView, parent);
        view.setTypeface(font);
        return view;
    }

    // Affects opened state of the spinner
    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {
        TextView view = (TextView) super.getDropDownView(position, convertView, parent);
        view.setTypeface(font);
        return view;
    }
}
