package com.example.helvi.thedoctorsapplication.activities.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.helvi.thedoctorsapplication.R;
import com.example.helvi.thedoctorsapplication.activities.adapter.DoctorListAdapter;
import com.example.helvi.thedoctorsapplication.activities.model.CategoryDoctor;
import com.example.helvi.thedoctorsapplication.activities.service.AppController;
import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


public class DoctorDetailFragment extends Fragment {

    TextView txt_name,txt_qualification,txt_experience,txt_rating,txt_address;

    Button btn_book;

    ImageView img_doctor;
      String doctorId,doctorName,experience,qualification,doctorPhoto,address,rating;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        doctorId=getArguments().getString("doctorId");
        doctorName=getArguments().getString("doctorName");
        experience=getArguments().getString("experience");
        qualification=getArguments().getString("qualification");
        doctorPhoto=getArguments().getString("doctorPhoto");
        address=getArguments().getString("address");
        rating=getArguments().getString("rating");


        View view=inflater.inflate(R.layout.fragment_doctor_detail, container, false);

        txt_name=view.findViewById(R.id.textViewName);
        txt_qualification=view.findViewById(R.id.textViewQualification);
        txt_experience=view.findViewById(R.id.textViewExperience);
        txt_address=view.findViewById(R.id.textViewAddress);
        txt_rating=view.findViewById(R.id.textViewRating);
        img_doctor=view.findViewById(R.id.imageView4);
        btn_book=view.findViewById(R.id.buttonBook);

        txt_name.setText(doctorName);
        txt_qualification.setText(qualification);
        txt_experience.setText(experience);
        txt_address.setText(address);
        txt_rating.setText(rating);
        Picasso.with(getContext())
                .load(doctorPhoto)
                .into(img_doctor);

  btn_book.setOnClickListener(new View.OnClickListener() {
      @Override
      public void onClick(View view)
      {
          DateTimeFragment dateTimeFragment = new DateTimeFragment();
          android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
          android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
          transaction.replace(R.id.content, dateTimeFragment);
          transaction.addToBackStack(null);
          transaction.commit();

      }
  });


        return view;
    }


}
