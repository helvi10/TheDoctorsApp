package com.example.helvi.thedoctorsapplication.activities.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.helvi.thedoctorsapplication.R;

public class ImageAttachmentFragment extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_attachment_fragment);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        Log.d("Activity", "onActivityResult: ");
        super.onActivityResult(requestCode, resultCode, data);
    }
}
