package ir.m7.androidframework.lib.net.web;

import android.content.Context;

import ir.m7.androidframework.lib.R;

/**
 * Created by milad on 11/7/15.
 */
public class HttpStatusMessage {

    public static String getDefaultMessage(Context context, int code) {

        if (code == HttpStatusCode.BAD_REQUEST.getCode()) {
            return context.getString(R.string.bad_request);
        } else if (code == HttpStatusCode.UNAUTHORIZED.getCode()) {
            return context.getString(R.string.unauthorized);
        } else if (code == HttpStatusCode.NOT_FOUND.getCode()) {
            return context.getString(R.string.not_found);
        } else if (code == HttpStatusCode.INTERNAL_SERVER_ERROR.getCode()) {
            return context.getString(R.string.internal_server_error);
        } else {
            return null;
        }
    }
}
