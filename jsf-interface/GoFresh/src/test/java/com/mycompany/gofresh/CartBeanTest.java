/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.gofresh;

import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author carlossoares
 */
public class CartBeanTest {
    
    public CartBeanTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getTotal method, of class CartBean.
     */
    @Test
    public void testGetTotal() {
        System.out.println("getTotal");
        List<Product> lista= new ArrayList<>();
        
        float expResult=(float) 2.2;
        
        Product p1= new Product(2, "batata", "leguminosa", 2, (float) 0.5,"fritas são boas","sado");
        Product p2= new Product(1, "couve", "legume", 1, (float) 1.2,"cultivado no sul","sado");
        lista.add(p2);lista.add(p1);
        Float total = 0.0f;
        for (Product p: lista){
            total+=p.getSubTotal();
        }
        assertEquals(expResult, total,0.001);
        
        
        
        // TODO review the generated test code and remove the default call to fail.
        
    }

   
}
