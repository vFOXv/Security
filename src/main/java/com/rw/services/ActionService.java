package com.rw.services;

import com.rw.models.Book;
import com.rw.models.Buyer;
import com.rw.repository.BuyerJPA;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ActionService {
    public final BuyerService buyerService;
    public final BuyerJPA buyerJPA;

    public ActionService(BuyerService buyerService, BuyerJPA buyerJPA) {
        this.buyerService = buyerService;
        this.buyerJPA = buyerJPA;
    }

    public void deleteBookBuyer(Integer book_id, Integer buyer_id){
        //Book book = bookService.getBookId(book_id);
        Buyer buyer = buyerService.getBuyerId(buyer_id);
        List<Book> books = (List<Book>) buyer.getBooks();
        //List<Buyer> buyers= (List<Buyer>) book.getBuyers();
        books.remove(book_id);
        //buyers.remove(buyer_id);
        //bookJPA.save(book);
        buyerJPA.save(buyer);
    }
}
