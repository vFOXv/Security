package com.rw.repository;

import com.rw.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookJPA extends JpaRepository<Book,Integer> {
}
