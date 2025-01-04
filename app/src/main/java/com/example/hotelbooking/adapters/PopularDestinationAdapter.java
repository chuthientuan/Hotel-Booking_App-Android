package com.example.hotelbooking.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.hotelbooking.R;
import com.example.hotelbooking.entities.PopularDestination;

import java.util.ArrayList;

public class PopularDestinationAdapter extends RecyclerView.Adapter<PopularDestinationAdapter.ViewHolder> {
    ArrayList<PopularDestination> items;
    Context context;

    public PopularDestinationAdapter(Context context, ArrayList<PopularDestination> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public PopularDestinationAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_popular_destination_item, parent, false);
        return new PopularDestinationAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PopularDestinationAdapter.ViewHolder holder, int position) {
        PopularDestination item = items.get(position);
        context = holder.itemView.getContext();

        holder.imgHotel.setImageResource(item.getImageUrl());
        holder.txtLocation.setText(item.getLocation());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgHotel;
        private final TextView txtLocation;

        public ViewHolder(View itemView) {
            super(itemView);
            imgHotel = itemView.findViewById(R.id.imgHotel);
            txtLocation = itemView.findViewById(R.id.txtLocation);
        }
    }
}
