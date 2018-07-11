/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonView;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author Pedro
 */
@Entity
public class Seller extends User{
    
    @OneToMany(mappedBy="seller",cascade = CascadeType.ALL)
    @JsonBackReference("sellerList")
    private List<Seller_Product> productList = new ArrayList<>();

    public Seller(String username, String password, String name, String email, Integer nif, String address, String codigo_postal, Integer phone_number, String type) {
        super(username, password, name, email, nif, address, codigo_postal, phone_number,type);
    }

    public Seller() {
    }

    public List<Seller_Product> getProductList() {
        return productList;
    }

    public void setProductList(List<Seller_Product> productList) {
        this.productList = productList;
    }

    
    
    
    
}
