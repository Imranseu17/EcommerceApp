package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
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

public class PeopleSearchAdapter extends RecyclerView.Adapter {

    Context context;
    ArrayList workSpaceImages;
    private List<String> workspaceNames = new ArrayList<>();
    private List<String> workspaceContents = new ArrayList<>();

    public  PeopleSearchAdapter(Context context,ArrayList  workSpaceImages,
                             List<String> workspaceNames,List<String> workspaceContents) {
        this.context = context;
        this. workSpaceImages =  workSpaceImages;
        this.workspaceNames = workspaceNames;
        this.workspaceContents = workspaceContents;
    }
    @Override
    public  PeopleSearchAdapter.MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.search_for_data, parent, false);
        // set the view's size, margins, paddings and layout parameters
        PeopleSearchAdapter.MyViewHolder vh = new  PeopleSearchAdapter.MyViewHolder(v); // pass the view to View Holder
        return vh;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        PeopleSearchAdapter.MyViewHolder viewHolder  = new  PeopleSearchAdapter.MyViewHolder(holder.itemView);
        viewHolder.workSpaceImage.setImageResource(Integer.parseInt(String.valueOf( workSpaceImages.get(position))));
        viewHolder. workSpaceName.setText(workspaceNames.get(position));
        viewHolder.workSpaceContent.setText(workspaceContents.get(position));

    }



    @Override
    public int getItemCount() {
        return  workSpaceImages.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView workSpaceImage;
        TextView workSpaceName,workSpaceContent;

        public MyViewHolder(View itemView) {
            super(itemView);
            workSpaceImage = itemView.findViewById(R.id.workspace_image);
            workSpaceName = itemView.findViewById(R.id.workspaceName);
            workSpaceContent = itemView.findViewById(R.id.workspace_suggestion);

        }
    }

}
