/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import model.LoginBody;
import model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import services.ProdutoService;

/**
 *
 * @author Pedro
 */
@RestController()
@RequestMapping(value="/product")
public class ProdutoController {
    
    @Autowired
    private ProdutoService productService;
    
    @RequestMapping(value="/all",method = GET)
    public ResponseEntity<?> getAllProduct(){
        List<Product> list = productService.getAllProducts();
        return list!=null ? 
                new ResponseEntity<List<Product>>(list,HttpStatus.OK): 
                new ResponseEntity<String>("No products were found",HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value="/byID",method = GET)
    public ResponseEntity<?> getProductByID(@RequestParam(value="id",required=false)Integer id){
        if (id == null) return new  ResponseEntity<String>("ID field wasn't sent",HttpStatus.BAD_REQUEST);
        Product product = productService.getProductByID(id);
        return product!=null ? 
                new ResponseEntity<Product>(product,HttpStatus.OK): 
                new ResponseEntity<String>("No product with this id",HttpStatus.NOT_FOUND);
    }
   
    @RequestMapping(value="/byCategory",method = GET)
    public ResponseEntity<?> getProductByCategory(@RequestParam(value="category",required=false)String category){
        if (category == null) return new  ResponseEntity<String>("Category field wasn't sent",HttpStatus.BAD_REQUEST);
        List<Product> products = productService.getProductByCategory(category);
        return products!=null && !products.isEmpty() ? 
                new ResponseEntity<List<Product>>(products,HttpStatus.OK): 
                new ResponseEntity<String>("No product within this category",HttpStatus.NOT_FOUND);
    }

    
    
    
    @RequestMapping(value="/categories",method = GET)
    public ResponseEntity<?> getAllCategories(){
        List<String> categories = productService.getAllCategories();
        return categories!=null && !categories.isEmpty() ? 
                new ResponseEntity<List<String>>(categories,HttpStatus.OK): 
                new ResponseEntity<String>("No categories available",HttpStatus.NOT_FOUND);
    }
}
