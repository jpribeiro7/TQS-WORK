/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.model.Client;
import app.model.Seller;
import app.model.User;
import app.repository.UserRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class LoginService {
    
    @Autowired
    private UserRepository userRepository;
    
    public User authenticate(String username, String password){
        User user = userRepository.findByUsername(username);
        if(user!=null && user.getPassword().equals(password)){
            return user;
        }
        return null;
    }

    public boolean register(User data) {
        if(checkIfCanAdd(data)){
            userRepository.save(data);
            return true;
        }
        return false;
    }
    
    private boolean checkIfCanAdd(User user){
        List<User> userList = userRepository.findAll();
        if (!userList.stream().noneMatch(
                    (u) -> (u.getUsername().equals(user.getUsername()) 
                    || u.getEmail().equals(user.getEmail()) 
                    || u.getNif().equals(user.getNif()))
                )) 
        {
            return false;
        }
        return true;
    }
    
    
}
