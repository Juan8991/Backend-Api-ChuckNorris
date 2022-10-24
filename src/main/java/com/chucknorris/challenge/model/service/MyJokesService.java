package com.chucknorris.challenge.model.service;

import com.chucknorris.challenge.model.domain.MyJokes;
import com.chucknorris.challenge.model.repository.MyJokesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MyJokesService {


    private final MyJokesRepository myJokesRepository;
    @Autowired
    public MyJokesService( MyJokesRepository myJokesRepository) {
        this.myJokesRepository = myJokesRepository;
    }
    public List<MyJokes> getAll(){
        return myJokesRepository.findAll();
    }

    @Transactional
    public MyJokes saveJoke(MyJokes myJokes){
        return myJokesRepository.save(myJokes);
    }

}
