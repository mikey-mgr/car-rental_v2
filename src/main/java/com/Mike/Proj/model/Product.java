package com.Mike.Proj.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "car")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private @NotNull String name;
    private @NotNull String imageURL;
    private @NotNull double price;
    @Column(length = 1000)
    private @NotNull String description;
    private @NotNull String bookingStatus;
    // private @NotNull List<String> features;


    // Many to one relationship
    @ManyToOne
    @JsonIgnore
    @JoinColumn(name = "category_id")
    Category category;


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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
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

}