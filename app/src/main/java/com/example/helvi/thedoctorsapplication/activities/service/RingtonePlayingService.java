package com.example.helvi.thedoctorsapplication.activities.service;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;

import com.example.helvi.thedoctorsapplication.R;


public class RingtonePlayingService extends Service {

    MediaPlayer mediaPlayer;
    @Nullable
    @Override
    public IBinder onBind(Intent intent) {

        throw new UnsupportedOperationException("Not yet implemented");
    }

    public void onCreate()
    {
        super.onCreate();
         mediaPlayer=MediaPlayer.create(this,R.raw.music1);


    }

    public int onStartCommand(Intent intent,int flags,int startId)
    {
        mediaPlayer.start();
        Toast.makeText(this,"Music",Toast.LENGTH_LONG).show();
        Log.i("HELVI","Music playing");
        return super.onStartCommand(intent, flags, startId);

    }

    public void onDestroy()
    {
        super.onDestroy();
        mediaPlayer.stop();

    }
}
