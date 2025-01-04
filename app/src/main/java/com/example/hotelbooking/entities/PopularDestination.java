package com.example.hotelbooking.entities;

public class PopularDestination {
    private int image_url;
    private String location;


    public PopularDestination(int imageUrl, String location) {
        this.image_url = imageUrl;
        this.location = location;
    }

    public int getImageUrl() {
        return image_url;
    }

    public void setImageUrl(int imageUrl) {
        this.image_url = imageUrl;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
