package com.chucknorris.challenge.model.repository;

import com.chucknorris.challenge.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

}
