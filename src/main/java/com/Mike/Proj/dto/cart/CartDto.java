package com.Mike.Proj.dto.cart;

import java.util.List;

public class CartDto {
    private List<CartItemDto> cartItems;
    //cart item dto has 3 fields: id, quantity and product object
    private double totalCost;

    public List<CartItemDto> getCartItems() {
        return cartItems;
    }

    public void setCartItems(List<CartItemDto> cartItems) {
        this.cartItems = cartItems;
    }

    public CartDto() {
    }

    /**
     * @return double return the totalCost
     */
    public double getTotalCost() {
        return totalCost;
    }

    /**
     * @param totalCost the totalCost to set
     */
    public void setTotalCost(double totalCost) {
        this.totalCost = totalCost;
    }

}
