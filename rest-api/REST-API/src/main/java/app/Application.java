/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import app.model.Client;
import app.model.Product;
import app.model.Seller;
import app.model.Seller_Product;
import app.model.Seller_ProductPk;
import java.util.Arrays;
import app.model.User;
import app.repository.ProductRepository;
import app.repository.SellerProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.repository.UserRepository;
import app.util.Type;
import java.util.ArrayList;
import java.util.List;

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
    
    @Autowired 
    private SellerProductRepository sellerProductRepository;
    
    
    
    @Override
    public void run(String... args) throws Exception {
        // --------------------------------------------------------------- USERS ------------------------------------------------------
        final User u1 = new Seller("veggie","arroz","Alberto Coelho","habemusvegie@hotmail.com",222222222,"Lugar de cambres","5122",94,"seller");
        final User u2 = new Client("legumes","arroz","João Manel","sou@hotmail.com",233333333,"Lugar de cambres","5122",94,"client");
        final User u3 = new Seller("sado","arroz","Carlos","aquid@hotmail.com",224444444,"Lugar de cambres","5122",94,"seller");
        final User u4 = new Client("marials","arroz","Arinto","naosei@hotmail.com",227777777,"Lugar de cambres","5122",94,"client");
        final User u5 = new Seller("queremos","arroz","Salome","fazer@hotmail.com",299999999,"Lugar de cambres","5122",94,"seller");
        final User u6 = new Client("couves","arroz","Quim","isto@hotmail.com",222222496,"Lugar de cambres","5122",94,"client");
        userRepository.saveAll(Arrays.asList(u1,u2,u3,u4,u5,u6));
        
        
        //--------------------------------------------------------------- PRODUCTS ----------------------------------------------------
        final Product p1 = new Product("couve","legume","cultivado no sul");
        final Product p2 = new Product("alface","legume","é verde");
        final Product p3 = new Product("beringela","legume","é grande");
        final Product p4 = new Product("tomate","fruta","fresco e apanhado");
        final Product p5 = new Product("cenoura","legume","deixa os olhos bonitos");
        final Product p6 = new Product("batata","leguminosa","fritas são boas");
        productRepository.saveAll(Arrays.asList(p1,p2,p3,p5,p6));
        
        //----------------------------------------------------------------- SELLER_PRODUCT ----------------------------------------------------
        final Seller_Product sp1 = new Seller_Product(2, 10,(Seller) u1, p6);
        final Seller_Product sp2 = new Seller_Product(1, 4,(Seller) u1, p1);
        final Seller_Product sp3 = new Seller_Product(0.5, 2,(Seller) u1, p5);
        final Seller_Product sp4 = new Seller_Product(1, 4,(Seller) u3, p2);
        final Seller_Product sp5 = new Seller_Product(0.5, 2,(Seller) u3, p3);
        sellerProductRepository.saveAll(Arrays.asList(sp1,sp2,sp3,sp4,sp5));
        
    }
}
