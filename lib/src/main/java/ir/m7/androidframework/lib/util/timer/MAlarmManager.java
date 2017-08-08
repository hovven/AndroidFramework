package ir.m7.androidframework.lib.util.timer;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

/**
 * Created by Milad on 9/29/2015.
 */
public class MAlarmManager {

    private Context context;
    private AlarmManager alarmManager;

    public MAlarmManager(Context context) {
        this.context = context;
        alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
    }

    public void setRepeatingAlarm(long triggerAtMillis, long intervalMillis, Class destinationClass) {
        alarmManager.setInexactRepeating(AlarmManager.ELAPSED_REALTIME_WAKEUP, triggerAtMillis, intervalMillis, getAlarmPendingIntent(0, getAlarmIntent(destinationClass), 0));
    }

    private Intent getAlarmIntent(Class aClass) {
        return new Intent(context, aClass);
    }

    private PendingIntent getAlarmPendingIntent(int requestCode, Intent intent, int flags) {
        return PendingIntent.getBroadcast(context, requestCode, intent, flags);
    }

}
