/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.model.Client;
import app.model.Ordering;
import app.model.Seller;
import app.model.User;
import app.requestBody.OrderBody;
import app.requestBody.UserBody;
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
@RequestMapping(value="/orders")
public class OrderingController {
    
    @Autowired
    private OrderingService orderingService;
    
    @RequestMapping(value="/all",method = GET)
    public ResponseEntity<?> getAllOrders(){
        List<Ordering> list = orderingService.getAllOrders();
        return list!=null ? 
                new ResponseEntity<List<Ordering>>(list,HttpStatus.OK)
                : 
                new ResponseEntity<String>("No orders were found",HttpStatus.NOT_FOUND);
    }
    
    @RequestMapping(value="/byID",method = GET)
    public ResponseEntity<?> getOrderByID(@RequestParam(value="id",required=false)Integer id){
        if (id == null) 
            return new  ResponseEntity<String>("ID field wasn't sent",HttpStatus.BAD_REQUEST);
        Optional<Ordering> order = orderingService.getOrderByID(id);
        return new ResponseEntity<Optional<Ordering>>(order,HttpStatus.OK);    
    }
    
    @RequestMapping(value="/byClientID",method = GET)
    public ResponseEntity<?> getAllOrdersByClientID(@RequestParam(value="id",required=false)Integer id){
        if (id == null) 
            return new  ResponseEntity<String>("ID field wasn't sent",HttpStatus.BAD_REQUEST);
        List<Ordering> order = orderingService.findByClientID(id);
        return new ResponseEntity<List<Ordering>>(order,HttpStatus.OK); 
    }
    
    @RequestMapping(value="/makeorder", method = POST)
    public ResponseEntity<?> register(@RequestBody OrderBody data){
        ResponseEntity<?> response = null;
        Ordering order = null;
        
        order.setAddress(data.getAddress());
        order.setClient(data.getClient());
        order.setDate(data.getDate());
        order.setIdClient(data.getIdClient());
        order.setProdutos(data.getProdutos());
        order.setDeliverStatus(data.getDeliveryStatus());
        response = new ResponseEntity<>(orderingService.register(order),HttpStatus.OK);
        return response;
    }
}

