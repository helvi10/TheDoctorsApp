package com.example.helvi.thedoctorsapplication.activities.fragment;


import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.helvi.thedoctorsapplication.R;
import com.example.helvi.thedoctorsapplication.activities.service.AlarmReceiver;

import static android.content.Context.ALARM_SERVICE;


public class ClockFragment extends Fragment {

    AlarmManager alarmManager;
    TimePicker timePicker;
    TextView txt_alarm_on,txt_alarm_off,txt_alarm_time;
    EditText edit_medicine,edit_doze;
    PendingIntent pendingIntent;
    String medicine,doze;


    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_clock, container, false);

        timePicker=view.findViewById(R.id.timePicker);
        txt_alarm_on=view.findViewById(R.id.textViewAlarmOn);
        txt_alarm_off=view.findViewById(R.id.textViewAlarmOff);
        txt_alarm_time=view.findViewById(R.id.textViewAlarmTime);
        edit_medicine=view.findViewById(R.id.editTextMedicine);
        edit_doze=view.findViewById(R.id.editTextDoze);



        alarmManager= (AlarmManager)getActivity().getSystemService(ALARM_SERVICE);

        final Calendar calendar=Calendar.getInstance();

        final Intent intent=new Intent(getContext(), AlarmReceiver.class);
        txt_alarm_on.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                calendar.set(Calendar.HOUR_OF_DAY,timePicker.getHour());
                calendar.set(Calendar.MINUTE,timePicker.getMinute());

                int hour=timePicker.getHour();
                int minute=timePicker.getMinute();

                String hour_string=String.valueOf(hour);
                String minute_string=String.valueOf(minute);

                medicine=edit_medicine.getText().toString();
                doze=edit_doze.getText().toString();

                if(hour>12)
                {
                    hour_string=String.valueOf(hour-12);

                }
                if(minute<10)
                {
                    minute_string="0"+String.valueOf(minute_string);
                }



                pendingIntent=PendingIntent.getBroadcast(getContext(),0,intent,PendingIntent.FLAG_UPDATE_CURRENT);

                alarmManager.set(AlarmManager.RTC_WAKEUP,calendar.getTimeInMillis(),pendingIntent);
                Toast.makeText(getContext(),"Alarm On"+hour_string+":"+minute_string,Toast.LENGTH_LONG).show();
                Toast.makeText(getContext(),"Remider For Medicine:"+medicine+" "+"Doze:"+doze,Toast.LENGTH_LONG).show();

            }
        });

        txt_alarm_off.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                alarmManager.cancel(pendingIntent);
                Toast.makeText(getContext(),"Alarm Off:",Toast.LENGTH_LONG).show();


            }
        });
         return view;
    }

}
