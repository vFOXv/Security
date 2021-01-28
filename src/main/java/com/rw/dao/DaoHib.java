package com.rw.dao;

import com.rw.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class DaoHib {

    private final SessionFactory sessionFactory;

    public DaoHib(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    public Session mySession() {
        return sessionFactory.openSession();
    }





    public Book getBookId(int id) {
        Session session = mySession().getSession();
        Book book = session.get(Book.class, id);
        System.out.println(book);
        return book;
    }



    //получение всех данных с таблицы
    public List<Book> getAllBooks() {
        Session session = mySession().getSession();
        List<Book> allBooks = session.createQuery("SELECT b FROM Book  b", Book.class).getResultList();
        System.out.println(allBooks);
        return allBooks;
    }

    //запись новой книги
    public void addNewBook(Book book) {
        Session session = mySession().getSession();
        session.save(book);
    }

    //изменение данных в объекте
    public void updateBook(Book book) {
        Session session = mySession().getSession();
        session.update(book);
    }

    //удаление объекта
    public void remove(int id) {
        Session session = mySession().getSession();
        Book book = session.get(Book.class, id);
        session.delete(book);
    }
}

