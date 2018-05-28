/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.MockData;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
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

    public Product getProductByID(int id) {
        Product product = MockData.getAllProducts().stream().filter((f) -> id == f.getId()).findAny().orElse(null);
        return product;
    }

    public List<Product> getProductByCategory(String category) {
        return MockData.getAllProducts().stream().filter(f -> f.getCategory().equals(category)).collect(Collectors.toList());
    }

    public List<String> getAllCategories() {
        List<String> categories = new ArrayList<>();
        MockData.getAllProducts().forEach(f ->{
            if (!categories.contains(f.getCategory()))
                categories.add(f.getCategory());});
        return categories;
    }
}
