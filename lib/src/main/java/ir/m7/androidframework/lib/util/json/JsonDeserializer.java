package ir.m7.androidframework.lib.util.json;/*
package ir.m7.androidframework.lib.util.json;

import com.google.gson.*;

import java.io.FileWriter;
import java.lang.reflect.ParameterizedType;
import java.util.ArrayList;
import java.util.List;

*/
/**
 * Created by Milad on 01/05/2015.
 *//*

public class JsonDeserializer {

    public static <T> List<T> parse(Class<T> tClass,JsonArray json) {
        Gson gson = new Gson();
        List<T> arrayList = new ArrayList<T>();
        for (int i = 0; i < json.size(); i++) {
            JsonObject jsonObject = json.get(i).getAsJsonObject();
            T t = gson.fromJson(jsonObject, tClass);
            arrayList.add(t);
        }
        return arrayList;
    }

    public <T> T parse(Class<T> tClass , JsonObject json) {
        Gson gson = new Gson();
        T t = gson.fromJson(json, tClass);
        return t;
    }
}*/
