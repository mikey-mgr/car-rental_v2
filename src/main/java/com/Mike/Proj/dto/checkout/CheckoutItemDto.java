package com.Mike.Proj.dto.checkout;

public class CheckoutItemDto {
    private String productName;
    private int quantity;
    private double price;
    private long productId;
    private int userId;


    public CheckoutItemDto(String productName, int quantity, double price, long productId, int userId) {
        this.productName = productName;
        this.quantity = quantity;
        this.price = price;
        this.productId = productId;
        this.userId = userId;
    }

    /**
     * @return String return the productName
     */
    public String getProductName() {
        return productName;
    }

    /**
     * @param productName the productName to set
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    /**
     * @return int return the quantity
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    /**
     * @return double return the price
     */
    public double getPrice() {
        return price;
    }

    /**
     * @param price the price to set
     */
    public void setPrice(double price) {
        this.price = price;
    }

    /**
     * @return long return the productId
     */
    public long getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(long productId) {
        this.productId = productId;
    }

    /**
     * @return int return the userId
     */
    public int getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(int userId) {
        this.userId = userId;
    }

}
