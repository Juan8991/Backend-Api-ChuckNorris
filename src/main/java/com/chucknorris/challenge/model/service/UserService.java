package com.chucknorris.challenge.model.service;

import com.chucknorris.challenge.model.domain.User;
import com.chucknorris.challenge.model.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder encoder;
    @Autowired
    public UserService(UserRepository userRepository, BCryptPasswordEncoder encoder) {
        this.userRepository = userRepository;
        this.encoder = encoder;
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }
    public Optional<User> getByEmail(String email){
        return userRepository.findByEmail(email);
    }
    public List<User> getAll(){
        return userRepository.findAll();
    }

    public Long checkUserAndPassword(String email, String Password) throws RuntimeException {
        Optional<User> userToCheck = userRepository.findByEmail(email);
        if(userToCheck.isPresent()){
            if(encoder.matches(Password,userToCheck.get().getPassword())){
                return userToCheck.get().getUserId();
            }else{
                return 555L;
            }
        }
        return 404L;
    }

}
