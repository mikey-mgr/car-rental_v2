package com.Mike.Proj.dto;

import java.util.ArrayList;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;


public class ProductDto {
    // for create it can be optional
    // for update we need the id
	@Nullable
    private Integer id;
    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    private @NotNull String description;
    private @NotNull Integer categoryId;
    private @NotNull String bookingStatus;
    private ArrayList<String> features;
    private ArrayList<String> carousel_imgs;


    public ProductDto() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Integer categoryId) {
        this.categoryId = categoryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return @NotNull String return the bookingStatus
     */
    public @NotNull String getBookingStatus() {
        return bookingStatus;
    }

    /**
     * @param bookingStatus the bookingStatus to set
     */
    public void setBookingStatus(@NotNull String bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    /**
     * @return @NotNull ArrayList<String> return the features
     */
    public ArrayList<String> getFeatures() {
        return features;
    }

    /**
     * @param features the features to set
     */
    public void setFeatures(ArrayList<String> features) {
        this.features = features;
    }


    /**
     * @return ArrayList<String> return the carousel_imgs
     */
    public ArrayList<String> getCarousel_imgs() {
        return carousel_imgs;
    }

    /**
     * @param carousel_imgs the carousel_imgs to set
     */
    public void setCarousel_imgs(ArrayList<String> carousel_imgs) {
        this.carousel_imgs = carousel_imgs;
    }

}