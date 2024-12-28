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

public class BestHotelAdapter extends RecyclerView.Adapter<BestHotelAdapter.ViewHolder> {
    ArrayList<PopularDestination> items;
    Context context;

    public BestHotelAdapter(Context context, ArrayList<PopularDestination> items) {
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public BestHotelAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_best_hotel_item, parent, false);
        return new BestHotelAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BestHotelAdapter.ViewHolder holder, int position) {
        PopularDestination item = items.get(position);
        context = holder.itemView.getContext();
        Glide.with(context).load(item.getImageUrl()).into(holder.imgHotel);

        holder.txtNameHotel.setText(item.getName());
        holder.txtLocation.setText(item.getLocation());

    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imgHotel;
        private final TextView txtNameHotel;
        private final TextView txtLocation;

        public ViewHolder(View itemView) {
            super(itemView);
            imgHotel = itemView.findViewById(R.id.imgHotel);
            txtNameHotel = itemView.findViewById(R.id.txtNameHotel);
            txtLocation = itemView.findViewById(R.id.txtLocation);
        }
    }
}
