package com.rw.controllers;

import com.rw.dao.DaoHib;
import com.rw.models.Book;

import com.rw.services.BookService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BookController {
    //public final DaoHib daoHib;
    public final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }



    @GetMapping("")
    public String ShowAll(Model model) {
        model.addAttribute("message", "All books");
        //model.addAttribute("AllBook", daoHib.getAllBooks());
        model.addAttribute("AllBook", bookService.getAllBooks());
        model.addAttribute("delete", "remove");
        return "listbook";
    }

    @GetMapping("/new")
    public String newBook(Model model) {
        model.addAttribute("book", new Book());
        return "newBook";
    }

    @PostMapping("/done")
    public String addBookPost(@ModelAttribute Book book) {
        //daoHib.addNewBook(book);
        bookService.addNewBook(book);
        return "redirect:/";
    }

    @GetMapping("/remove/{id}")
    public String removeBook(@PathVariable("id") int id) {
        //daoHib.remove(id);
        bookService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String thisBook(@PathVariable("id") int id, Model model){
        //model.addAttribute("getBook", daoHib.getBookId(id));
        model.addAttribute("getBook", bookService.getBookId(id));
        return "thisBook";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@ModelAttribute Book book){
        //daoHib.updateBook(book);
        bookService.updateBook(book);
        return "redirect:/";
    }
}
