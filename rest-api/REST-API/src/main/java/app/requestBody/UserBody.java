/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.requestBody;

/**
 *
 * @author Pedro
 */
public class UserBody {
    private String username;
    private String password;
    private String name;
    private String email;
    private Integer nif;
    private String address;
    private String codigo_postal;
    private Integer phone_number;
    private String type;

    public UserBody(String username, String password, String name, String email, Integer nif, String address, String codigo_postal, Integer phone_number, String type) {
        this.username = username;
        this.password = password;
        this.name = name;
        this.email = email;
        this.nif = nif;
        this.address = address;
        this.codigo_postal = codigo_postal;
        this.phone_number = phone_number;
        this.type = type;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getNif() {
        return nif;
    }

    public void setNif(Integer nif) {
        this.nif = nif;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCodigo_postal() {
        return codigo_postal;
    }

    public void setCodigo_postal(String codigo_postal) {
        this.codigo_postal = codigo_postal;
    }

    public Integer getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(Integer phone_number) {
        this.phone_number = phone_number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
    
    
}
