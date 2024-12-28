package com.example.hotelbooking.entities;

public class PopularDestination {
    private String image_url;
    private String name;
    private String location;
    private String city_name;
    private String region;

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getCityName() {
        return city_name;
    }

    public void setCityName(String cityName) {
        this.city_name = cityName;
    }

    public PopularDestination(String imageUrl, String nameHotel, String location, String cityName, String region) {
        this.image_url = imageUrl;
        this.name = nameHotel;
        this.location = location;
        this.city_name = cityName;
        this.region = region;
    }

    public String getImageUrl() {
        return image_url;
    }

    public void setImageUrl(String imageUrl) {
        this.image_url = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
