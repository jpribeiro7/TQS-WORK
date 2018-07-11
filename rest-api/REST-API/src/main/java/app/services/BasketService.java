/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.model.Basket;
import app.model.Seller_Product;
import app.repository.BasketRepository;
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
public class BasketService {
    
    @Autowired
    private BasketRepository basketRepository;

    public List<Basket> getAllBaskets(){
        return basketRepository.findAll();
    }
    
    public Optional<Basket> getBasketByID(int id){
        return basketRepository.findById(id);
    }
    
    public List<Basket> findByProductName(String name){
        List<Basket> basketsWithProductName = new ArrayList<>();
        for(Basket basket: basketRepository.findAll()){
            List<Seller_Product> produtos = basket.getProdutos();
            for(Seller_Product produto : produtos){
                if(produto.getProduct().getName().equals(name))
                    basketsWithProductName.add(basket);
            }
        }
        return basketsWithProductName;
    }
    
    
    
    public boolean register(Basket data) {
        if(checkIfCanAdd(data))
        {
            basketRepository.save(data);
            return true;
        }
        return false;
    }
    
    private boolean checkIfCanAdd(Basket basket){
        List<Basket> basketList = basketRepository.findAll();
        return basketList.stream().noneMatch(
                (b) -> (b.getProdutos().equals(basket.getProdutos())
                        || b.getTotalPrice() == (basket.getTotalPrice()))                       
        );
    }
}
