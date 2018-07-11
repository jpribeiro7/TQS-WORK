/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import java.io.Serializable;

/**
 *
 * @author carlossoares
 */
public class Product implements Serializable{
    private static final long serialVersionUID = 1L;
    
    private int id;
    private String name;
    private String category;
    private float price;
    private String description;
    private int quantity;
    private float subtotal;
    private String seller;
    
    

    public Product(int id,String name, String category,int quantity, float price, String description,String seller) {
        this.name = name;
        this.price = price;
        this.description = description;
        this.category = category;
        this.id = id;
        this.quantity=quantity;
        this.seller=seller;
    }

    public float getSubtotal() {
        return subtotal;
    }

    public void setSubtotal(float subtotal) {
        this.subtotal = subtotal;
    }

    public String getSeller() {
        return seller;
    }

    public void setSeller(String seller) {
        this.seller = seller;
    }
    
    
    public void setQuantity(int quantity){
        this.quantity=quantity;
    }
    
    
    public int getQuantity(){
        return quantity;
    }
    public float getSubTotal(){
        return price*quantity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "\"id\":" + id + ",\"name\":\"" + name + "\",\"category\":\"" + category + "\",\"price\":" + price + ",\"description\":\"" + description + "\",\"quantity\":" + quantity + ",\"seller\":\"" + seller + "\"}";
    }

    
    
    
    
}
