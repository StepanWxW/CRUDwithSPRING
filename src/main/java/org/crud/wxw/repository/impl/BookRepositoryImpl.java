package org.crud.wxw.repository.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.crud.wxw.model.Book;
import org.crud.wxw.repository.BookRepository;
import org.crud.wxw.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class BookRepositoryImpl implements BookRepository {
    SessionUtil sessionUtil = new SessionUtil();
    public Book create(Book book) {
        Session session = sessionUtil.openTransactionSession();
        session.persist(book);
        session.getTransaction().commit();
        session.close();
        return book;
    }

    public List<Book> getAll() {
        List<Book> bookList;
        Session session = sessionUtil.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Book> cq = cb.createQuery(Book.class);
        cq.from(Book.class);
        bookList = session.createQuery(cq).getResultList();
        session.close();
        return bookList;
    }

    public Book getById(Long id) {
        Session session = sessionUtil.openSession();
        Book book = session.get(Book.class, id);
        session.close();
        return book;
    }

    public Book update(Book book) {
        try(Session session = sessionUtil.openTransactionSession()) {
            session.saveOrUpdate(book);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Book whit id: " + book.getId() + " is missing.");
        }
        return book;
    }

    public void delete(Long id) {
        try(Session session = sessionUtil.openTransactionSession()) {
            Book book = session.load(Book.class, id);
            session.delete(book);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Book whit id: " + id + " is missing.");
        }
    }
}
