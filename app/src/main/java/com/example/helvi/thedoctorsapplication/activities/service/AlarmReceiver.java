package com.example.helvi.thedoctorsapplication.activities.service;


import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.Ringtone;
import android.media.RingtoneManager;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

public class AlarmReceiver extends BroadcastReceiver
{


    public void onReceive(Context context, Intent intent)
    {
          Log.i("HELVI","inside broadcast");


       Intent service_intent=new Intent(context,RingtonePlayingService.class);



        context.startService(service_intent);
    }
}
