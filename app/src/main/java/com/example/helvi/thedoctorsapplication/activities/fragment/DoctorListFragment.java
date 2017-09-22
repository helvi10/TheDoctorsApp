package com.example.helvi.thedoctorsapplication.activities.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
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

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;


public class DoctorListFragment extends Fragment {

    ArrayList<CategoryDoctor> doctorList=new ArrayList<>();
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private DoctorListAdapter adapter;
    private int currentId;

//    ArrayList<String> items=new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_doctor_list2, container, false);
        requestCategoryData();

        recyclerView=view.findViewById(R.id.my_recycler_view);


        layoutManager=new LinearLayoutManager(getActivity());



        return view;
    }

    void requestCategoryData()
    {
        String url="http://rjtmobile.com/medictto/find_doctor.php?&%20location_id=1&%20specialization_id=1";
        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject jsonObject)
            {
                try
                {
                    if(doctorList.isEmpty())
                    {
                        JSONArray doctors=jsonObject.getJSONArray("doctor_details");
                        for(int i=0;i<doctors.length();i++)
                        {
                            JSONObject c=doctors.getJSONObject(i);
                            String doctorId=c.getString("doctor_id");
                            String doctorName=c.getString("doctor_name");
                            String experience=c.getString("Experience");
                            String qualification=c.getString("Qualification");
                            String doctorPhoto=c.getString("DoctorsPhoto");
                            String address=c.getString("Address");
                            String rating=c.getString("Rating");

                           // Log.d("Helvi","doctorName:"+doctorName);
                            CategoryDoctor categoryDoctor=new CategoryDoctor(doctorId,doctorName,experience,qualification,doctorPhoto,address,rating);
                            doctorList.add(categoryDoctor);

                            Log.d("Helvilist","List:"+doctorList.get(0).getDoctorName());

                            recyclerView.setLayoutManager(layoutManager);
                            adapter=new DoctorListAdapter(getActivity(),doctorList);
                            recyclerView.setAdapter(adapter);

                        }

                        adapter.setOnItemClickListener(new DoctorListAdapter.OnRecyclerViewItemClickListener() {
                            @Override
                            public void onItemClick(View view, String data) {
                                currentId = Integer.valueOf(data);
                                Bundle bundle = new Bundle();

                                for (CategoryDoctor lst : doctorList)
                                {
                                    if (lst.doctorId.equals(data)) {
                                        bundle.putString("doctorId", lst.doctorId);
                                        bundle.putString("doctorName", lst.doctorName);
                                        bundle.putString("experience", lst.experience);
                                        bundle.putString("qualification", lst.qualification);
                                        bundle.putString("doctorPhoto", lst.doctorPhoto);
                                        bundle.putString("address", lst.address);
                                        bundle.putString("rating", lst.rating);

                                    }

                                }

                                DoctorDetailFragment doctorListFragment = new DoctorDetailFragment();
                                doctorListFragment.setArguments(bundle);
                                android.support.v4.app.FragmentManager fragmentManager = getFragmentManager();
                                android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();
                                transaction.replace(R.id.content, doctorListFragment);
                                transaction.addToBackStack(null);
                                transaction.commit();

                            }
                        });


                    }

                }
                catch(Exception e)
                {
                    System.out.println(e);
                }

                }



        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                VolleyLog.d(TAG, "ERROR" + volleyError.getMessage());
                Toast.makeText(getActivity(), volleyError.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });
        AppController.getInstance().addToRequestQueue(jsonObjectRequest);

    }
}
