/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import java.util.List;
import app.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.repository.UserRepository;
import app.util.Type;

/**
 *
 * @author salome
 */

@Service
public class UserService {
    
    @Autowired
    private UserRepository userList;
    
    public List<User> getAllUsers(){
        return userList.findAll();
    }
    
    public List<User> getAllClients(){
        return userList.findByType("client");
    }
    
    public List<User> getAllSellers(){
        return userList.findByType("seller");
    }
    
}
