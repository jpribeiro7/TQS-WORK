/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.model.Client;
import app.model.Seller;
import app.model.User;
import app.requestBody.LoginBody;
import app.services.LoginService;
import app.services.UserService;
import app.util.Type;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import static org.springframework.http.converter.json.Jackson2ObjectMapperBuilder.json;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Pedro
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@Ignore public class LoginControllerTest {
    
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private LoginService loginService;

    /**
     * Test of login method, of class LoginController.
     */
    @Test
    public void testLogin() throws Exception {
       User u1 = new Seller("legumes","arroz","João Manel","sou@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.seller.toString());
       Mockito.when(loginService.authenticate("legumes", "arroz")).thenReturn(u1);
       
       
       //when user is registered
       ObjectMapper obj = new ObjectMapper();
       String json = obj.writeValueAsString(u1);
       this.mvc.perform(post("/login")
               .content("{\"username\": \"legumes\" "
                       + ",\"password\": \"arroz\"}")
               .contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(status().isOk()).andExpect(content().string(json));
       
       //when user is not registered
       u1 = null;
       Mockito.when(loginService.authenticate("legumes", "arroz")).thenReturn(u1);
       this.mvc.perform(post("/login")
               .content("{\"username\": \"legumes\" "
                       + ",\"password\": \"arroz\"}")
               .contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(status().isOk()).andExpect(content().string("No user in the system"));
       
       //data not complete
       this.mvc.perform(post("/login")
               .content("{\"username\": \"\" "
                       + ",\"password\": \"arroz\"}")
               .contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(status().isBadRequest()).andExpect(content().string("Please send all the information required"));
       
       
    }
    /**
     * Test of register method, of class LoginController.
     */
    @Test
    public void testRegister() throws Exception {
        String json = "{\n" +
                        "    \"username\": \"somee\",\n" +
                        "    \"password\": \"veggie\",\n" +
                        "    \"name\": \"Alberto Coelho\",\n" +
                        "    \"email\": \"someemusvegie@hotmail.com\",\n" +
                        "    \"nif\": 2233222222,\n" +
                        "    \"address\": \"Lugar de cambres\",\n" +
                        "    \"codigo_postal\": \"5122\",\n" +
                        "    \"phone_number\": 94,\n" +
                        "    \"type\": \"client\"\n" +
                        "}";
        
        ObjectMapper obj = new ObjectMapper();
        User u1 = obj.readValue(json, Client.class);
        
        //when register is accepted
        Mockito.when(loginService.register(u1)).thenReturn(true);
        this.mvc.perform(post("/register")
               .content(json)
               .contentType(MediaType.APPLICATION_JSON_UTF8))
               .andExpect(status().isOk()).andExpect(content().string("true"));
        
    }
    
}
