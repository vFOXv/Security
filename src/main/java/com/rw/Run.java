package com.rw;

import com.rw.models.Book;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Run {
    public static void main(String[] args) {

        SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();

        //запись в БД(вносить можно с помощью set)
        /*Person person = new Person("Name_4",17);
        session.save(person);
        transaction.commit();  */

        //получение по id
        /*Book book = session.get(Book.class, 3);
        System.out.println(book);  */

        List<Book> allBooks = session.createQuery("SELECT b FROM Book  b" , Book.class).getResultList();

        System.out.println(allBooks);


        //изменение данных в объекте(данные обновляются автоматически)
        /*Person person = session.get(Person.class, 1);
        System.out.println(person);
        person.setAge(16);
        System.out.println(person);
        transaction.commit();   */

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

        session.close();
        sessionFactory.close();
    }
}
