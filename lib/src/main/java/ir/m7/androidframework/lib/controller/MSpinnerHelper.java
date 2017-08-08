package ir.m7.androidframework.lib.controller;

import android.content.Context;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import java.util.List;

import ir.ideacenter.efanap.letter.controller.adapter.SpinnerAdapter;

/**
 * Created by Milad on 12/8/2015.
 */
public class MSpinnerHelper {

    public static void initSpinner(Context context, Spinner spinner, int arrayId) {
        initSpinner(context, spinner, arrayId, android.R.layout.simple_spinner_item, android.R.layout.simple_spinner_dropdown_item);
    }

    public static void initSpinner(Context context, Spinner spinner, List list) {
        initSpinner(context, spinner, list, android.R.layout.simple_spinner_item, android.R.layout.simple_spinner_dropdown_item);
    }

    public static void initSpinner(Context context, Spinner spinner, int arrayId, int spinnerItemId, int dropDownItemId) {
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context, arrayId, spinnerItemId);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(dropDownItemId);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public static void initSpinner(Context context, Spinner spinner, List list, int spinnerItemId, int dropDownItemId) {
        SpinnerAdapter adapter = new SpinnerAdapter(
                context,
                spinnerItemId,
                list);
        // ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(context, spinnerItemId, list);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(dropDownItemId);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }
}
