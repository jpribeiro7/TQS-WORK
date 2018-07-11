/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.model.Basket;
import app.model.Ordering;
import app.requestBody.BasketBody;
import app.requestBody.OrderBody;
import app.services.BasketService;
import app.services.OrderingService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author carlos
 */
@RestController()
@RequestMapping(value="/baskets")
public class BasketController {
    
    @Autowired
    private BasketService basketService;
    
    @RequestMapping(value="/all",method = GET)
    public ResponseEntity<?> getAllBaskets(){
        List<Basket> list = basketService.getAllBaskets();
        return list!=null ? 
                new ResponseEntity<List<Basket>>(list,HttpStatus.OK)
                : 
                new ResponseEntity<String>("No baskets were found",HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value="/byID",method = GET)
    public ResponseEntity<?> getBasketByID(@RequestParam(value="id",required=false)Integer id){
        if (id == null) 
            return new  ResponseEntity<String>("ID field wasn't sent",HttpStatus.BAD_REQUEST);
        Optional<Basket> basket = basketService.getBasketByID(id);
        return new ResponseEntity<Optional<Basket>>(basket,HttpStatus.OK);    
    }
    
    @RequestMapping(value="/byProductName",method = GET)
    public ResponseEntity<?> getAllOrdersByClientID(@RequestParam(value="name",required=false)String name){
        if (name == null) 
            return new  ResponseEntity<String>("name field wasn't sent",HttpStatus.BAD_REQUEST);
        List<Basket> order = basketService.findByProductName(name);
        return new ResponseEntity<List<Basket>>(order,HttpStatus.OK); 
    }
    
    @RequestMapping(value="/makebasket", method = POST)
    public ResponseEntity<?> register(@RequestBody BasketBody data){
        ResponseEntity<?> response = null;
        Basket basket = null;
        
        basket.setProdutos(data.getProdutos());
        basket.setTotalPrice(data.getTotalPrice());
        
        response = new ResponseEntity<>(basketService.register(basket),HttpStatus.OK);
        return response;
    }
    
}
