/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.model.Seller;
import app.model.Seller_Product;
import app.model.User;
import app.repository.SellerProductRepository;
import app.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class SellerProductService {
    
    @Autowired
    private SellerProductRepository sellerProductRepository;
    
    @Autowired
    private UserRepository sellerRepository;
    
    public List<Seller_Product> getAll(){
        return sellerProductRepository.findAll();
    }
    
    public List<Seller_Product> getProductsSeller(String user){
        Seller s1 = (Seller) sellerRepository.findByUsername(user);
        return s1.getProductList();
    }

    
}
