package com.example.hotelbooking.response;

import com.example.hotelbooking.entities.PopularDestination;

import java.util.List;

public class PopularDestinationResponse {
    private List<PopularDestination> data;
    public List<PopularDestination> getData() { return data; }
    public void setData(List<PopularDestination> data) { this.data = data; }
}
