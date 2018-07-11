/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;

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
public class ProductsBean {

    private int maxValue;
    private int minValue;
    private String categoria;

    private String searchText;
    private String sellerText;
    private ArrayList<String> categorias;
    private ArrayList<Product> productList;

    // Add business logic below. (Right-click in editor and choose
    // "Insert Code > Add Business Method")
    public ProductsBean() {
        this.categoria = "Todos";
        allCategories();
        allProducts();
        this.searchText = "";
        this.minValue = minValue();
        this.maxValue = maxValue();
        this.sellerText="";
    }

    public String getSellerText() {
        return sellerText;
    }

    public void setSellerText(String sellerText) {
        this.sellerText = sellerText;
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

    public void ascendingOrder() {
        Collections.sort(productList, new ProductComparator());

    }

    public void descendingOrder() {
        Collections.sort(productList, new ProductComparator());
        Collections.reverse(productList);
    }

    public void byName() {
        if (this.searchText.isEmpty()) {
            byCategory();
        }
        System.out.println("bYName");
        List<Product> results = new ArrayList<>();
        for (Product p : productList) {
            if (p.getName().contains(this.searchText)) {
                results.add(p);
            }
        }
        setProductList((ArrayList<Product>) results);
    }

    public void bySeller() {
        if (this.sellerText.isEmpty()) {
            byCategory();
        }
        System.out.println("bYSeller");
        System.out.println(sellerText);
        List<Product> results = new ArrayList<>();
        for (Product p : productList) {
            if (p.getSeller().contains(this.sellerText)) {
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
        String targetUrl = "http://localhost:8090/sellerProduct/all";
        Client client = ClientBuilder.newClient();
        List<Product> results = new ArrayList<>();
        Response response = client.target(targetUrl).request(MediaType.APPLICATION_JSON).get();
        JsonArray arr = response.readEntity(JsonArray.class);
        System.out.println(arr);
        for (JsonValue j : arr) {
            JsonObject jo = (JsonObject) j;
            JsonObject product = (JsonObject) jo.get("product");
            String name=product.getString("name");
            String category=product.getString("category");
            String description=product.getString("description");
            
            int id = product.getInt("id");
            
            BigDecimal b = new BigDecimal(Float.parseFloat(jo.get("price").toString()));
            float price = b.floatValue();
            JsonObject seller = (JsonObject) jo.get("seller");
            String sellerName=seller.getString("username");
            
            
            Product p = new Product(id, name, category, 1, price, description,sellerName);
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
            
            List<Product> results = new ArrayList<>();
            
            System.out.println("teste");
            
            for (Product p: productList){
                if(p.getCategory().contains(categoria)){
                    results.add(p);
                }
            }
           
            System.out.println(results);
            setProductList((ArrayList<Product>) results);
        }
    }

    public List<Product> getProductList() throws IOException {

        return productList;

    }

}
