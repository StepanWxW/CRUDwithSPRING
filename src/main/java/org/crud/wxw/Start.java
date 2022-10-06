package org.crud.wxw;

import org.crud.wxw.model.Person;
import org.crud.wxw.repository.impl.BookRepositoryImpl;
import org.crud.wxw.repository.impl.PersonRepositoryImpl;

public class Start {
    public static void main(String[] args) {
        BookRepositoryImpl bookRepository = new BookRepositoryImpl();
        PersonRepositoryImpl peopleRepository = new PersonRepositoryImpl();
//        Book book = new Book();
//        book.setAuthor("Pyhkin");
//        book.setName("Klychik");
//        book.setYear(1999);
//        bookRepository.create(book);
        System.out.println(bookRepository.getAll());
        Person people = new Person();
        people.setName("IGAR");
        people.setAge(24);
        peopleRepository.create(people);
        System.out.println(peopleRepository.getAll());
    }
}
