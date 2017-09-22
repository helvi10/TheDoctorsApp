package com.example.helvi.thedoctorsapplication.activities.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.helvi.thedoctorsapplication.R;


public class CategoryFragment extends Fragment {


    TextView txt_category1,txt_category2,txt_category3,txt_category4;
    CardView card_category1,card_category2,card_category3,card_category4;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        View view=inflater.inflate(R.layout.fragment_category, container, false);

        txt_category1=view.findViewById(R.id.textViewCategory1);
        txt_category2=view.findViewById(R.id.textViewCategory2);
        txt_category3=view.findViewById(R.id.textViewCategory3);
        txt_category4=view.findViewById(R.id.textViewCategory4);

        card_category1=view.findViewById(R.id.cardViewCategory1);
        card_category2=view.findViewById(R.id.cardViewCategory2);
        card_category3=view.findViewById(R.id.cardViewCategory3);
        card_category4=view.findViewById(R.id.cardViewCategory4);

        card_category1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                DoctorListFragment doctorListFragment = new DoctorListFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content, doctorListFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        card_category2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                DoctorListFragment doctorListFragment = new DoctorListFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content, doctorListFragment);
                transaction.addToBackStack(null);
                transaction.commit();

            }
        });

        card_category3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                DoctorListFragment doctorListFragment = new DoctorListFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content, doctorListFragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });

        card_category4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                DoctorListFragment doctorListFragment = new DoctorListFragment();
                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                transaction.replace(R.id.content, doctorListFragment);
                transaction.addToBackStack(null);
                transaction.commit();


            }
        });




        return view;
    }

}
