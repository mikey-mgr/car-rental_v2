package com.Mike.Proj.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "messages")
public class ContactMessages {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private @NotNull String name;
    private @NotNull String email;
    private @NotNull String city;
    private @NotNull String country;
    private @NotNull String phone;
    @Column(length = 2000)
    private @NotNull String message;

    public ContactMessages() {
    }

    public ContactMessages(@NotNull String name, @NotNull String email, @NotNull String city, @NotNull String country,
            @NotNull String phone, @NotNull String message) {
        this.name = name;
        this.email = email;
        this.city = city;
        this.country = country;
        this.phone = phone;
        this.message = message;
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
     * @return @NotNull String return the name
     */
    public @NotNull String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(@NotNull String name) {
        this.name = name;
    }

    /**
     * @return @NotNull String return the email
     */
    public @NotNull String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(@NotNull String email) {
        this.email = email;
    }

    /**
     * @return @NotNull String return the city
     */
    public @NotNull String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(@NotNull String city) {
        this.city = city;
    }

    /**
     * @return @NotNull String return the country
     */
    public @NotNull String getCountry() {
        return country;
    }

    /**
     * @param country the country to set
     */
    public void setCountry(@NotNull String country) {
        this.country = country;
    }

    /**
     * @return @NotNull String return the phone
     */
    public @NotNull String getPhone() {
        return phone;
    }

    /**
     * @param phone the phone to set
     */
    public void setPhone(@NotNull String phone) {
        this.phone = phone;
    }

    /**
     * @return @NotNull String return the message
     */
    public @NotNull String getMessage() {
        return message;
    }

    /**
     * @param message the message to set
     */
    public void setMessage(@NotNull String message) {
        this.message = message;
    }

}
