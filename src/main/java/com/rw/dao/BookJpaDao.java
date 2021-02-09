package com.rw.dao;

import com.rw.models.Book;
import com.rw.models.Buyer;
import com.rw.repository.BookJPA;
import com.rw.repository.BuyerJPA;
import com.rw.services.BookService;
import com.rw.services.BuyerService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BookJpaDao {
//    public final BookService bookService;
//    public final BuyerService buyerService;
//    private final BookJPA bookJPA;
//    private final BuyerJPA buyerJPA;
//
//    public BookJpaDao(BookService bookService, BuyerService buyerService, BookJPA bookJPA, BuyerJPA buyerJPA) {
//        this.bookService = bookService;
//        this.buyerService = buyerService;
//        this.bookJPA = bookJPA;
//        this.buyerJPA = buyerJPA;
//    }
//
//    public void deleteBookBuyer(Integer book_id, Integer buyer_id){
//        Book book = bookService.getBookId(book_id);
//        Buyer buyer = buyerService.getBuyerId(buyer_id);
//        List<Book> books = (List<Book>) buyer.getBooks();
//        List<Buyer> buyers= (List<Buyer>) book.getBuyers();
//        books.remove(book_id);
//        buyers.remove(buyer_id);
//        bookJPA.save(book);
//        buyerJPA.save(buyer);
//    }
}
