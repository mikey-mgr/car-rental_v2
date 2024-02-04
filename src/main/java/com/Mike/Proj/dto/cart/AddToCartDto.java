package com.Mike.Proj.dto.cart;

import java.util.Date;
import jakarta.validation.constraints.NotNull;

public class AddToCartDto {
    private Integer id;
    private @NotNull Integer productId;
    private @NotNull Integer quantity;
    private @NotNull Date bookedFor;


    public AddToCartDto(Integer productId, Integer quantity, Date bookedFor) {
        this.productId = productId;
        this.quantity = quantity;
        this.bookedFor = bookedFor;
    }

    public AddToCartDto() {
    }

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
     * @return @notNull Integer return the productId
     */
    public @NotNull Integer getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(@NotNull Integer productId) {
        this.productId = productId;
    }

    /**
     * @return @NotNull Integr return the quantity
     */
    public @NotNull Integer getQuantity() {
        return quantity;
    }

    /**
     * @param quantity the quantity to set
     */
    public void setQuantity(@NotNull Integer quantity) {
        this.quantity = quantity;
    }


    /**
     * @return @NotNull Date return the bookedFor
     */
    public @NotNull Date getBookedFor() {
        return bookedFor;
    }

    /**
     * @param bookedFor the bookedFor to set
     */
    public void setBookedFor(@NotNull Date bookedFor) {
        this.bookedFor = bookedFor;
    }

}
