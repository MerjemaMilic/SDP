package com.example.seniordesignproject;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.seniordesignproject.Model.Rate;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<ViewHolder> {
    YourReviewsActivity listActivity;
    public List<Rate> rateList;

    public CustomAdapter(YourReviewsActivity listActivity, List<Rate> rateList) {
        this.listActivity = listActivity;
        this.rateList = rateList;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.custom_view, parent, false);
        ViewHolder viewHolder = new ViewHolder(itemView);
        viewHolder.setOnClickListener(new ViewHolder.ClickListener() {
            @Override
            public void onItemClick(View view, int position) {
              //  String city = rateList.get(position).getCity();
                String neighborhood = rateList.get(position).getNeighborhood();
                String content = rateList.get(position).getContent();
                Intent i = new Intent(view.getContext(), RateDetails.class);
              //  i.putExtra("city",city);
                i.putExtra("neighborhood", neighborhood);
                i.putExtra("content", content);
                view.getContext().startActivity(i);

            }

            @Override
            public void onItemLongClick(View view, int position) {

            }
        });

        return viewHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
//        holder.mCity.setText(rateList.get(position).getCity());
        holder.mNeighbourhood.setText(rateList.get(position).getNeighborhood());
        holder.mContent.setText(rateList.get(position).getContent());

    }



    @Override
    public int getItemCount() {
        return rateList.size(); }
}
