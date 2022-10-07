package org.crud.wxw.controller;

import org.crud.wxw.model.Book;
import org.crud.wxw.repository.impl.BookRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("books")
public class BookController {
    private final BookRepositoryImpl bookRepository;
    @Autowired
    public BookController(BookRepositoryImpl bookRepository) {
        this.bookRepository = bookRepository;
    }
    @GetMapping
    public String getAll(Model model) {
        model.addAttribute("books", bookRepository.getAll());
        return "book/books";
    }
    @GetMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("book", bookRepository.getById(id));
        return "book/book";
    }
    @GetMapping("/new")
    public String newBook (@ModelAttribute("book") Book book) {
        return "book/new";
    }
    @PostMapping
    public String create(@ModelAttribute ("book") Book book){
        bookRepository.create(book);
        return "redirect:/books";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("book", bookRepository.getById(id));
        return "book/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("book") Book book, @PathVariable("id") Long id) {
        bookRepository.update(book);
        return "redirect:/books";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        bookRepository.delete(id);
        return "redirect:/books";
    }
}
