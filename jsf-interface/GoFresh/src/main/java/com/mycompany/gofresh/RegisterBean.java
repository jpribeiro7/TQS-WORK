/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import com.google.gson.Gson;
import java.io.IOException;
import java.util.Map;
import javax.faces.application.FacesMessage;
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
import org.primefaces.context.RequestContext;

//import javax.faces.context.FacesContext;
/**
 *
 * @author carlossoares
 */
@ManagedBean(name = "register")
@SessionScoped
public class RegisterBean {

    private String name;
    private String username;
    private String password;
    private String email;
    private String morada;
    private String codigo_postal;
    private String telefone;
    private String nif;
    private String wrongCredentials;
    private String success;
    private String type;
    private  String errors;

    public RegisterBean() {
        this.name = "";
        this.email = "";
        this.morada = "";
        this.codigo_postal = "";
        this.telefone = "";
        this.nif = "";
        this.username = "";
        this.password = "";
        this.type = "";
        this.errors = "";
        this.success="";
    }

    public String getSuccess() {
        return success;
    }

    public void setSuccess(String success) {
        this.success = success;
    }

    public String getErrors() {
        return errors;
    }

    public void setErrors(String errors) {
        this.errors = errors;
    }
    
    
    

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public String register() throws IOException, ParseException {

        CloseableHttpClient client = HttpClients.createDefault();
        HttpPost httpPost = new HttpPost("http://localhost:8090/register");

        String json = "{\"username\":\"" + username + "\",\"password\":\"" + password + "\","
                + "\"name\":\"" + name + "\",\"email\":\"" + email + "\","
                + "\"nif\":\"" + Long.parseLong(nif) + "\",\"address\":\"" + morada + "\","
                + "\"codigo_postal\":\"" + codigo_postal + "\",\"phone_number\":\"" + Long.parseLong(telefone) + "\","
                + "\"type\":\"" + type
                + "\"}";
        StringEntity entity = new StringEntity(json);
        httpPost.setEntity(entity);
        System.out.println(httpPost);
        httpPost.setHeader("Accept", "application/json");
        httpPost.setHeader("Content-type", "application/json");

        CloseableHttpResponse response = client.execute(httpPost);

        String result = EntityUtils.toString(response.getEntity(), "UTF-8");
        System.out.println(result);
        if (result.equals("true")) {
            
            setWrongCredentials("");
            setSuccess("Registado com sucesso!");
            
            return "signIn";
        } else {
            setErrors("Ocorreu algum erro");
            return "register";
        }
        
    }

}
