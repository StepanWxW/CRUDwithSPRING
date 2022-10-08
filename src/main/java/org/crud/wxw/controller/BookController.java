package org.crud.wxw.controller;

import lombok.Getter;
import lombok.Setter;
import org.crud.wxw.model.Book;
import org.crud.wxw.model.Person;
import org.crud.wxw.service.BookService;
import org.crud.wxw.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Setter
@Getter
@Controller
@RequestMapping("books")
public class BookController {
    private final BookService bookService;
    private final PersonService personService;
    @Autowired
    public BookController(BookService bookService, PersonService personService) {
        this.bookService = bookService;
        this.personService = personService;
    }


    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("books", bookService.getAll());
        return "book/books";
    }
    @GetMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model, @ModelAttribute("person") Person person) {
        model.addAttribute("book", bookService.getById(id));
        model.addAttribute("people", personService.getAll());
        return "book/book";
    }
    @GetMapping("/new")
    public String newBook (@ModelAttribute("book") Book book) {
        return "book/new";
    }
    @PostMapping
    public String create(@ModelAttribute ("book") Book book){
        bookService.create(book);
        return "redirect:/books";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("book", bookService.getById(id));
        return "book/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable("id") Long id) {
        bookService.update(book);
        return "redirect:/books";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookService.delete(id);
        return "redirect:/books";
    }
    @PatchMapping("/add")
    public String addPeople(@ModelAttribute ("person") Person person, @ModelAttribute("book") Book book) {
        System.out.println(person);
        System.out.println(book);
        Book book1 = bookService.getById((long) book.getId());
        book1.setPerson(person);
        System.out.println(book);
        bookService.update(book1);
        return "redirect:/books";
    }
}
