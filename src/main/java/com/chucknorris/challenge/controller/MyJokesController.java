package com.chucknorris.challenge.controller;

import com.chucknorris.challenge.model.domain.MyJokes;
import com.chucknorris.challenge.model.service.MyJokesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(path = "/jokes")
@RestController
public class MyJokesController {

    private final MyJokesService myJokesService;
    private final  RestTemplate restTemplate;

    @Autowired
    public MyJokesController(MyJokesService myJokesService, RestTemplate restTemplate) {
        this.myJokesService = myJokesService;
        this.restTemplate = restTemplate;
    }

    @GetMapping(path = "/all")
    public List<MyJokes> getAll(){
        return myJokesService.getAll();
    }

    @PostMapping(path = "/add")
    public ResponseEntity<MyJokes> addJoke(@RequestBody MyJokes myJoke){
        MyJokes joke=myJokesService.saveJoke(myJoke);
        if(joke!=null){
            return new ResponseEntity<>(joke, HttpStatus.CREATED);
        }
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);
    }

    @GetMapping(path = "/random")
    public Object getJokeFromApi(){
        String endPoint="https://api.chucknorris.io/jokes/random";
        return restTemplate.getForObject(endPoint,Object.class);
    }
}
