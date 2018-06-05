/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import javax.persistence.Entity;

/**
 *
 * @author Pedro
 */
@Entity
public class Client extends User{

    public Client(String username, String password, String name, String email, Integer nif, String address, String codigo_postal, Integer phone_number, String type) {
        super(username, password, name, email, nif, address, codigo_postal, phone_number,type);
    }

    public Client() {
    }
    
    
}
