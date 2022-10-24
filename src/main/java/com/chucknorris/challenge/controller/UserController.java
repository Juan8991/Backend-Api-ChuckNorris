package com.chucknorris.challenge.controller;

import com.chucknorris.challenge.model.domain.User;
import com.chucknorris.challenge.model.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(path = "/auth")
@RestController
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(path = "/all")
    public List<User> getAll(){
        return userService.getAll();
    }
    @GetMapping(path = "/email/{email}")
    public ResponseEntity<User> getByEmail(@PathVariable(name = "email")String email){
        var user=userService.getByEmail(email);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        };
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    }
    @GetMapping(path = "/{email}/{password}")
    public ResponseEntity<String> cheackCredential(@PathVariable(name = "email") String email,@PathVariable(name = "password") String password){
        if(userService.checkUserAndPassword(email,password)==200){
            return new ResponseEntity<>("Credenciales correctas", HttpStatus.OK);
        } else if (userService.checkUserAndPassword(email,password)==555) {
            return new ResponseEntity<>("Credenciales incorrectas",HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>("Usuario no encontrado",HttpStatus.NOT_FOUND);
    }

}
