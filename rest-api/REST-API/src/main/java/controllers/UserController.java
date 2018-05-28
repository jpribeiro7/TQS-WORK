/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;

import java.util.List;
import model.Product;
import model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import org.springframework.web.bind.annotation.RestController;
import services.ProdutoService;
import services.UserService;

/**
 *
 * @author salome
 */
@RestController()
@RequestMapping(value="/user")
public class UserController {
    
    @Autowired
    private UserService userService;
    
    @RequestMapping(value="/all",method = GET)
    public ResponseEntity<?> getAllUsers(){
        List<User> list = userService.getAllUsers();
        return list!=null ? 
                new ResponseEntity<List<User>>(list,HttpStatus.OK): 
                new ResponseEntity<String>("No products were found",HttpStatus.NOT_FOUND);
    }
    
}
