package ir.m7.androidframework.lib.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Milad on 11/30/2015.
 */
public class MDate {

    public static final String yyyy_MM_dd = "yyyy-MM-dd";
    //    public static final String YYYY-MM-DD HH:MM
//    public static final String YYYY-MM-DD HH:MM:SS
//    public static final String YYYY-MM-DD HH:MM:SS.SSS
//    public static final String YYYY-MM-DDTHH:MM
    public static final String yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd_HH:mm:ss";
//    public static final String YYYY-MM-DDTHH:MM:SS.SSS
//    public static final String HH:MM
//    public static final String HH:MM:SS
//    public static final String HH:MM:SS.SSS

    public static String format(Date date, String format) {
        return new SimpleDateFormat(format).format(date);
    }
}
