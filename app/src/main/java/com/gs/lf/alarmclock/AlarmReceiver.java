package com.gs.lf.alarmclock;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

/**
 * Created by luofan18 on 2016/8/20.
 */
public class AlarmReceiver extends BroadcastReceiver {

    final  String TAG = "AlarmReceiver";

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("AlarmReceiver--Alarm set");
        Intent alarmIntent = new Intent(context,MainActivity.class);
        alarmIntent.setAction("ALARM_GOES_OFF");
        alarmIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK|Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT|Intent.FLAG_ACTIVITY_CLEAR_TASK);
        context.startActivity(alarmIntent);
    }
}
