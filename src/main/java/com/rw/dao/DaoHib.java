package com.rw.dao;

import com.rw.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

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

        //запись в БД(вносить можно с помощью set)
        /*Person person = new Person("Name_4",17);
        session.save(person);
        transaction.commit();  */

        //получение по id
        /*Book book = session.get(Book.class, 3);
        System.out.println(book);  */

//        //получение объекта по id
//        public Book getHamster(Long id){
//            Book book = mySession().get(Book.class, id);
//            return book;
//        }

        //получение всех данных с таблицы
    public List<Book> getAllBooks() {
        Transaction transaction = mySession().beginTransaction();
        List<Book> allBooks = mySession().createQuery("SELECT b FROM Book  b", Book.class).getResultList();
        System.out.println(allBooks);
        mySession().close();
        transaction.commit();
        return allBooks;
    }

        //запись новой книги
    public void addNewBook(Book book){
        Transaction transaction = mySession().beginTransaction();
        mySession().save(book);
        mySession().close();
        transaction.commit();
    }
        //изменение данных в объекте(данные обновляются автоматически)
        /*Person person = session.get(Person.class, 1);
        System.out.println(person);
        person.setAge(16);
        System.out.println(person);
        transaction.commit();   */

        //удаление объекта
    public void remove(Integer id){
        Transaction transaction = mySession().beginTransaction();
        Book book = mySession().get(Book.class, id);
        mySession().delete(book);
        //mySession().close();
        transaction.commit();
    }

    //удаление объекта
        /*Person person = session.get(Person.class, 2);
        session.delete(person);
        transaction.commit();
        System.out.println(person);  */

        /*City lviv = new City("Lviv",50_000);
        City kiev = new City("Kiev", 60_000);
        City odessa = new City("Odessa",10_000);
        session.save(lviv);
        session.save(kiev);
        session.save(odessa);
        transaction.commit();  */


        //sessionFactory.close();
    }

