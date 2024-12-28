package com.example.hotelbooking.activities;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.hotelbooking.R;
import com.example.hotelbooking.adapters.BestHotelAdapter;
import com.example.hotelbooking.entities.PopularDestination;
import com.example.hotelbooking.interfaces.AttractionApiService;
import com.example.hotelbooking.response.PopularDestinationResponse;
import com.example.hotelbooking.retrofit.RetrofitClient;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    String baseUrl = "https://booking-com15.p.rapidapi.com/";
    String apiKey = "ec0b18b95emshe9254e3cb44c8d3p19bed8jsnffe7d747e56d";
    String apiHost = "booking-com15.p.rapidapi.com";
    private ArrayList<PopularDestination> items;
    private BestHotelAdapter adapter;
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
        adapter = new BestHotelAdapter(this, items);
        recyclerViewBestHotels.setAdapter(adapter);
        fetchBestHotels();
    }

    private void fetchBestHotels() {
        AttractionApiService apiService = RetrofitClient.getClient(baseUrl).create(AttractionApiService.class);
        apiService.searchAttractions(apiKey, apiHost, "vietnam")
                .enqueue(new Callback<PopularDestinationResponse>() {
                    @SuppressLint("NotifyDataSetChanged")
                    @Override
                    public void onResponse(@NonNull Call<PopularDestinationResponse> call, @NonNull Response<PopularDestinationResponse> response) {
                        if (response.isSuccessful() && response.body() != null) {
                            try {
                                List<PopularDestination> data = response.body().getData();
                                for (PopularDestination item : data) {
                                    String imageUrl = item.getImageUrl();
                                    String name = item.getName();
                                    String city = item.getCityName();
                                    String region = item.getRegion();
                                    String location = city + ", " + region;
                                    items.add(new PopularDestination(imageUrl, name, location, city, region));
                                }
                                adapter.notifyDataSetChanged();
                                Log.d("d", "Items count: " + items.size());

                            } catch (Exception e) {
                                Log.e("API", "Error parsing JSON: " + e.getMessage());
                            }
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<PopularDestinationResponse> call, @NonNull Throwable t) {
                        Log.e("API", "Error: " + t.getMessage());
                    }
                });
    }
}