package com.example.hotelbooking.entities;

public class Hotel {
    private String imageUrl;
    private float rating;
    private int reviews;
    private String name;
    private String location;
    private String price;

    public Hotel(String imageUrl, float rating, int reviews, String name, String location, String price) {
        this.imageUrl = imageUrl;
        this.rating = rating;
        this.reviews = reviews;
        this.name = name;
        this.location = location;
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
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

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
