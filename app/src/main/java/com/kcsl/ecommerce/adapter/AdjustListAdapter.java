package com.kcsl.ecommerce.adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.kcsl.ecommerce.R;

import java.util.List;

public class AdjustListAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    Context context;
    private List<String> adjustableText;
    private List<String> adjustableworkspace;
    private List<String> adjustableRating;

    public AdjustListAdapter(Context context, List<String> adjustableText,
                              List<String> adjustableworkspace,List<String> adjustableRating) {
        this.context = context;
        this.adjustableText = adjustableText;
        this.adjustableworkspace = adjustableworkspace;
        this.adjustableRating = adjustableRating;

    }
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // infalte the item Layout
        RecyclerView.ViewHolder viewHolder = null;
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View viewItem = inflater.inflate(R.layout.adjustable_laout_xml, parent, false);
        viewHolder = new AdjustListAdapter.MyViewHolder(viewItem);

        return viewHolder;
    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, final int position) {
        AdjustListAdapter.MyViewHolder viewHolder  = new AdjustListAdapter.MyViewHolder(holder.itemView);

        viewHolder.adjustableName.setText(adjustableText.get(position));
        viewHolder.adjustableWorkspaceRefactor.setText(adjustableworkspace.get(position));
        viewHolder.adjustableRatingRefactor.setText(adjustableRating.get(position));



        if(position%2==0){
            viewHolder.scroll_1.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.scroll_icon_activated));
            viewHolder.scroll_1.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.scroll_icon_not_activated));
            viewHolder.scroll_1.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.scroll_icon_not_activated));
        }

        else{

            viewHolder.scroll_1.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.scroll_icon_not_activated));
            viewHolder.scroll_1.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.scroll_icon_activated));
            viewHolder.scroll_1.setBackground(ContextCompat.getDrawable(context,
                    R.drawable.scroll_icon_not_activated));

        }
    }



    @Override
    public int getItemCount() {
        return adjustableText.size();
    }


    public class MyViewHolder extends RecyclerView.ViewHolder {


        TextView adjustableName, adjustableWorkspaceRefactor, adjustableRatingRefactor;
        ImageView scroll_1,scroll_2,scroll_3;

        public MyViewHolder(View itemView) {
            super(itemView);
            adjustableName = itemView.findViewById(R.id.adjustable_);
            adjustableWorkspaceRefactor = itemView.findViewById(R.id.hughlan_wor);
            adjustableRatingRefactor = itemView.findViewById(R.id.some_id);
            scroll_1 = itemView.findViewById(R.id.scroll_1);
            scroll_2 = itemView.findViewById(R.id.scroll_2);
            scroll_3 = itemView.findViewById(R.id.scroll_3);
        }
    }
}
