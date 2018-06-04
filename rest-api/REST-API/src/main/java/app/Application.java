/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.model.Product;
import java.util.Arrays;
import app.model.User;
import app.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.repository.UserRepository;
import app.util.Type;

/**
 *
 * @author Pedro
 */
@SpringBootApplication()
public class Application implements CommandLineRunner {
    public static void main(String[] args){
        SpringApplication.run(Application.class, args);
    }

    @Autowired
    private UserRepository userRepository;
    
    @Autowired 
    private ProductRepository productRepository;
    
    @Override
    public void run(String... args) throws Exception {
        // --------------------------------------------------------------- USERS ------------------------------------------------------
        User u1 = new User("veggie","arroz","Alberto Coelho","habemusvegie@hotmail.com",222222222,"Lugar de cambres","5122",94,Type.client.toString());
        User u2 = new User("legumes","arroz","João Manel","sou@hotmail.com",233333333,"Lugar de cambres","5122",94,Type.seller.toString());
        User u3 = new User("sado","arroz","Carlos","aquid@hotmail.com",224444444,"Lugar de cambres","5122",94,Type.client.toString());
        User u4 = new User("marials","arroz","Arinto","naosei@hotmail.com",227777777,"Lugar de cambres","5122",94,Type.seller.toString());
        User u5 = new User("queremos","arroz","Salome","fazer@hotmail.com",299999999,"Lugar de cambres","5122",94,Type.client.toString());
        User u6 = new User("couves","arroz","Quim","isto@hotmail.com",222222496,"Lugar de cambres","5122",94,Type.seller.toString());
        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6));
        
        
        //--------------------------------------------------------------- PRODUCTS ----------------------------------------------------
        Product p1 = new Product("couve","legume","cultivado no sul");
        Product p2 = new Product("alface","legume","é verde");
        Product p3 = new Product("beringela","legume","é grande");
        Product p4 = new Product("tomate","fruta","fresco e apanhado");
        Product p5 = new Product("cenoura","legume","deixa os olhos bonitos");
        Product p6 = new Product("batata","leguminosa","fritas são boas");
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p4,p5,p6));
        
    }
}
