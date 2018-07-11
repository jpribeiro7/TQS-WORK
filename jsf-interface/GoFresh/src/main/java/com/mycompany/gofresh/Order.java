/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author carlossoares
 */
public class Order implements Serializable{
    private static final long serialVersionUID = 1L;
    private String address;
    private int idOrder;
    private String client;
    private ArrayList <Product> list;
    private String date;
    private String state;
    private float total;

    public Order(String address, int idOrder, String client, ArrayList<Product> list, String date,String state,float total) {
        this.address = address;
        this.idOrder = idOrder;
        this.client = client;
        this.list = list;
        this.date = date;
        this.state=state;
        this.total=total;
    }

    public float getTotal() {
        return total;
    }

    public void setTotal(float total) {
        this.total = total;
    }
    
    

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public String getClient() {
        return client;
    }

    public void setClient(String client) {
        this.client = client;
    }

    public ArrayList<Product> getList() {
        return list;
    }

    public void setList(ArrayList<Product> list) {
        this.list = list;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Order{" + "address=" + address + ", idOrder=" + idOrder + ", client=" + client + ", list=" + list + ", date=" + date + ", state=" + state + ", total=" + total + '}';
    }

    


    



}


