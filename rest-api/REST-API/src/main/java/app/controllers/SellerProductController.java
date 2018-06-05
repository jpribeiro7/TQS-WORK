/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;
    
import app.model.Seller_Product;
import app.services.SellerProductService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Pedro
 */
@RestController()
@RequestMapping(value="/sellerProduct")
public class SellerProductController {
    
    @Autowired
    private SellerProductService sellerProductService;
    
    @RequestMapping(value="/all",method = GET)
    public ResponseEntity<?> getAllProduct(){
        List<Seller_Product> list = sellerProductService.getAll();
        return !list.isEmpty() ? 
                new ResponseEntity<>(list,HttpStatus.OK): 
                new ResponseEntity<>("No products were found",HttpStatus.NOT_FOUND);
    }
    
}
