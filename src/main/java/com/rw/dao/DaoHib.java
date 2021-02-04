package com.rw.dao;

import com.rw.models.Book;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class DaoHib {
    private final SessionFactory sessionFactory;
@Autowired
    public DaoHib(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }


    public Session mySession() {
        return sessionFactory.openSession();
    }

    //получение по id
    public Book getBookId(int id) {
        Session session = mySession();
        Transaction transaction = session.beginTransaction();
        Book book = session.get(Book.class, id);
        System.out.println(book);
        mySession().close();
        transaction.commit();
        return book;
    }

    //получение всех данных с таблицы
    public List<Book> getAllBooks() {
        Session session;
        try {
            session = sessionFactory.getCurrentSession();
        } catch (HibernateException ex) {
            session = mySession();
        }
        List<Book> books = new ArrayList<>();
        try {
            books = session.createQuery("from Book ").list();
        } catch (HibernateException he) {
            System.out.println("Error getting books: " + he);
            he.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
        return books;
    }

    //запись новой книги
    public void addNewBook(Book book) {
        Transaction transaction = mySession().beginTransaction();
        mySession().save(book);
        mySession().close();
        transaction.commit();
    }

    //изменение данных в объекте
    public void updateBook(Book newBook) {
        Transaction transaction = null;
        //Book book = mySession().get(Book.class, newBook.getId());
        //book = newBook;

        Session session;

        try {
            session = mySession();
        } catch (HibernateException ex) {
            session = mySession();
        }

        try {
            transaction = session.beginTransaction();
            //С анотацией   @ManyToOne(cascade = {CascadeType.MERGE})
            //метод update() не работает, работает метод merge()
            session.merge(newBook);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }

    //удаление объекта
    public void remove(int id) {
        Session session;
        Book book = null;

        try {
            session = mySession();
            book = session.get(Book.class, id);
        } catch (HibernateException ex) {
            session = mySession();
        }
        Transaction transaction = null;

        try {
            transaction = session.beginTransaction();
            session.delete(book);
            transaction.commit();
        } catch (HibernateException ex) {
            System.out.println("Error deleting book: " + ex);
            if (transaction != null) {
                transaction.rollback();
            }
        } finally {
            if (session.isOpen()) {
                session.close();
            }
        }
    }


//    private final SessionFactory sessionFactory;
//
//    public DaoHib(SessionFactory sessionFactory) {
//        this.sessionFactory = sessionFactory;
//    }
//
//    public Session mySession() {
//        return sessionFactory.openSession();
//    }
//
//
//
//
//
//    public Book getBookId(int id) {
//        Session session = mySession().getSession();
//        Book book = session.get(Book.class, id);
//        System.out.println(book);
//        return book;
//    }
//
//
//
//    //получение всех данных с таблицы
//    public List<Book> getAllBooks() {
//        Session session = mySession().getSession();
//        List<Book> allBooks = session.createQuery("SELECT b FROM Book  b", Book.class).getResultList();
//        System.out.println(allBooks);
//        return allBooks;
//    }
//
//    //запись новой книги
//    public void addNewBook(Book book) {
//        Session session = mySession().getSession();
//        session.save(book);
//    }
//
//    //изменение данных в объекте
//    public void updateBook(Book book) {
//        Session session = mySession().getSession();
//        session.update(book);
//    }
//
//    //удаление объекта
//    public void remove(int id) {
//        Session session = mySession().getSession();
//        Book book = session.get(Book.class, id);
//        session.delete(book);
//    }
}

