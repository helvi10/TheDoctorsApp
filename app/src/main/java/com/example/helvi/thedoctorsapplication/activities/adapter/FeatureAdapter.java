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
import com.example.helvi.thedoctorsapplication.activities.model.Feature;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class FeatureAdapter extends RecyclerView.Adapter<FeatureAdapter.MyViewHolder> implements View.OnClickListener
{
    private  final LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Feature> features;

    public static interface OnRecyclerViewItemClickListener
    {
        void onItemClick(View view, String data);
    }
    private OnRecyclerViewItemClickListener mOnItemClickListener = null;
    public void setOnItemClickListener(OnRecyclerViewItemClickListener listener) {
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

public static class MyViewHolder extends RecyclerView.ViewHolder
{
    public TextView id,title,description;
    ImageView image;

    public MyViewHolder(View view)
    {
        super(view);
        this.title= view.findViewById(R.id.textViewTitle);
        this.description=view.findViewById(R.id.textViewDescription);
        this.image=view.findViewById(R.id.imageViewFeature);

    }
}


    public FeatureAdapter(Context context, ArrayList<Feature> features)
    {
        this.context=context;
        this.features=features;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType)
    {
        View view = layoutInflater.inflate(R.layout.view_feature, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(view);
        view.setOnClickListener(this);
        return myViewHolder;


    }

            @Override
            public void onBindViewHolder(FeatureAdapter.MyViewHolder holder, int position)
            {

                holder.title.setText(features.get(position).getTitle());
                holder.description.setText(features.get(position).getDescription());

                holder.itemView.setTag(features.get(position).Id);
                Picasso.with(context)
                        .load(features.get(position).image)
                        .into(holder.image);

            }



    @Override
    public int getItemCount()
    {
        return features.size();
    }
    public void notifyData(ArrayList<Feature> myList)
    {
        Log.d("notifyData ", myList.size() + "");
        this.features = myList;
        notifyDataSetChanged();
    }
}

