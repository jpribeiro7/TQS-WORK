/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

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
@ManagedBean(name = "cart")
public class CartBean {

    private final List<Product> cartList = new ArrayList<>();
    private String emptyCart;
    private float total;

    public CartBean() {
        this.emptyCart = "Não tem items no seu carro";
        this.total = 0;

    }

    public float getTotal() {
        
        float total_temp=0;
        for(Product p:cartList){
            total_temp+=p.getSubTotal();
        }
        return total_temp;
    }

    public String getEmptyCart() {
        return emptyCart;
    }

    public List<Product> getCartList() {
        return cartList;

    }

    public void setEmptyCart(String emptyCart) {
        this.emptyCart = emptyCart;
    }

    public String remove() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        String name = params.get("name");
        Float price = Float.parseFloat(params.get("price"));
        System.out.println(params);
        System.out.println("entrei");

        for (Product p : cartList) {
            if (p.getName().equals(name)) {
                if(p.getQuantity()>1){
                    p.setQuantity(p.getQuantity()-1);
                }
                else{
                    cartList.remove(p);
                }
                
                
                System.out.println("apaguei");
                return "cart";
            }
        }
        if (cartList.isEmpty()) {
            setEmptyCart("Não tem items no seu carro");
            return "cart";
        }

        return "cart";
    }
    public String detailsAddToCart() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        String name = params.get("name");
        Float price = Float.parseFloat(params.get("price"));
        int id = Integer.parseInt(params.get("id"));
        String category=params.get("category");
        String description=params.get("description");
        int quantity=Integer.parseInt(params.get("quantity"));

        System.out.println(params);
        setEmptyCart("");

        Product p = new Product(id, name, category, quantity, price, description);
        if (cartList.isEmpty()) {
            cartList.add(p);
        } else {
            for (Product pro : cartList) {
                if (pro.getId() == p.getId()) {
                    int quantidade = pro.getQuantity();
                    pro.setQuantity(quantidade + quantity);
                    
                    return "index";
                } else {
                    cartList.add(p);
                    total += p.getSubTotal();
                    return "index";
                }
            }
        }

        return "index" ;

        
    }

    public String addToCart() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();
        String name = params.get("name");
        Float price = Float.parseFloat(params.get("price"));
        int id = Integer.parseInt(params.get("id"));
        String category=params.get("category");
        String description=params.get("description");

        System.out.println(params);
        setEmptyCart("");

        Product p = new Product(id, name, category, 1, price, description);
        if (cartList.isEmpty()) {
            cartList.add(p);
        } else {
            for (Product pro : cartList) {
                if (pro.getId() == p.getId()) {
                    int quantidade = pro.getQuantity();
                    pro.setQuantity(quantidade + 1);
                    
                    return "index";
                } else {
                    cartList.add(p);
                    total += p.getSubTotal();
                    return "index";
                }
            }
        }

        return "index" ;

        
    }

}
