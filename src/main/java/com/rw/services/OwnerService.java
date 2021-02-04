package com.rw.services;


import com.rw.models.Owner;
import com.rw.repository.OwnerJPA;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerService {
    private final OwnerJPA ownerJPA;

    public OwnerService(OwnerJPA ownerJPA) {
        this.ownerJPA = ownerJPA;
    }

    //получение всех книг
    public List<Owner> getAllOwners(){
        return ownerJPA.findAll();
    }

    //получение owner по id
    public Owner getOwnerId(Integer id) {
        return ownerJPA.getOwnerById(id);
    }
}
