/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author carlos
 */

@Entity
public class DateSet implements Serializable {
    
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name = "DATE_ID")
    private Integer id;
    
    private int day;
    private int month;
    private int year;
    
    @OneToMany(mappedBy="date" ,cascade=CascadeType.ALL)
    @JsonBackReference
    private List<Ordering> orderList = new ArrayList<>();

    public DateSet() {
    }
    
    public DateSet(int day, int month, int year){
        this.day = day;
        this.month = month;
        this.year = year;
    }

    public int getDay() {
        return day;
    }

    public int getMonth() {
        return month;
    }

    public int getYear() {
        return year;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public List<Ordering> getOrderList() {
        return orderList;
    }

    public void setOrderList(List<Ordering> orderList) {
        this.orderList = orderList;
    }
    
    
}
