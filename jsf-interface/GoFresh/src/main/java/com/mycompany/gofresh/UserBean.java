/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.util.EntityUtils;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import javax.faces.context.FacesContext;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.json.simple.parser.ParseException;

//import javax.faces.context.FacesContext;
/**
 *
 * @author carlossoares
 */
@ManagedBean(name = "user")
@SessionScoped
public class UserBean {

    private String name;
    private String username;
    private String password;
    private String wrongCredentials;
    private int id;
    private String email;
    private  String morada;
    private  String codigo_postal;
    private  String telefone;
    private  String nif;

    public UserBean() {
        this.name = "";
        this.email = "";
        this.morada = "";
        this.codigo_postal = "";
        this.telefone = "";
        this.nif = "";
        this.username = "";
        this.password = "";
        this.wrongCredentials = "";
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }
    

    public String getWrongCredentials() {
        return wrongCredentials;
    }

    public void setWrongCredentials(String wrongCredentials) {
        this.wrongCredentials = wrongCredentials;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String login() throws IOException, ParseException {
        FacesContext fc = FacesContext.getCurrentInstance();
        Map<String, String> params
                = fc.getExternalContext().getRequestParameterMap();

        username = params.get("username");
        String password = params.get("password");
        System.out.println(params);
        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8090/login");

        String json = "{\"username\":\""+username+"\",\"password\":\""+password+"\"}";
//        String json = "{\"username\":\"veggie\",\"password\":\"arroz\"}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        System.out.println(httpPost);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);

        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(result);
        if (username.equals("") || password.equals("")){
            setWrongCredentials("Username or password not valid!");
            return "signIn";
        }

        if (!result.equals("No user in the system")) {
            JSONParser parser = new JSONParser();
            JSONObject res = (JSONObject) parser.parse(result);
            
            client.close();
            setWrongCredentials("");
            this.name = (String) res.get("name");
            this.username=(String) res.get("username");
            this.email=(String) res.get("email");
            this.nif=(String) String.valueOf(res.get("nif"));
            this.morada=(String) res.get("address");
            this.codigo_postal=(String) res.get("codigo_postal");
            this.telefone=(String) String.valueOf(res.get("phone_number"));
            return "index";
        } else {
            setWrongCredentials("Username or password not valid!");
            return "signIn";
        }

        

    }

}
