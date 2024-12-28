package com.example.hotelbooking.interfaces;

import com.example.hotelbooking.response.PopularDestinationResponse;

import org.json.JSONObject;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Query;

public interface AttractionApiService {
    @GET("/api/v1/hotels/searchDestination")
    Call<PopularDestinationResponse> searchAttractions(
            @Header("X-Rapidapi-Key") String apiKey,
            @Header("X-Rapidapi-Host") String apiHost,
            @Query("query") String country
    );
}
