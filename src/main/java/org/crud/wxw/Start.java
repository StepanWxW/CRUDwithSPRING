package org.crud.wxw;

import org.crud.wxw.service.BookService;

public class Start {
    public static void main(String[] args) {
        BookService bookService = new BookService();
        System.out.println(bookService.getById(4L));
    }
}
