/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.repository;

import app.model.Client;
import app.model.Seller;
import app.model.User;
import app.util.Type;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 *
 * @author Pedro
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@DataJpaTest
public class UserRepositoryTest {
    
    @Autowired
    private UserRepository userRepository;
    
    @Autowired
    private TestEntityManager entityManager;
    
    /**
     * Test of findByName method, of class UserRepository.
     */
    @Test
    public void testFindByName() {
        userRepository.deleteAll();
        User u1 = new Client("This is new user","arroz","New Name","newuser@hotmail.com",223332222,"Lugar de cambres","5122",94,Type.client.toString());
        User u2 = new Seller("This is new user number 2","arroz","João Manel","nextuser@hotmail.com",433333333,"Lugar de cambres","5122",94,Type.seller.toString());
        User u3 = new Seller("secondAlberto","arroz","New Name","aijesus@hotmail.com",222222225,"Lugar de cambres","5122",94,Type.seller.toString());
        entityManager.persist(u1);
        entityManager.persist(u2);
        entityManager.persist(u3);
        entityManager.flush();
        List<User> should_find = new ArrayList<>();
        should_find.add(u1);
        should_find.add(u3);
        
        List<User> found = userRepository.findByName("New Name");
        for(User u : found){
            System.out.println(u.getName());
        }
        
        assertEquals(should_find,found);
    }

    /**
     * Test of findByType method, of class UserRepository.
     */
    @Test
    public void testFindByType() {
        userRepository.deleteAll();
        User u1 = new Client("This is new user","arroz","Alberto Coelho","newuser@hotmail.com",223332222,"Lugar de cambres","5122",94,Type.client.toString());
        User u2 = new Seller("This is new user number 2","arroz","João Manel","nextuser@hotmail.com",433333333,"Lugar de cambres","5122",94,Type.seller.toString());
        User u3 = new Seller("secondAlberto","arroz","Alberto Coelho","aijesus@hotmail.com",222222225,"Lugar de cambres","5122",94,Type.seller.toString());
        entityManager.persist(u1);
        entityManager.persist(u2);
        entityManager.persist(u3);
        entityManager.flush();
        
        
        //---------------------------------------- Assert Clients ----------------------------------------
        List<User> should_find = new ArrayList<>();
        should_find.add(u1);
        
        List<User> found = userRepository.findByType(Type.client.toString());
        
        assertEquals(found, should_find);
        
        //---------------------------------------- Assert Sellers ----------------------------------------
        should_find = new ArrayList<>();
        should_find.add(u2);
        should_find.add(u3);
        found = userRepository.findByType(Type.seller.toString());
        
        assertEquals(found, should_find);
        
        entityManager.clear();
    }

    /**
     * Test of findByUsername method, of class UserRepository.
     */
    @Test
    public void testFindByUsername() {
        userRepository.deleteAll();
        User u1 = new Client("This is new user","arroz","Alberto Coelho","newuser@hotmail.com",223332222,"Lugar de cambres","5122",94,Type.client.toString());
        User u2 = new Seller("This is new user number 2","arroz","João Manel","nextuser@hotmail.com",433333333,"Lugar de cambres","5122",94,Type.seller.toString());
        User u3 = new Seller("secondAlberto","arroz","Alberto Coelho","aijesus@hotmail.com",222222225,"Lugar de cambres","5122",94,Type.seller.toString());
        entityManager.persist(u1);
        entityManager.persist(u2);
        entityManager.persist(u3);
        entityManager.flush();
        
        User found = userRepository.findByUsername("secondAlberto");
        
        assertEquals(found, u3);
        
    }

    
}
