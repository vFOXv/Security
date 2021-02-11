package com.rw.services;

import com.rw.models.Book;
import com.rw.models.Buyer;
import com.rw.repository.BookJPA;
import com.rw.repository.BuyerJPA;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class BuyerService {
    private final BuyerJPA buyerJPA;
    private final BookJPA bookJPA;
    private final BookService bookService;

    public BuyerService(BuyerJPA buyerJPA, BookJPA bookJPA, BookService bookService) {
        this.buyerJPA = buyerJPA;
        this.bookJPA = bookJPA;
        this.bookService = bookService;
    }

    //получение всех покупателей
    public List<Buyer> getAllBuyers() {
        return buyerJPA.findAll();
    }

    //получение buyer по id
    public Buyer getBuyerId(Integer id){
        return buyerJPA.getBuyerById(id);
    }

    public void deleteBookBuyer(Integer book_id, Integer buyer_id){
//        Book book = bookService.getBookId(book_id);
//        Buyer buyer = getBuyerId(buyer_id);
//        Set<Book> books = buyer.getBooks();
//        System.out.println("=======================================");
//        System.out.println(books);
//        //List<Buyer> buyers= (List<Buyer>) book.getBuyers();
//        books.remove(book);
//        System.out.println(books);
//        //buyers.remove(buyer_id);
//        //bookJPA.save(book);
//        buyerJPA.save(buyer);

        Book book = bookService.getBookId(book_id);
        Buyer buyer = getBuyerId(buyer_id);
        Set<Buyer>buyers= book.getBuyers();
        System.out.println("=======================================");
        System.out.println(buyers);
        buyers.remove(buyer);
        System.out.println("+++++++++++++++++++++++++++++++++++++++");
        System.out.println(buyers);
        bookJPA.save(book);
    }
}
