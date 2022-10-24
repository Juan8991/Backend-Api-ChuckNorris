package com.chucknorris.challenge.model.repository;

import com.chucknorris.challenge.model.domain.MyJokes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MyJokesRepository extends JpaRepository<MyJokes,Long> {

}
