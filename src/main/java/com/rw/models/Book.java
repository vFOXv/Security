package com.rw.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id_b")
    private int id;

    @Column(name = "name_b")
    private String name;

    @Column(name = "author")
    private String author;

    @Column(name = "your_b")
    private String your;

    @Column(name = "style_b")
    private String style;

    @Column(name = "amount_b")
    private int amountPages;

    @Column(name = "description_b")
    private String description;

    public Book() {    }

    public Book(String name, String author, String your, String style, int amountPages, String description) {
        this.name = name;
        this.author = author;
        this.your = your;
        this.style = style;
        this.amountPages = amountPages;
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String  getYour() {
        return your;
    }

    public void setYour(String your) {
        this.your = your;
    }

    public String getStyle() {
        return style;
    }

    public void setStyle(String style) {
        this.style = style;
    }

    public int getAmountPages() {
        return amountPages;
    }

    public void setAmountPages(int amountPages) {
        this.amountPages = amountPages;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", your=" + your +
                ", style='" + style + '\'' +
                ", amountPages=" + amountPages +
                ", description='" + description + '\'' +
                '}' +"\n";
    }
}

    