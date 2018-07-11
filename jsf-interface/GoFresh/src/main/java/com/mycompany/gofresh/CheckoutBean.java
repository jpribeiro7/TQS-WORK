/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.ejb.Stateful;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

/**
 *
 * @author carlossoares
 */
@SessionScoped
@ManagedBean(name = "checkout")
public class CheckoutBean {
    private String address;
    private String date;
    private ArrayList<Product> list;
    
    
    public CheckoutBean() {
        
        list= new ArrayList<>();

    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String finish(){
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        
        String list=params.get("list");
        String result=list.substring(1,list.length()-1);
        result+=",";
        System.out.println(params);

        String[] res= result.split("},");
        for (String s: res){
            s="{"+s+"}";
            System.out.println(s);
            JsonParser js = new JsonParser();
            JsonObject jo= (JsonObject) js.parse(s);
            System.out.println(jo);
        }
        System.out.println(address);
        System.out.println(date);
        
        return "index";
    }

    
    

}
