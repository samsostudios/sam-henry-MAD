package com.example.sam.spotz;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sam on 5/1/18.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    Context mContext;
    List<Location> mData;
    //LinearLayout parent_layout;

    public void update(ArrayList<Location> data){
        mData.clear();
        mData.addAll(data);
        notifyDataSetChanged();
    }

    public RecyclerViewAdapter(Context mContext, List<Location> mData) {
        this.mContext = mContext;
        this.mData = mData;

        Log.d("recyler", "mContext: "+mContext);
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.item_location, parent, false);
        final MyViewHolder vHolder = new MyViewHolder(v);

        return vHolder;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, final int position) {
        holder.tv_location.setText(mData.get(position).getName());
        holder.img.setImageResource(mData.get(position).getPhoto());

        holder.parent_layout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(mContext, "test click"+String.valueOf(holder.getAdapterPosition()), Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(mContext, GalleryActivity.class);
                intent.putExtra("locationName", mData.get(position).getName());
                mContext.startActivity(intent);
            }
        });


    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        private TextView tv_location;
        private ImageView img;
        private LinearLayout parent_layout;

        public MyViewHolder(View itemView) {
            super(itemView);

            parent_layout = (LinearLayout) itemView.findViewById(R.id.parent_layout);
            tv_location = (TextView) itemView.findViewById(R.id.name_location);
            img = (ImageView) itemView.findViewById(R.id.img_location);
        }
    }
}
