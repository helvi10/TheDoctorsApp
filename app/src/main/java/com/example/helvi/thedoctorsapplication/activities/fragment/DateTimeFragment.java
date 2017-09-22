package com.example.helvi.thedoctorsapplication.activities.fragment;


import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.icu.util.Calendar;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
import android.support.v4.app.Fragment;
import android.telephony.SmsManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.helvi.thedoctorsapplication.R;
import com.example.helvi.thedoctorsapplication.activities.service.ApiClient;
import com.example.helvi.thedoctorsapplication.activities.service.AppointmentConfirmation;
import com.example.helvi.thedoctorsapplication.activities.service.AppointmentConfirmedItem;
import com.example.helvi.thedoctorsapplication.activities.service.iMedicine;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class DateTimeFragment extends Fragment implements View.OnClickListener {


    EditText edit_name,edit_phone;
    Button btnDatePicker, btnTimePicker,btn_endTime,btn_book;
    EditText txtDate, txtStartTime,txtEndTime;
    private int mYear, mMonth, mDay, mHourStart, mMinuteStart,mHourEnd,mMinuteEnd;
    public static final String TAG = "";
    String startTime,endTime,date,timeToStart,timeToEnd;
    String phoneNo;
    String message;

    public String BASE_URL_App="http://rjtmobile.com/medictto/";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_date_time2, container, false);

        btnDatePicker = (Button) view.findViewById(R.id.btn_date);
        btnTimePicker = (Button) view.findViewById(R.id.btn_time);
        btn_endTime=(Button)view.findViewById(R.id.buttonEndTime);
        btn_book=(Button)view.findViewById(R.id.buttonBook);

        txtDate = (EditText) view.findViewById(R.id.in_date);
        txtStartTime = (EditText) view.findViewById(R.id.in_time);
        txtEndTime=view.findViewById(R.id.editTextEndTime);
        edit_name=view.findViewById(R.id.editTextName);
        edit_phone=view.findViewById(R.id.editTextPhone);

        btnDatePicker.setOnClickListener(this);
        btnTimePicker.setOnClickListener(this);
        btn_endTime.setOnClickListener(this);



        //btn_book.setOnClickListener(this);

        final iMedicine objMedicine= ApiClient.getClient(BASE_URL_App).create(iMedicine.class);

        btn_book.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                phoneNo=edit_phone.getText().toString();

                Call<AppointmentConfirmation> objAppointment=objMedicine.getAppoint("101","202",startTime,endTime);

                objAppointment.enqueue(new Callback<AppointmentConfirmation>() {
                    @Override
                    public void onResponse(Call<AppointmentConfirmation> call, Response<AppointmentConfirmation> response) {

                        List<AppointmentConfirmedItem> appointItem=response.body().getAppointmentConfirmed();

                        int appNo=appointItem.get(0).getAppointmentNo();

                        Toast.makeText(getContext(),"Your Appointment is Confirmed.Appointment No:"+appNo,Toast.LENGTH_LONG).show();

                        Log.d("appNo",appNo+"");

                        message="Your Appointment is Confirmed.Appointment No:"+appNo;
                        SmsManager smsManager = SmsManager.getDefault();
                        smsManager.sendTextMessage(phoneNo, null, message, null, null);
                        Toast.makeText(getContext(), "SMS sent.",
                                Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void onFailure(Call<AppointmentConfirmation> call, Throwable t)
                    {

                    }
                });


            }
        });

        return view;
    }
    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View view) {
        if (view == btnDatePicker) {

            // Get Current Date
            final Calendar c = Calendar.getInstance();
            mYear = c.get(Calendar.YEAR);
            mMonth = c.get(Calendar.MONTH);
            mDay = c.get(Calendar.DAY_OF_MONTH);


            DatePickerDialog datePickerDialog = new DatePickerDialog(getContext(),new DatePickerDialog.OnDateSetListener() {

                @Override
                public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth)
                {

                    date=dayOfMonth + "-" + (monthOfYear + 1) + "-" + year;
                    txtDate.setText(dayOfMonth + "-" + (monthOfYear + 1) + "-" + year);

                }
            }, mYear, mMonth, mDay);
            datePickerDialog.show();
        }
        if (view == btnTimePicker) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHourStart = c.get(Calendar.HOUR_OF_DAY);
            mMinuteStart = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog = new TimePickerDialog(getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute)
                        {
                            timeToStart=hourOfDay+":"+minute;

                            txtStartTime.setText(hourOfDay + ":" + minute);
                        }
                    }, mHourStart, mMinuteStart, false);
            timePickerDialog.show();
        }

        if (view == btn_endTime) {

            // Get Current Time
            final Calendar c = Calendar.getInstance();
            mHourEnd = c.get(Calendar.HOUR_OF_DAY);
            mMinuteEnd = c.get(Calendar.MINUTE);

            // Launch Time Picker Dialog
            TimePickerDialog timePickerDialog1 = new TimePickerDialog(getContext(),
                    new TimePickerDialog.OnTimeSetListener() {

                        @Override
                        public void onTimeSet(TimePicker view, int hourOfDay,
                                              int minute) {



                            txtEndTime.setText(hourOfDay + ":" + minute);
                            timeToEnd=txtEndTime.getText().toString();
                        }
                    }, mHourEnd, mMinuteEnd, false);
            timePickerDialog1.show();
        }

        startTime=date+timeToStart;
        endTime=date+timeToEnd;

        Log.d("startTime",startTime);
        Log.d("endTime",endTime);


    }


}
