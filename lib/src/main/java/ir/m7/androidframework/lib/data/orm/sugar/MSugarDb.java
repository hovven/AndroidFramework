package ir.m7.androidframework.lib.data.orm.sugar;

import android.content.Context;

import com.orm.SugarDb;

/**
 * Created by Milad on 11/23/2015.
 */
public class MSugarDb {

    //create an object of SingleObject
    private static SugarDb instance;

    //make the constructor private so that this class cannot be
    //instantiated
    private MSugarDb() {

    }

    public static SugarDb init(Context context) {
        if (instance == null)
            instance = new SugarDb(context);
        return instance;
    }

    //Get the only object available
    public static SugarDb getInstance() {
        return instance;
    }
}
