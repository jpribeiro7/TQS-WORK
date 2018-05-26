/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import model.Product;

/**
 *
 * @author Pedro
 */

public class MockData {
    private static Map<String,String> users;
    private static List<Product> allProducts;

    public static Map<String, String> getUsers() {
        users = new HashMap<>();
        users.put("salome","123");
        users.put("arinto","123");
        users.put("ze","123");
        users.put("carlos","123");
        return users;
    }

    public static List<Product> getAllProducts() {
        allProducts = new ArrayList<>();
        allProducts.add(new Product(1,"alface","legumes",1.45f,"é verde"));
        allProducts.add(new Product(2,"batata","legumes",1.49f,"é castanha"));
        allProducts.add(new Product(3,"alho","legumes",4.99f,"é mau"));
        allProducts.add(new Product(4,"couve branca","legumes",1.29f,"é verde"));
        
        return allProducts;
    }

    
    
    
    
}
