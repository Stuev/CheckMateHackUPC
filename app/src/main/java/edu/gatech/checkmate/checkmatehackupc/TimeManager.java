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
    public static int delay1 = 1000*5;
    public static int delay2 = 1000*5 +200;
    public static boolean hasCheckedIn = false;
    private boolean isCheckInAlarm = true;


    @Override
    public void onReceive(Context context, Intent intent)
    {

        Log.d("TimeManager", "" + isCheckInAlarm);
        PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
        PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
        wl.acquire();
        if(isCheckInAlarm) {
            Log.d("TimeManager", "Start onReceive");

            Toast.makeText(context, "Check In", Toast.LENGTH_LONG).show();
            Uri notification = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_NOTIFICATION);
            Ringtone r = RingtoneManager.getRingtone(context, notification);
            r.play();

            Log.d("TimeManager", "They didn't check in");
            hasCheckedIn = false;
            isCheckInAlarm = !isCheckInAlarm;
            Log.d("TimeManager", "isCheckInAlarm after first alarm: " + isCheckInAlarm);

        } else {
            Log.d("TimeManager", "Start onReceive second alarm");
            //PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            //PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
            //wl.acquire();

            if (TimeManager.hasCheckedIn == false) {
                Log.d("TimeManager", "Should send email");

                String[] TO = {"ks26700@gmail.com"};
                //String[] CC = {"xyz@gmail.com"};
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setData(Uri.parse("mailto:"));
                emailIntent.setType("text/plain");


                emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
                //emailIntent.putExtra(Intent.EXTRA_CC, CC);
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Your subject");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Email message goes here");

                try {
                    context.startActivity(Intent.createChooser(emailIntent, "Send mail..."));

                    Log.d("TimeManager", "Sent email inside try");
                } catch (android.content.ActivityNotFoundException ex) {
                    Toast.makeText(context,
                            "There is no email client installed.", Toast.LENGTH_SHORT).show();
                }
                Log.d("TimeManager", "End email block");

            }




            isCheckInAlarm = !isCheckInAlarm;
            Log.d("CheckInManager", "End onReceive");
        }

        wl.release();



    }
    public void SetAlarm(Context context)
    {

        Log.d("TimeManager", "Start timeManager alarm");
        AlarmManager am =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i = new Intent(context, TimeManager.class);
        PendingIntent pi = PendingIntent.getBroadcast(context, 0, i, 0);
        am.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), delay1, pi);


        Log.d("TimeManager", "Set check in alarm");
        AlarmManager am1 =( AlarmManager)context.getSystemService(Context.ALARM_SERVICE);
        Intent i1 = new Intent(context, TimeManager.class);

        PendingIntent pi1 = PendingIntent.getBroadcast(context, 1, i1, 0);
        am1.setRepeating(AlarmManager.RTC_WAKEUP, System.currentTimeMillis(), TimeManager.delay2, pi1);
    }
}
