/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.MockData;
import java.util.List;
import model.User;
import org.springframework.stereotype.Service;

/**
 *
 * @author salome
 */

@Service
public class UserService {
    
    public List<User> getAllUsers(){
        return MockData.getAllUsers();
    }
    
}
