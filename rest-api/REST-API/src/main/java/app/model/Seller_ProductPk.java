/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import java.io.Serializable;
import javax.persistence.Embeddable;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 *
 * @author Pedro
 */
@Embeddable
public class Seller_ProductPk implements Serializable{
    
    private Integer productID;
    private Integer sellerID;
    
    public Seller_ProductPk(Integer productID, Integer sellerID) {
        this.productID = productID;
        this.sellerID = sellerID;
    }
    
    public Seller_ProductPk() {
    }

    public Integer getProductID() {
        return productID;
    }

    public void setProductID(Integer productID) {
        this.productID = productID;
    }

    public Integer getSellerID() {
        return sellerID;
    }

    public void setSellerID(Integer sellerID) {
        this.sellerID = sellerID;
    }

    

   

   
    
    
    
    
    
}
