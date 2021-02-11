package com.rw.services;

import com.rw.models.Book;
import com.rw.repository.BookJPA;
import com.rw.repository.BuyerJPA;
import com.rw.repository.OwnerJPA;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class BookService {
    private final BookJPA bookJPA;

    public BookService(BookJPA bookJPA) {
        this.bookJPA = bookJPA;
    }

    //получение книги по id

    //getOne(id) не работает
//    public Book getBookId(int id) {
//        return bookJPA.getOne(id);
//    }
    //поэтому делаем свой метод getBookById(id);
    public Book getBookId(Integer id) {
        return bookJPA.getBookById(id);
    }
    //получение всех данных с таблицы
    public List<Book> getAllBooks(){
        return bookJPA.findAll();
    }

    //запись новой книги
    public void addNewBook(Book book){
        bookJPA.save(book);
    }

    //изменение данных в объекте
    public void updateBook(Book newBook){
        bookJPA.save(newBook);
    }

    //удаление объекта
    public void remove(int id){
        Book book = bookJPA.getOne(id);
        bookJPA.delete(book);
    }
}
