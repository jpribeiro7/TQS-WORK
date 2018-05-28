/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.MockData;
import java.util.List;
import model.Product;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class ProdutoService {
    
    
    public List<Product> getAllProducts(){
        return MockData.getAllProducts();
    }
}
