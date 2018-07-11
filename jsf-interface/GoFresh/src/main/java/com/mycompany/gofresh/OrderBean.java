/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

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
@ManagedBean(name = "order")
public class OrderBean {

    private final List<Order> list = new ArrayList<>();
    private String address;
    private List<Order> listClient = new ArrayList<>();

    private String date;

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

    public OrderBean() {
        setup();
        getListByClient();

    }

    private void setup() {
        Product p10 = new Product(2, "batata", "leguminosa", 2, (float) 0.5, "fritas são boas", "sado");
        Product p11 = new Product(1, "couve", "legume", 1, (float) 1.2, "cultivado no sul", "sado");
        Product p12 = new Product(3, "tomate", "fruta", 3, (float) 0.8, "fresco", "alberto");
        Product p20 = new Product(2, "batata", "leguminosa", 1, (float) 0.5, "fritas são boas", "sado");
        Product p21 = new Product(4, "beringela", "legume", 5, (float) 0.7, "saber intenso", "alberto");

        ArrayList<Product> l1 = new ArrayList<>();
        l1.add(p10);
        l1.add(p11);
        l1.add(p12);

        ArrayList<Product> l2 = new ArrayList<>();
        l2.add(p20);
        l2.add(p21);

        ArrayList<Product> l3 = new ArrayList<>();
        l3.add(p20);
        l3.add(p21);

        Order o1 = new Order("Rua da Oliveira nº1", 0, "veggie", l1, "03-08-2018", "Por entregar", (float) 3.22);
        Order o2 = new Order("Rua da Oliveira nº1", 1, "veggie", l2, "22-12-2017", "Entregue", (float) 2.56);

        Order o3 = new Order("Rua da Presa nº63", 1, "legumes", l2, "13-11-2017", "Entregue", (float) 2.56);

        list.add(o1);
        list.add(o2);
        list.add(o3);
    }

    public List<Order> getList() {
        return list;
    }

    public List<Order> getListClient() {
        return listClient;
    }

    public void setListClient(List<Order> listClient) {
        this.listClient = listClient;
    }

    public void getListByClient() {

        for (Order o : list) {
            if (o.getClient().equals("veggie") && !listClient.contains(o)) {
                listClient.add(o);
            }
            System.out.println(o.getClient());
        }
    }

    public String finish() {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();

        String listS = params.get("list");
        String username = params.get("client");
        Float total = Float.parseFloat(params.get("total"));

        String result = listS.substring(1, listS.length() - 1);
        result += ",";

        ArrayList<Product> l = new ArrayList<>();
        String[] res = result.split("},");
        for (String s : res) {

            s = "{" + s + "}";
            //System.out.println(s);
            JsonParser js = new JsonParser();
            JsonObject jo = (JsonObject) js.parse(s);
            System.out.println(jo);
            Product p = new Product(Integer.parseInt(jo.get("id").toString()), jo.get("name").toString(), jo.get("category").toString(), Integer.parseInt(jo.get("quantity").toString()), Float.parseFloat(jo.get("price").toString()), jo.get("description").toString(), "");
            l.add(p);
        }

        Order o = new Order(address, 123, username, l, date, "Por entregar", total);

        System.out.println(address);
        System.out.println(date);
        System.out.println(o);
        list.add(o);
        System.out.println(list);
        getListByClient();

        return "index";
    }

}
