/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package services;

import data.MockData;
import java.util.HashMap;
import java.util.Map;
import org.springframework.stereotype.Service;

/**
 *
 * @author Pedro
 */
@Service
public class LoginService {
    public boolean authenticate(String username, String password){
        boolean flag = false;
        for(Map.Entry<String,String> entry : MockData.getUsers().entrySet()){
            
            if(entry.getKey().equals(username) && entry.getValue().equals(password)){
                System.out.println("Entrei");
                flag = true;
            }
                
        }
            
        return flag;
    }
}
