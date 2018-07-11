/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.requestBody;

import app.model.Seller_Product;
import java.util.List;

/**
 *
 * @author carlos
 */
public class BasketBody {
    
    private double totalPrice;
    private List<Seller_Product> produtos;

    public BasketBody(double totalPrice, List<Seller_Product> produtos) {
        this.totalPrice = totalPrice;
        this.produtos = produtos;
    }
     
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public List<Seller_Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Seller_Product> produtos) {
        this.produtos = produtos;
    }
     
     
}
