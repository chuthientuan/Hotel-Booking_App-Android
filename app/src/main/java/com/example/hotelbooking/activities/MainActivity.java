package com.example.hotelbooking.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelbooking.R;
import com.example.hotelbooking.adapters.PopularDestinationAdapter;
import com.example.hotelbooking.entities.PopularDestination;
import com.google.android.material.bottomsheet.BottomSheetBehavior;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    String baseUrl = "https://booking-com15.p.rapidapi.com/";
    String apiKey = "ec0b18b95emshe9254e3cb44c8d3p19bed8jsnffe7d747e56d";
    String apiHost = "booking-com15.p.rapidapi.com";
    BottomSheetBehavior<LinearLayout> bottomSheetBehavior;
    private ArrayList<PopularDestination> items;
    private PopularDestinationAdapter adapter;
    private RecyclerView recyclerViewBestHotels;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        recyclerViewBestHotels = findViewById(R.id.recyclerViewBestHotels);
        recyclerViewBestHotels.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        items = new ArrayList<>();
        adapter = new PopularDestinationAdapter(this, items);
        recyclerViewBestHotels.setAdapter(adapter);
        fetchPopularDestinations();


        setBottomSheetBehavior();
    }

    private void fetchPopularDestinations() {
        items.add(new PopularDestination(R.drawable.hanoi, "Hà Nội"));
        items.add(new PopularDestination(R.drawable.hochiminh, "Hồ Chí Minh"));
        items.add(new PopularDestination(R.drawable.hoian, "Hội An"));
        items.add(new PopularDestination(R.drawable.danang, "Đà Nẵng"));
        items.add(new PopularDestination(R.drawable.phuquoc, "Phú Quốc"));
        items.add(new PopularDestination(R.drawable.nhatrang, "Nha Trang"));
        items.add(new PopularDestination(R.drawable.hue, "Huế"));
        items.add(new PopularDestination(R.drawable.ninhbinh, "Ninh Bình"));
        adapter.notifyDataSetChanged();
    }

    //    private void fetchBestHotels() {
//        AttractionApiService apiService = RetrofitClient.getClient(baseUrl).create(AttractionApiService.class);
//        apiService.searchAttractions(apiKey, apiHost, "vietnam")
//                .enqueue(new Callback<PopularDestinationResponse>() {
//                    @SuppressLint("NotifyDataSetChanged")
//                    @Override
//                    public void onResponse(@NonNull Call<PopularDestinationResponse> call, @NonNull Response<PopularDestinationResponse> response) {
//                        if (response.isSuccessful() && response.body() != null) {
//                            try {
//                                List<PopularDestination> data = response.body().getData();
//                                for (PopularDestination item : data) {
//                                    String imageUrl = item.getImageUrl();
//                                    String name = item.getName();
//                                    String city = item.getCityName();
//                                    String region = item.getRegion();
//                                    String location = city + ", " + region;
//                                    items.add(new PopularDestination(imageUrl, name, location, city, region));
//                                }
//                                adapter.notifyDataSetChanged();
//                                Log.d("d", "Items count: " + items.size());
//
//                            } catch (Exception e) {
//                                Log.e("API", "Error parsing JSON: " + e.getMessage());
//                            }
//                        }
//                    }
//
//                    @Override
//                    public void onFailure(@NonNull Call<PopularDestinationResponse> call, @NonNull Throwable t) {
//                        Log.e("API", "Error: " + t.getMessage());
//                    }
//                });
//    }
    private void setBottomSheetBehavior() {
        LinearLayout layoutRoomGuest = findViewById(R.id.layout_room_guest);
        bottomSheetBehavior = BottomSheetBehavior.from(layoutRoomGuest);

        bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);

        findViewById(R.id.checkin).setOnClickListener(v -> {
            if (bottomSheetBehavior.getState() != BottomSheetBehavior.STATE_EXPANDED) {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_EXPANDED);
                layoutRoomGuest.setVisibility(View.VISIBLE);
            } else {
                bottomSheetBehavior.setState(BottomSheetBehavior.STATE_COLLAPSED);
            }
        });

        // Xử lý callback khi thay đổi trạng thái
        bottomSheetBehavior.addBottomSheetCallback(new BottomSheetBehavior.BottomSheetCallback() {
            @Override
            public void onStateChanged(@NonNull View bottomSheet, int newState) {
                // Khi bị ẩn thì set visibility về GONE
                if (newState == BottomSheetBehavior.STATE_COLLAPSED) {
                    bottomSheetBehavior.setState(BottomSheetBehavior.STATE_HIDDEN);
                    layoutRoomGuest.setVisibility(View.GONE);
                }
            }

            @Override
            public void onSlide(@NonNull View bottomSheet, float slideOffset) {
                // Xử lý hiệu ứng khi vuốt (nếu cần)
            }
        });
    }
}