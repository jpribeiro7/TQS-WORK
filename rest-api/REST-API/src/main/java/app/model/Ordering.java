/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author carlos
 */

@Entity
public class Ordering implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "ORDER_ID")
    private Integer id;
    
    @OneToMany(mappedBy = "ordering")
    private List<Seller_Product> produtos;
    
    private int idClient;
    private String address;
    private DeliveryStatus deliverStatus;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "client_id")
    Client client ;
    
    @ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "date_id")
    DateSet date;

    public Ordering() {
    }
    
    public Ordering(int idClient, DateSet date, List<Seller_Product> produtos, String address, DeliveryStatus deliverStatus){        
        this.idClient = idClient;
        this.date = date;
        this.produtos = produtos;
        this.address = address;
        this.deliverStatus = deliverStatus;
    }  
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
  
    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public DateSet getDate() {
        return date;
    }

    public void setDate(DateSet date) {
        this.date = date;
    }

    public List<Seller_Product> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Seller_Product> produtos) {
        this.produtos = produtos;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }
    
    public DeliveryStatus getDeliverStatus() {
        return deliverStatus;
    }

    public void setDeliverStatus(DeliveryStatus deliverStatus) {
        this.deliverStatus = deliverStatus;
    }
   
}
