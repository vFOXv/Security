package com.rw.controllers;

import com.rw.models.Book;

import com.rw.models.Buyer;
import com.rw.services.BookService;
import com.rw.services.BuyerService;
import com.rw.services.OwnerService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.*;

import java.util.Set;

@Controller
public class BookController {
    //public final DaoHib daoHib;
    public final BookService bookService;
    public final OwnerService ownerService;
    public final BuyerService buyerService;

    public BookController(BookService bookService, OwnerService ownerService, BuyerService buyerService) {
        this.bookService = bookService;
        this.ownerService = ownerService;
        this.buyerService = buyerService;
    }



    @GetMapping("")
    public String ShowAll(Model model) {
        model.addAttribute("message", "All books");
        //model.addAttribute("AllBook", daoHib.getAllBooks());
        model.addAttribute("AllBook", bookService.getAllBooks());
        //model.addAttribute("delete", "remove");
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
    public String removeBook(@PathVariable("id") Integer id) {
        //daoHib.remove(id);
        bookService.remove(id);
        return "redirect:/";
    }

    @GetMapping("/{id}")
    public String thisBook(@PathVariable("id") Integer id, Model model){
        //model.addAttribute("getBook", daoHib.getBookId(id));
        model.addAttribute("getBook", bookService.getBookId(id));
        model.addAttribute("owners",ownerService.getAllOwners());
        //model.addAttribute("buyers", buyerService.getAllBuyers());
        return "thisBook";
    }

    @PostMapping("/update/{id}")
    public String updateBook(@RequestParam("owner_id") Integer owner_id, @ModelAttribute Book book){
        //daoHib.updateBook(book);
        book.setOwner(ownerService.getOwnerId(owner_id));
        //book.setBuyers((Set<Buyer>) buyerService.getBuyerId(buyer_id));
        bookService.updateBook(book);
        return "redirect:/";
    }

//    @GetMapping("/remove")
//    public  String removeBuyer(@RequestParam(value = "book_id") Integer id,
//                               @RequestParam(value = "buyer_id")Integer b_id){
//        bookService.deleteBuyerFromBook(id, b_id);
//        return "thisBook";
//    }
}
