package ir.m7.androidframework.lib.util.json.gson;

import com.google.gson.Gson;

/**
 * Created by Milad on 10/3/2015.
 */
public class MJsonSerializer {


    public static String build(Object object) {
        return new Gson().toJson(object);
    }

}
