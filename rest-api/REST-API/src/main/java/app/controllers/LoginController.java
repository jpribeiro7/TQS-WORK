/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;


import app.model.User;
import app.requestBody.LoginBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import app.services.LoginService;

/**
 *
 * @author Pedro
 */
@RestController()
public class LoginController {
    
    @Autowired
    private LoginService loginService;
    
    @RequestMapping(value="/login",method = POST)
    public ResponseEntity<?> login(@RequestBody LoginBody login){
        ResponseEntity<?> response;
        if(  login.getUsername().isEmpty() || login.getPassword().isEmpty()){
            response = new ResponseEntity<>("Please send all the information required",HttpStatus.BAD_REQUEST);
        }else{
            User flag = loginService.authenticate(login.getUsername(),login.getPassword());
            response = flag == null ? 
                    new ResponseEntity<>("No user in the system",HttpStatus.OK) 
                    : new ResponseEntity<>(flag,HttpStatus.OK);
        }
        return response;
    }
    
    @RequestMapping(value="/register", method = POST)
    public ResponseEntity<?> register(@RequestBody User data){
        ResponseEntity<?> response = null;
        response = new ResponseEntity<>(loginService.register(data),HttpStatus.OK);
        return response;
    }
}
