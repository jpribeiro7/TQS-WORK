/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.model.Ordering;
import app.repository.OrderingRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author carlos
 */
@Service
public class OrderingService {
    
    @Autowired
    private OrderingRepository orderingRepository;
    
    public List<Ordering> getAllOrders(){
        return orderingRepository.findAll();
    }
    
    public Optional<Ordering> getOrderByID(int id){
        return orderingRepository.findById(id);
    }
    
    public List<Ordering> findByClientID(Integer id){
        List<Ordering> ordersByClientID = new ArrayList<>();
        for(Ordering ord: orderingRepository.findAll()){
            if (ord.getIdClient() == id)
                ordersByClientID.add(ord);
        }
        return ordersByClientID;
    }
    
    public boolean register(Ordering data) {
        if(checkIfCanAdd(data))
        {
            orderingRepository.save(data);
            return true;
        }
        return false;
    }
    
    private boolean checkIfCanAdd(Ordering order){
        List<Ordering> orderList = orderingRepository.findAll();
        return orderList.stream().noneMatch(
                (o) -> (o.getAddress().equals(order.getAddress())
                        || o.getClient().equals(order.getClient())
                        || o.getDate().equals(order.getDate())
                        || o.getIdClient()==(order.getIdClient())
                        || o.getProdutos() ==(order.getProdutos()))
        );
    }
}
