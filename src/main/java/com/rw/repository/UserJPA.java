package com.rw.repository;

import com.rw.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJPA extends JpaRepository<User, Integer> {
    public User getById(Integer id);
    public User getByUsername(String user);
}
