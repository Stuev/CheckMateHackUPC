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
public class CheckInManager extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent)
    {
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();

        if (TimeManager.hasCheckedIn == false) {
            //Send notifcation to friends!!!!!!
            Log.d("CheckInManager", "They didn't check in");
        }

        wl.release();
    }
    public void SetAlarm(Context context)
    {
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, TimeManager.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis() + 5 * 1000 * 60, TimeManager.delay, pi);
    }
}
