package com.rw.models;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "owner")
public class Owner {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String address;

    @OneToMany(mappedBy = "owner")
    Set<Book> bookSet = new HashSet<>();

    public Owner() { }

    public Owner(String name, String address) {
        this.name = name;
        this.address = address;
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

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//        Owner owner = (Owner) o;
//        return id == owner.id &&
//                Objects.equals(name, owner.name) &&
//                Objects.equals(address, owner.address) &&
//                Objects.equals(bookSet, owner.bookSet);
//    }
//
//    @Override
//    public int hashCode() {
//        return Objects.hash(id, name, address, bookSet);
//    }

    @Override
    public String toString() {
        return "Owner{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                '}'+"\n";
    }
}
