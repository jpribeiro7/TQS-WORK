/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.model.Seller_Product;
import app.repository.SellerProductRepository;
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
    
    public List<Seller_Product> getAll(){
        return sellerProductRepository.findAll();
    }
}
