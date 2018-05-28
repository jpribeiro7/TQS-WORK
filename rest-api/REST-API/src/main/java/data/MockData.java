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
import model.User;

/**
 *
 * @author Pedro
 */

public class MockData {
    private static Map<String,String> logins;
    private static List<Product> allProducts;
    private static List<User> users;

    public static Map<String, String> getUsers() {
        logins = new HashMap<>();
        logins.put("salome","123");
        logins.put("arinto","123");
        logins.put("ze","123");
        logins.put("carlos","123");
        return logins;
    }

    public static List<Product> getAllProducts() {
        allProducts = new ArrayList<>();
        allProducts.add(new Product(1,"alface","legumes",1.45f,"é verde"));
        allProducts.add(new Product(2,"batata","legumes",1.49f,"é castanha"));
        allProducts.add(new Product(3,"alho","legumes",4.99f,"é mau"));
        allProducts.add(new Product(4,"couve branca","legumes",1.29f,"é verde"));
        allProducts.add(new Product(5,"morangos","fruta",1.29f,"é vermelho"));
        
        return allProducts;
    }
    
    public static List<User> getAllUsers() {
        users = new ArrayList<>();
        users.add(new User(1, "salome", "123", "salome lopes", "salome@ua.pt", 785412965, "Rua Direita n85", "3810-895", 915268478));
        users.add(new User(1, "arinto", "123", "carlos arinto", "arinto@ua.pt",123458967 , "Rua Direita n85", "3810-895", 915268478));
        users.add(new User(1, "ze", "123", "jose ribeiro", "ze@ua.pt", 852369741, "Rua Direita n85", "3810-895", 915268478));
        users.add(new User(1, "carlos", "123", "carlos soares", "carlos@ua.pt", 225366987, "Rua Direita n85", "3810-895", 915268478));
        return users;
    }
    

    
    
    
    
}
