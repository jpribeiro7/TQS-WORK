/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.repository.UserRepository;
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
    
    public boolean authenticate(String username, String password){
        System.out.println(username + " : "+password);
        return userRepository.findByUsername(username).getPassword().equals(password);
    }
}
