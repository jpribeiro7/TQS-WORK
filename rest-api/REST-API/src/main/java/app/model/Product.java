/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Pedro
 */
@Entity
public class Product implements Serializable{
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "PRODUCT_ID")
    private Integer id;
    private String name;
    private String category;
    private String description;
    
    
    @OneToMany(mappedBy="product",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<Seller_Product> productsSeller = new ArrayList();

    public Product(String name, String category, String description) {
        this.name = name;
        this.category = category;
        this.description = description;
    }
    
    public Product(){
        
    }

    public List<Seller_Product> getProductsSeller() {
        return productsSeller;
    }

    public void setProductsSeller(List<Seller_Product> productsSeller) {
        this.productsSeller = productsSeller;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }


    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    
    
}
