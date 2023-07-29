package com.theangietalks.loginauth.loginauth.services;

import com.theangietalks.loginauth.loginauth.entity.User;
import com.theangietalks.loginauth.loginauth.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> user = repository.findById(id);
        return user.orElseThrow(() -> new RuntimeException("User not found: " + id));
    }

    public Boolean findByUsernameAndPassword(String username, String password){
        User mainUser = new User();
        for(User user : findAll()){
            if(user.getUsername().equals(username) && user.getPassword().equals(password)){
                return true;
            }
        }
        return false;
    }

}
