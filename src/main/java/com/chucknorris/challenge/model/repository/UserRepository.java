package com.chucknorris.challenge.model.repository;

import com.chucknorris.challenge.model.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User,Long> {
    /**
     * QueryMethod para buscar un usruario por su email
     * @param email
     * @return
     */
    Optional<User> findByEmail(String email);

}
