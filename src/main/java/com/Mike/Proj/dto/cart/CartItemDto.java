package com.Mike.Proj.dto.cart;

import java.util.Date;

import com.Mike.Proj.model.Cart;
import com.Mike.Proj.model.Product;

public class CartItemDto {
    private Integer id;
    private Integer quantity;
    private Product product;
    private Date bookedFor;

    /**
     * @return Integer return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * @return Integer return the quantity
     */
    public Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    /**
     * @return Product return the product
     */
    public Product getProduct() {
        return product;
    }

    /**
     * @param product the product to set
     */
    public void setProduct(Product product) {
        this.product = product;
    }

    public CartItemDto(Cart cart){
        this.id = cart.getId();
        this.quantity = cart.getQuantity();
        this.setProduct(cart.getProduct());
        this.setBookedFor(cart.getBookedFor());
    }

    /**
     * @return Date return the bookedFor
     */
    public Date getBookedFor() {
        return bookedFor;
    }

    /**
     * @param bookedFor the bookedFor to set
     */
    public void setBookedFor(Date bookedFor) {
        this.bookedFor = bookedFor;
    }

}