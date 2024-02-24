package com.Mike.Proj.dto.cart;

import java.time.LocalDate;

import com.Mike.Proj.model.Cart;
import com.Mike.Proj.model.Product;

public class CartItemDto {
    private Integer id;
    private Integer userId;
    private Integer quantity;
    private Product product;
    private LocalDate bookedFor;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public CartItemDto(Cart cart){
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
        this.setBookedFor(cart.getBookedFor());
        this.setUserId(cart.getUser().getId());
    }

    public LocalDate getBookedFor() {
        return bookedFor;
    }

    public void setBookedFor(LocalDate bookedFor) {
        this.bookedFor = bookedFor;
    }

    /**
     * @return Integer return the userId
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * @param userId the userId to set
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

}