
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Pedro
 */
@Entity
public class Seller_Product implements Serializable{
    
    @EmbeddedId
    private Seller_ProductPk primary_key;
    private double price;
    private int quantity;
    
    @ManyToOne()
    @JoinColumn(name = "seller_id")
    @JsonManagedReference
    private Seller seller;
    
    @ManyToOne()
    @JsonManagedReference
    @JoinColumn(name = "product_id")
    private Product product;
    
    @ManyToOne()
    @JoinColumn(name = "basket_id")
    private Basket basket;
    
    @ManyToOne()
    @JoinColumn(name = "order_id")
    private Ordering ordering;
    
    public Seller_Product(double price, int quantity, Seller seller, Product product) {
        this.primary_key = new Seller_ProductPk(product.getId(),seller.getId());
        this.price = price;
        this.quantity = quantity;
        this.seller = seller;
        this.product = product;
    }

    public Basket getBasket() {
        return basket;
    }

    public void setBasket(Basket basket) {
        this.basket = basket;
    }

    public Ordering getOrdering() {
        return ordering;
    }

    public void setOrdering(Ordering ordering) {
        this.ordering = ordering;
    }
    
    
    
    public Seller_Product(Seller_ProductPk pk, double price, int quantity){
        this.primary_key = pk;
        this.price = price;
        this.quantity = quantity;
    }
    
    public Seller_Product(){
        
    }

    public Seller_ProductPk getPrimary_key() {
        return primary_key;
    }

    public void setPrimary_key(Seller_ProductPk primary_key) {
        this.primary_key = primary_key;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Seller getSeller() {
        return seller;
    }

    public void setSeller(Seller seller) {
        this.seller = seller;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
    
    
    
}