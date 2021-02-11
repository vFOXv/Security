package com.rw.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;


@Entity
@Table(name="books")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String author;

    private String your;

    private String style;

    private int amountPages;

    private String description;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "id_owner")
    private Owner owner;

    @ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)
    Set<Buyer> buyers = new HashSet<>();

    public Book() {    }

    public Book(String name, String author, String your, String style, int amountPages, String description, Owner owner, Set<Buyer> buyers) {
        this.name = name;
        this.author = author;
        this.your = your;
        this.style = style;
        this.amountPages = amountPages;
        this.description = description;
        this.owner = owner;
        this.buyers = buyers;
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

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
    }

    public Set<Buyer> getBuyers() {
        return buyers;
    }

    public void setBuyers(Set<Buyer> buyers) {
        this.buyers = buyers;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        return id == book.id &&
                amountPages == book.amountPages &&
                Objects.equals(name, book.name) &&
                Objects.equals(author, book.author) &&
                Objects.equals(your, book.your) &&
                Objects.equals(style, book.style) &&
                Objects.equals(description, book.description) &&
                Objects.equals(owner, book.owner) &&
                Objects.equals(buyers, book.buyers);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, author, your, style, amountPages, description, owner, buyers);
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", author='" + author + '\'' +
                ", your='" + your + '\'' +
                ", style='" + style + '\'' +
                ", amountPages=" + amountPages +
                ", description='" + description + '\'' +
                ", owner=" + owner +
                ", buyers=" + buyers +
                '}'+"\n";
    }
}

    