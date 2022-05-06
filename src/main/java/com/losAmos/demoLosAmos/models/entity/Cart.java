package com.losAmos.demoLosAmos.models.entity;

import javax.persistence.*;

@Entity
@Table(name="purchases")
public class Cart {
    // ----------------- //
    // --- ATRIBUTES --- //
    // ----------------- //

    private int item;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    private Float total_price;
    private Float final_price;
    private Float discount;

    private String order_date;
    private boolean status;


    private Long id_user;
    private Long id_product;

    // ------------------- //
    // --- CONSTRUCTOR --- //
    // ------------------ //

    public Cart(){
    }

    public Cart(int item, Float total_price, Float final_price, Float discount, String order_date, boolean status, Long id_user, Long id_product) {
        this.item = item;
        this.total_price = total_price;
        this.final_price = final_price;
        this.discount = discount;
        this.order_date = order_date;
        this.status = status;
        this.id_user = id_user;
        this.id_product = id_product;
    }

    public Cart(int item, Long id, Float total_price, Float final_price, Float discount, String order_date, boolean status, Long id_user, Long id_product) {
        this.item = item;
        this.id = id;
        this.total_price = total_price;
        this.final_price = final_price;
        this.discount = discount;
        this.order_date = order_date;
        this.status = status;
        this.id_user = id_user;
        this.id_product = id_product;
    }

    // ------------------------- //
    // --- GETTERS & SETTERS --- //
    // ------------------------- //

    public int getItem() {
        return item;
    }

    public void setItem(int item) {
        this.item = item;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Float getTotal_price() {
        return total_price;
    }

    public void setTotal_price(Float total_price) {
        this.total_price = total_price;
    }

    public Float getFinal_price() {
        return final_price;
    }

    public void setFinal_price(Float final_price) {
        this.final_price = final_price;
    }

    public Float getDiscount() {
        return discount;
    }

    public void setDiscount(Float discount) {
        this.discount = discount;
    }

    public String getOrder_date() {
        return order_date;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Long getId_user() {
        return id_user;
    }

    public void setId_user(Long id_user) {
        this.id_user = id_user;
    }

    public Long getId_product() {
        return id_product;
    }

    public void setId_product(Long id_product) {
        this.id_product = id_product;
    }
}
