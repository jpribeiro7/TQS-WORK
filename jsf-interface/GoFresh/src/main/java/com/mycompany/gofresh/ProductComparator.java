/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import java.util.Comparator;

/**
 *
 * @author carlossoares
 */
public class ProductComparator implements Comparator<Product>{
    
 
    @Override
    public int compare(Product p1, Product p2) {
        if(p1.getPrice()< p2.getPrice()){
            return -1;
        } else {
            return 1;
        }
    }

}
