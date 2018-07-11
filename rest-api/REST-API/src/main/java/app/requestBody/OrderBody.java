/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.requestBody;

import app.model.Client;
import app.model.DateSet;
import app.model.DeliveryStatus;
import app.model.Seller_Product;
import java.util.List;

/**
 *
 * @author carlos
 */
public class OrderBody {
    private int idClient;
    private List<Seller_Product> produtos;
    private String address;
    private Client client;
    private DateSet date;
    private DeliveryStatus deliveryStatus;

    public OrderBody(int idClient, List<Seller_Product> produtos, String address, Client client, DateSet date, DeliveryStatus deliveryStatus) {
        this.idClient = idClient;
        this.produtos = produtos;
        this.address = address;
        this.client = client;
        this.date = date;
        this.deliveryStatus = deliveryStatus;
    }

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
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

    public DateSet getDate() {
        return date;
    }

    public void setDate(DateSet date) {
        this.date = date;
    }

    public DeliveryStatus getDeliveryStatus() {
        return deliveryStatus;
    }

    public void setDeliveryStatus(DeliveryStatus deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }
    
    
}
