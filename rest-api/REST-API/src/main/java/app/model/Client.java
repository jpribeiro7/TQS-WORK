/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.OneToMany;

/**
 *
 * @author carlos
 */
@Entity
public class Client extends User{

    @JsonIgnore
    @OneToMany(mappedBy="client" ,cascade=CascadeType.MERGE)
    @JsonBackReference("clientList")
    private List<Ordering> orderList = new ArrayList<>();

    public Client() {
    }
    
    public Client(String username, String password, String name, String email, Integer nif, String address, String codigo_postal, Integer phone_number, String type) {
        super(username, password, name, email, nif, address, codigo_postal, phone_number,type);
    }

    public List<Ordering> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Ordering> orderList) {
        this.orderList = orderList;
    }
    
    
}
