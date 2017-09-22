package com.example.helvi.thedoctorsapplication.activities.adapter;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.helvi.thedoctorsapplication.R;
import com.example.helvi.thedoctorsapplication.activities.model.CategoryDoctor;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class DoctorListAdapter extends RecyclerView.Adapter<DoctorListAdapter.RViewHolder> implements View.OnClickListener{

    private ArrayList<CategoryDoctor> doctors;

    private Context context;
    private LayoutInflater layoutInflater;


    public static interface OnRecyclerViewItemClickListener {
        void onItemClick(View view , String data);
    }
    private DoctorListAdapter.OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public void setOnItemClickListener(DoctorListAdapter.OnRecyclerViewItemClickListener listener) {
        this.mOnItemClickListener = listener;
    }
    @Override
    public void onClick(View view) {
        if (mOnItemClickListener != null) {
            mOnItemClickListener.onItemClick(view,String.valueOf(view.getTag()));
        }
        else{
            Log.e("CLICK", "ERROR");
        }
    }

    public static class RViewHolder extends RecyclerView.ViewHolder{
        TextView  name, qualification,rating;
        ImageView image;

        public RViewHolder(View itemView) {
            super(itemView);

            this.name =  itemView.findViewById(R.id.textViewDoctorName);
            this.qualification =  itemView.findViewById(R.id.textViewQualification);
            this.rating =  itemView.findViewById(R.id.textViewRating);
            this.image =  itemView.findViewById(R.id.imageViewDoctor);

        }
    }

    public DoctorListAdapter(Context context, ArrayList<CategoryDoctor> doctors){
        this.doctors = doctors;
        layoutInflater = LayoutInflater.from(context);
        this.context=context;
    }

    @Override
    public RViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = layoutInflater.inflate(R.layout.view_doctorlist, parent, false);
        RViewHolder rViewHolder = new RViewHolder(view);
        view.setOnClickListener(this);
        return rViewHolder;
    }

    @Override
    public void onBindViewHolder(final RViewHolder holder, int position) {

        holder.name.setText(doctors.get(position).doctorName);
        holder.qualification.setText(doctors.get(position).qualification);
        holder.rating.setText(doctors.get(position).rating);

        holder.itemView.setTag(doctors.get(position).doctorId);

        Picasso.with(context)
                .load(doctors.get(position).doctorPhoto)
                .into(holder.image);

    }
    @Override
    public int getItemCount() {
        return doctors.size();
    }

}



