package com.rw.repository;


import com.rw.models.Buyer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BuyerJPA extends JpaRepository<Buyer, Integer> {
    Buyer getBuyerById(Integer id);
}
