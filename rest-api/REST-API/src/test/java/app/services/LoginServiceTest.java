/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.services;

import app.model.Seller;
import app.model.User;
import app.repository.UserRepository;
import app.util.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
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
public class LoginServiceTest {
    
    @MockBean
    private UserRepository userRepository;
    
    @Autowired
    private LoginService loginService;
    
    /**
     * Test of authenticate method, of class LoginService.
     */
    @Test
    public void testAuthenticate() {
        User u1 = new Seller("legumes","arroz","João Manel","sou@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.seller.toString());
        Mockito.when(userRepository.findByUsername("legumes")).thenReturn(u1);
        
        //Password and username confirmed
        User result = loginService.authenticate("legumes", "arroz");
        assertEquals(u1, result);
        
        //User exist and password is not the correct one
        result = loginService.authenticate("legumes", "something else");
        assertNotEquals(u1, result);
        
        //User does not exist
        result = loginService.authenticate("not around", "arroz");
        assertNull(result);
        
        
    }

    /**
     * Test of register method, of class LoginService.
     */
    @Test
    public void testRegister() {
        User u1 = new Seller("anotherone","arroz","João Manel","anotherone@hotmail.com",555533333,"Lugar de cambres","5122",94,Type.seller.toString());
        Mockito.when(userRepository.save(u1)).thenReturn(u1);
        
        //should work first time
        boolean result = loginService.register(u1);
        assertEquals(true, result);
        
        //should not work because it's already created
    }
    
}
