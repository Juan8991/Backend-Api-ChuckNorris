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
    @GetMapping(path = "/id/{id}")
    public ResponseEntity<User> getById(@PathVariable(name = "id")Long id){
        var user=userService.getUserById(id);
        if(user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        };
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
    @GetMapping(path = "/{email}/{password}")
    public ResponseEntity<Long> cheackCredential(@PathVariable(name = "email") String email,@PathVariable(name = "password") String password){
        if(userService.checkUserAndPassword(email,password)==404L){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else if (userService.checkUserAndPassword(email,password)==555L) {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        return new ResponseEntity<>(userService.checkUserAndPassword(email,password), HttpStatus.OK);
    }

}
