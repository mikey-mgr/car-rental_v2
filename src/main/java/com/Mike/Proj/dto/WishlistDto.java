package com.Mike.Proj.dto;

import java.util.Date;

import com.Mike.Proj.model.Wishlist;

public class WishlistDto {
    private Integer id;

    private Integer productId;

    private Integer userId;

    private Date createdDate;

    public WishlistDto(Integer id, Integer productId, Integer userId, Date createdDate) {
        this.id = id;
        this.productId = productId;
        this.userId = userId;
        this.createdDate = createdDate;
    }
    
    public WishlistDto(Wishlist wishlist){
        this.id = wishlist.getId();
        this.productId = wishlist.getProduct().getId();
        this.userId = wishlist.getUser().getId();
        this.createdDate = wishlist.getCreatedDate();
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
     * @return Integer return the productId
     */
    public Integer getProductId() {
        return productId;
    }

    /**
     * @param productId the productId to set
     */
    public void setProductId(Integer productId) {
        this.productId = productId;
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

    /**
     * @return Date return the createdDate
     */
    public Date getCreatedDate() {
        return createdDate;
    }

    /**
     * @param createdDate the createdDate to set
     */
    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

}
