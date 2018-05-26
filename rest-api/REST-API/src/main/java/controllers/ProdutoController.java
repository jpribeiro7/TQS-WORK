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
   

}
