package com.rw.services;

import com.rw.models.User;
import com.rw.repository.UserJPA;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserJPA userJPA;

    public UserService(UserJPA userJPA) {
        this.userJPA = userJPA;
    }

    public User getById(Integer id){
       return userJPA.getById(id);
    }

    public User getByUsername(String username){
        return userJPA.getByUsername(username);
    }
}
