/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import java.util.Map;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;

//import javax.faces.context.FacesContext;
/**
 *
 * @author carlossoares
 */

@ManagedBean(name = "details")
@SessionScoped
public class DetailsBean {

    private String name;
    private String description;
    private float price;
    private int id;
    private String category;
    private int quantity;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
    
    public String quantityUp(){
        setQuantity(quantity+=1);
        System.out.println("entrei");
        return "details";
    }
    public String quantityDown(){
        if(quantity!=1){
            setQuantity(quantity-=1);
        }
        else{}
        return "details";
        
    }
    
    

    public DetailsBean(){
        quantity=1;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public float getPrice() {
        return price;
    }
    
    

    public String parametersAction() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        name = params.get("name");
        price= Float.parseFloat(params.get("price"));
        description = params.get("description");
        id=Integer.parseInt(params.get("id"));
        category=params.get("category");

        System.out.println(params);

        return "details";
    }

}
