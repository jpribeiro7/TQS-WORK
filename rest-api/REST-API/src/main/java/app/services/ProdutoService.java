/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import app.model.Product;
import app.repository.ProductRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class ProdutoService {
    
    @Autowired
    private ProductRepository productRepository;
    
    public List<Product> getAllProducts(){
        return productRepository.findAll();
    }

    public Optional<Product> getProductByID(Integer id) {
        return productRepository.findById(id);
    }

    public List<Product> getProductByCategory(String category) {
        return productRepository.findByCategory(category);
    }

    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();
        productRepository.findAll().forEach(f ->{
            if (!categories.contains(f.getCategory()))
                categories.add(f.getCategory());});
        return categories;
    }
}
