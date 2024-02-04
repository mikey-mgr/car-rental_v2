package com.Mike.Proj.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "wishlist")
public class Wishlist {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "car_id")
    Product product;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User user;

    @Column(name = "created_date")
    private Date createdDate;

    @Column(name = "booked_date")
    private Date bookedDate;

    public Wishlist(Integer id, Product product, User user, Date date, Date bookedDate) {
        this.id = id;
        this.product = product;
        this.user = user;
        this.createdDate = date;
        this.bookedDate = bookedDate;
    }

    public Wishlist() {
    }

    public Wishlist(User user2, Product product2) {
        this.user = user2;
        this.product = product2;
        this.createdDate =new Date();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Date getDate() {
        return createdDate;
    }

    public void setDate(Date date) {
        this.createdDate = date;
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

    /**
     * @return Date return the bookedDate
     */
    public Date getBookedDate() {
        return bookedDate;
    }

    /**
     * @param bookedDate the bookedDate to set
     */
    public void setBookedDate(Date bookedDate) {
        this.bookedDate = bookedDate;
    }

}