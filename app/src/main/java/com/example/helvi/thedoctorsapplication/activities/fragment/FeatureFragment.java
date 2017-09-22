package com.example.helvi.thedoctorsapplication.activities.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.helvi.thedoctorsapplication.R;
import com.example.helvi.thedoctorsapplication.activities.activities.ImageAttachmentActivity;
import com.example.helvi.thedoctorsapplication.activities.adapter.FeatureAdapter;
import com.example.helvi.thedoctorsapplication.activities.model.Feature;

import java.util.ArrayList;

public class FeatureFragment extends Fragment
{
    private ArrayList<Feature> featureList;
    private RecyclerView recyclerView;
    private FeatureAdapter mAdapter;
    private RecyclerView.LayoutManager layoutManager;
    private int currentId;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {

        View view= inflater.inflate(R.layout.fragment_feature,null);
        getFeatureData();

        recyclerView=view.findViewById(R.id.recycleViewFeature);
        recyclerView.setHasFixedSize(false);
        layoutManager=new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);


        mAdapter=new FeatureAdapter(getActivity(),featureList);
        recyclerView.setAdapter(mAdapter);

        mAdapter.setOnItemClickListener(new FeatureAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClick(View view, String data)
            {
                currentId=Integer.valueOf(data);
                if(currentId==1)
                {
                    Log.d("TAG", "currentId" + currentId);
                    CategoryFragment bookAppointmentFragment = new CategoryFragment();
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.content, bookAppointmentFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                if(currentId==2)
                {
                    Log.d("TAG", "currentId" + currentId);
                    ChatFragment chatFragment = new ChatFragment();
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.content, chatFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }
                if(currentId==5)
                {
                    Log.d("TAG", "currentId" + currentId);
                    ClockFragment clockFragment = new ClockFragment();
                    android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                    android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                    transaction.replace(R.id.content, clockFragment);
                    transaction.addToBackStack(null);
                    transaction.commit();
                }

                if(currentId==4)
                {
                    Intent intent=new Intent(getActivity(), ImageAttachmentActivity.class);
                    startActivity(intent);

                }

            }
        });


        return  view;

    }

    public void getFeatureData()
    {
        featureList = new ArrayList<>();
        String draw="@drawable/";
        Feature f1=new Feature("1","Book an appointment","Find doctors,clinics,hospitals and more",R.drawable.calendar1);
        featureList.add(f1);

        f1=new Feature("2","Chat with a doctor online","Talk privately with a verified doctor",R.drawable.speech);
        featureList.add(f1);

        f1=new Feature("3","Ask a free question","Get answers from doctors and experts",R.drawable.question);
        featureList.add(f1);

        f1=new Feature("4","Add a medical record","Upload prescriptions,reports and more",R.drawable.cart);
        featureList.add(f1);

        f1=new Feature("5","Set medicine reminders","Get alerts so you never miss a close",R.drawable.reminder);
        featureList.add(f1);


    }

}
