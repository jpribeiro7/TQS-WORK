/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.model.User;
import app.repository.UserRepository;
import app.util.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Pedro
 */

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
    
    @MockBean
    private UserRepository userRepository;
    
    @Autowired
    private UserService userService;
    
    /**
     * Test of getAllUsers method, of class UserService.
      */

    @Test
    public void testGetAllUsers() {
        List<User> list = new ArrayList<>();
        list.add(new User("legumes","arroz","João Manel","sou@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.seller.toString()));
                            
        Mockito.when(userRepository.findAll()).thenReturn(list);
        List<User> list_service = userService.getAllUsers();
        
        Assert.assertEquals(list_service,list);
    }


    /**
     * Test of getAllClients method, of class UserService.
      */

    @Test
    public void testGetAllClients() {
        List<User> list = new ArrayList<>();
        list.add(new User("itzme","arroz","Mário","sou@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.client.toString()));
        Mockito.when(userRepository.findByType(Type.client.toString())).thenReturn(list);
        List<User> list_service = userService.getAllClients();
        
        Assert.assertEquals(list_service,list);
    }

    /**
     * Test of getAllSellers method, of class UserService.
     */

    @Test
    public void testGetAllSellers() {
        List<User> list = new ArrayList<>();
        list.add(new User("manelzinho","arroz","João Manel","sou@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.seller.toString()));
        Mockito.when(userRepository.findByType(Type.seller.toString())).thenReturn(list);
        List<User> list_service = userService.getAllSellers();
        
        Assert.assertEquals(list_service,list);
    }
    
}
