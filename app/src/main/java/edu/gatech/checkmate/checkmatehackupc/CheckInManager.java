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
        Log.d("CheckInManager", "Got checkinmanager");
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();

        if (TimeManager.hasCheckedIn == false) {
            Log.d("CheckInManager", "Send email");

            String[] TO = {"ks26700@gmail.com"};
            String[] CC = {"xyz@gmail.com"};
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");


            emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
            emailIntent.putExtra(Intent.EXTRA_CC, CC);
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
            emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

            try {
                Intent.createChooser(emailIntent, "Send mail...");

                Log.d("CheckInManager", "Sent email");
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(context,
                        "There is no email client installed.", Toast.LENGTH_SHORT).show();
            }
            Log.d("CheckInManager", "They didn't check in");
        }

        wl.release();
    }
    public void SetAlarm(Context context)
    {
        Log.d("CheckInManager", "Set alarm for check in");
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, CheckInManager.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 1, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), TimeManager.delay, pi);
    }
}
