/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package app.controllers;

import app.model.LoginBody;
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
    
    @RequestMapping(value="/login",method = GET)
    public ResponseEntity<?> login(@RequestParam(value="username",required=false)String username,@RequestParam(value="password",required=false) String password){
        ResponseEntity<String> response;
        if(  username==null || password == null || username.isEmpty() || password.isEmpty()){
            response = new ResponseEntity<>("Please send all the information required",HttpStatus.BAD_REQUEST);
        }else{
            boolean flag = loginService.authenticate(username, password);
            response = new ResponseEntity<>(flag+"",HttpStatus.OK);
        }
        return response;
    }
}
