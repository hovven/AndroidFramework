package ir.m7.androidframework.lib.util.json.gson;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by Milad on 9/5/2015.
 */
public class MJsonDeserializer {

/*    public MJsonDeserializer() {
        this.mClass = (Class<T>) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }*/

    public static Iterator<JsonElement> parse(JsonArray jsonArray) {
        return jsonArray.iterator();
    }

    public static <T> T parse(Class<T> tClass, JsonObject jsonObject) {
        return parse(tClass, (JsonElement) jsonObject);
    }

    public static <T> T parse(Class<T> tClass, JsonElement jsonElement) {
        Gson gson = new Gson();
        T t = gson.fromJson(jsonElement, tClass);
        return t;
    }

    public static JsonElement convertToJsonElement(String json) {
        return new JsonParser().parse(json);
    }

    public static <T> List<T> nestedParse(Class<T> tClass, JsonArray jsonArray) {
        Iterator<JsonElement> iterator = parse(jsonArray);
        List<T> tArrayList = new ArrayList<T>();

        while (iterator.hasNext()) {
            T t = parse(tClass, iterator.next());
            tArrayList.add(t);
        }

        return tArrayList;
    }

}
