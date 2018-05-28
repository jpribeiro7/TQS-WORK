/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;

import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.JsonValue;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author carlossoares
 */
@SessionScoped
@ManagedBean(name = "products")
public class ProductsBean  {

    private int maxValue;
    private int minValue;
    private String categoria;
    private String searchText;
    private ArrayList<String> categorias;
    private ArrayList<Product> productList;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public ProductsBean() {
        this.categoria = "Todos";
        allCategories();
        allProducts();
        this.searchText = "";
        this.minValue= minValue();
        this.maxValue = maxValue();
    }

    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public void setMaxValue(int maxValue) {
        this.maxValue = maxValue;
    }

    public void setMinValue(int minValue) {
        this.minValue = minValue;
    }

    
    
    public String getCategoria() {
        return this.categoria;
    }

    public List<String> getCategorias() {
        return this.categorias;
    }

    public void setCategorias(List<String> lista) {
        this.categorias = (ArrayList<String>) lista;
    }

    public String getSearchText() {
        return searchText;
    }

    public void setSearchText(String searchText) {
        this.searchText = searchText;
    }

    public int maxValue() {
        int maxValue_temp = 0;
        for (Product p : productList) {
            if (p.getPrice() > maxValue_temp) {
                maxValue_temp = (int) p.getPrice();
            }
        }
        return maxValue_temp;

    }
    public int minValue() {
        int maxValue_temp = 0;
       
        return maxValue_temp;

    }

    public void byName() {
        if(this.searchText.isEmpty()){
            byCategory();
        }
        System.out.println("bYName");
        List<Product> results = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(this.searchText) ) {
                results.add(p);
            }
        }
        setProductList((ArrayList<Product>) results);
    }

    public void allCategories() {
        String targetUrl = "http://localhost:8090/product/categories";

        Client client = ClientBuilder.newClient();
        List<String> results = new ArrayList<>();

        System.out.println("Categories");
        Response response = client.target(targetUrl).request(MediaType.APPLICATION_JSON).get();
        JsonArray arr = response.readEntity(JsonArray.class);
        System.out.println(arr);
        for (JsonValue j : arr) {
            String s = j.toString();
            String[] res = s.split("\"");

            results.add(res[1]);
        }
        results.add("Todos");
        setCategorias(results);

    }

    public void allProducts() {
        String targetUrl = "http://localhost:8090/product/all";
        Client client = ClientBuilder.newClient();
        List<Product> results = new ArrayList<>();
        Response response = client.target(targetUrl).request(MediaType.APPLICATION_JSON).get();
        JsonArray arr = response.readEntity(JsonArray.class);
        for (JsonValue j : arr) {
            JsonObject jo = (JsonObject) j;
            String name = jo.getString("name");
            String category = jo.getString("category");
            String description = jo.getString("description");
            int id = jo.getInt("id");
            BigDecimal b = new BigDecimal(jo.getInt("price"));
            float price = b.floatValue();
            Product p = new Product(id, name, category, price, description);
            results.add(p);
        }
        response.close();
        client.close();
        productList = (ArrayList<Product>) results;

    }

    public void categoryChanged(ValueChangeEvent e) {
        //assign new value to localeCode
        categoria = e.getNewValue().toString();
        System.out.println(categoria);
        byCategory();

    }

    public void byCategory() {
        if ("Todos".equals(getCategoria())) {
            allProducts();
        } else if (!"Todos".equals(getCategoria())) {
            String targetUrl = "http://localhost:8090/product/byCategory?category=" + getCategoria();
            Client client = ClientBuilder.newClient();
            List<Product> results = new ArrayList<>();
            Response response = client.target(targetUrl).request(MediaType.APPLICATION_JSON).get();
            JsonArray arr = response.readEntity(JsonArray.class);
            System.out.println("teste");
            for (JsonValue j : arr) {
                JsonObject jo = (JsonObject) j;
                System.out.println(jo);
                String name = jo.getString("name");
                String category = jo.getString("category");
                String description = jo.getString("description");
                int id = jo.getInt("id");
                BigDecimal b = new BigDecimal(jo.getInt("price"));
                float price = b.floatValue();
                Product p = new Product(id, name, category, price, description);
                results.add(p);
            }
            response.close();
            client.close();
            System.out.println(results);
            setProductList((ArrayList<Product>) results);
        }
    }

    public List<Product> getProductList() throws IOException {

        return productList;

    }

}
