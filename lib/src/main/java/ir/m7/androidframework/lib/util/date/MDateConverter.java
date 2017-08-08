package ir.m7.androidframework.lib.util.date;

import java.util.Calendar;

/**
 * Created by Milad on 7/21/2015.
 */
public class MDateConverter {

    public static Calendar toGregorian(String date, String tokenizer, boolean isYearLeft) {
        int[] tokenizedDate = dateTokenizer(date, tokenizer, isYearLeft);
        MPersianDate persianCalendar = new MPersianDate();
        persianCalendar.setIranianDate(tokenizedDate[0], tokenizedDate[1], tokenizedDate[2]);
        Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.YEAR, persianCalendar.getGregorianYear());
        calendar.set(Calendar.MONTH, persianCalendar.getGregorianMonth() - 1);
        calendar.set(Calendar.DAY_OF_MONTH, persianCalendar.getGregorianDay());
        return calendar;
    }

    public static String toPersian(Calendar calendar) {
        MPersianDate persianDate = new MPersianDate();
        persianDate.setGregorianDate(calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH) + 1, calendar.get(Calendar.DAY_OF_MONTH));
        String cal = String.format(persianDate.getIranianDate());
        return cal;
    }

    public static int[] dateTokenizer(String date, String tokenizer, boolean isYearLeft) {
        String[] dateArray = date.split(tokenizer);
        int[] tokenizedDate = new int[dateArray.length];
        if (isYearLeft) {
            for (int i = 0; i < dateArray.length; i++) {
                tokenizedDate[i] = Integer.parseInt(dateArray[i]);
            }
        } else {
            for (int i = dateArray.length; i > 0; i--) {
                tokenizedDate[i] = Integer.parseInt(dateArray[i]);
            }
        }
        return tokenizedDate;
    }
}
