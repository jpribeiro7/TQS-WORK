/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.model.User;
import app.services.UserService;
import app.util.Type;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 *
 * @author Pedro
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class UserControllerTest {
    
    @Autowired
    private UserController userController;
     
    @Autowired
    private MockMvc mvc;
    
    @MockBean
    private UserService userService;
    
    
    /**
     * Test of getAllUsers method, of class UserController.
     */
    @Test
    public void testGetAllUsers() throws JsonProcessingException, Exception {
       List<User> list = new ArrayList<>();
       list.add(new User("legumes","arroz","João Manel","sou@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.seller.toString()));
       Mockito.when(userService.getAllUsers()).thenReturn(list);
       
       
       ObjectMapper obj = new ObjectMapper();
       String json = obj.writeValueAsString(list);
       this.mvc.perform(get("/user/all")).andExpect(status().isOk()).andExpect(content().string(json));
       
    }

    /**
     * Test of getAllClients method, of class UserController.
      */
    @Test
    public void testGetAllClients() throws Exception {
       List<User> list = new ArrayList<>();
       list.add(new User("once","arroz","Joãozito","soutalvez@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.client.toString()));
       list.add(new User("told me","arroz","Joãozinho","nuncafui@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.client.toString()));
       
       Mockito.when(userService.getAllClients()).thenReturn(list);
       
       ObjectMapper obj = new ObjectMapper();
       String json = obj.writeValueAsString(list);
       this.mvc.perform(get("/user/allClients")).andExpect(status().isOk()).andExpect(content().string(json));
    }

    /**
     * Test of getAllSellers method, of class UserController.
      */
    @Test
    public void testGetAllSellers() throws Exception {
        List<User> list = new ArrayList<>();
       list.add(new User("once","arroz","Joãozito","soutalvez@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.seller.toString()));
       list.add(new User("told me","arroz","Joãozinho","nuncafui@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.seller.toString()));
       
       Mockito.when(userService.getAllSellers()).thenReturn(list);
       
       ObjectMapper obj = new ObjectMapper();
       String json = obj.writeValueAsString(list);
       this.mvc.perform(get("/user/allSellers")).andExpect(status().isOk()).andExpect(content().string(json));
    }
   
}
