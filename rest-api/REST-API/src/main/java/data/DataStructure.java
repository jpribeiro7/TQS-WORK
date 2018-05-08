/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author Pedro
 */

public class DataStructure {
    private static Map<String,String> users;

    public static Map<String, String> getUsers() {
        users = new HashMap<>();
        users.put("salome","123");
        users.put("arinto","123");
        users.put("ze","123");
        users.put("carlos","123");
        return users;
    }

      
    
    
}
