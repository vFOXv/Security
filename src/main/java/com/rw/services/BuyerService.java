package com.rw.services;

import com.rw.models.Buyer;
import com.rw.repository.BuyerJPA;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class BuyerService {
    private final BuyerJPA buyerJPA;

    public BuyerService(BuyerJPA buyerJPA) {
        this.buyerJPA = buyerJPA;
    }

    //получение всех покупателей
    public List<Buyer> getAllBuyers() {
        return buyerJPA.findAll();
    }

    //получение buyer по id
    public Buyer getBuyerId(Integer id){
        return buyerJPA.getBuyerById(id);
    }
}
