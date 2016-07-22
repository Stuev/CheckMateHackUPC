package edu.gatech.checkmate.checkmatehackupc;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.PowerManager;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by kalyasubramanian1 on 7/21/16.
 */
public class TimeManager extends BroadcastReceiver{

    //Thinks this does it every 10 seconds
    public static int delay = 1000*5;
    public static boolean hasCheckedIn = false;


    @Override
    public void onReceive(Context context, Intent intent)
    {
        Log.d("TimeManager", "Start onReceive");
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();

        Toast.makeText(context, "Check In", Toast.LENGTH_LONG).show();
        Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
        Ringtone r = RingtoneManager.getRingtone(context, notification);
        r.play();

        Log.d("TimeManager", "They didn't check in");
        hasCheckedIn = false;

        wl.release();
    }
    public void SetAlarm(Context context)
    {
        Log.d("TimeManager", "Start setAlarm");
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, TimeManager.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), delay, pi);
    }
}
