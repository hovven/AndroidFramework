package ir.m7.androidframework.lib.os;

import android.os.AsyncTask;
import android.os.Build;

/**
 * Created by Milad on 1/16/2016.
 */
public class MAsyncTaskHelper {

    public static void executer(AsyncTask task, Object... params) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB)
            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, params);
        else
            task.execute(params);
    }


}
