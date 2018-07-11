/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author carlos
 */
@Entity
public class Basket implements Serializable{

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "BASKET_ID")
    private int id;

    private double totalPrice;

    @OneToMany(mappedBy = "basket")
    private List<Seller_Product> produtos;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "order_id")
    Ordering order;

    public Basket() {
    }

    public Basket(double totalPrice, List<Seller_Product> produtos) {
        this.totalPrice = totalPrice;
        this.produtos = produtos;
        
    }
    
    public List<Seller_Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Seller_Product> produtos) {
        this.produtos = produtos;
    }

    public Ordering getOrder() {
        return order;
    }

    public void setOrder(Ordering order) {
        this.order = order;
    }
    
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
}
