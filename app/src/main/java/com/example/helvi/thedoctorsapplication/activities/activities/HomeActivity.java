package com.example.helvi.thedoctorsapplication.activities.activities;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.helvi.thedoctorsapplication.R;
import com.example.helvi.thedoctorsapplication.activities.fragment.FeatureFragment;

public class HomeActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:

                    FeatureFragment fragment1=new FeatureFragment();
                    android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
                    FragmentTransaction ft1=fragmentManager.beginTransaction();
                    ft1.replace(R.id.content,fragment1);
                    ft1.addToBackStack(null);
                    ft1.commit();


                    return true;
                case R.id.navigation_dashboard:

                    return true;
                case R.id.navigation_notifications:

                    return true;
            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        FeatureFragment fragment1=new FeatureFragment();
        android.support.v4.app.FragmentManager fragmentManager=getSupportFragmentManager();
        FragmentTransaction ft1=fragmentManager.beginTransaction();
        ft1.replace(R.id.content,fragment1);
        ft1.addToBackStack(null);
        ft1.commit();
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
