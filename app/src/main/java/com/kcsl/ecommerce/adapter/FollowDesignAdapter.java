package com.kcsl.ecommerce.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.ArrayList;
import java.util.List;

public class FollowDesignAdapter extends RecyclerView.Adapter {

    ArrayList followImages;
    private List<String> followNameList;
    private List<String> followTitleList;
    Context context;

    public FollowDesignAdapter(Context context, ArrayList followImages,List<String> followNameList,List<String> followTitleList) {
        this.followImages = followImages;
        this.context = context;
        this.followNameList = followNameList;
        this.followTitleList = followTitleList;
    }

    @NonNull
    @Override
    public FollowDesignAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.follow_design_layout, parent, false);
        // set the view's size, margins, paddings and layout parameters
        FollowDesignAdapter.MyViewHolder vh = new FollowDesignAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        FollowDesignAdapter.MyViewHolder viewHolder = new FollowDesignAdapter.MyViewHolder(holder.itemView);
        viewHolder.followImage.setImageResource(Integer.parseInt(String.valueOf(followImages.get(position))));
        viewHolder.followTitle.setText(followTitleList.get(position));
        viewHolder.followName.setText(followNameList.get(position));
    }

    @Override
    public int getItemCount() {
        return followImages.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        // init the item view's
        ImageView followImage;
        TextView followName,followTitle;

        public MyViewHolder(View itemView) {
            super(itemView);
            // get the reference of item view's
            followImage = itemView.findViewById(R.id.follow_image);
            followName = itemView.findViewById(R.id.follow_name);
            followTitle = itemView.findViewById(R.id.follow_title);
        }
    }

}
