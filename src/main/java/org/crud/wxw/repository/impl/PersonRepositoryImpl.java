package org.crud.wxw.repository.impl;

import jakarta.persistence.EntityNotFoundException;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import org.crud.wxw.model.Person;
import org.crud.wxw.repository.PersonRepository;
import org.crud.wxw.util.SessionUtil;
import org.hibernate.Session;
import org.springframework.stereotype.Component;

import java.util.List;
@Component
public class PersonRepositoryImpl implements PersonRepository {
    SessionUtil sessionUtil = new SessionUtil();
    public Person create(Person person) {
        Session session = sessionUtil.openTransactionSession();
        session.persist(person);
        session.getTransaction().commit();
        session.close();
        return person;
    }

    public List<Person> getAll() {
        List<Person> personList;
        Session session = sessionUtil.openSession();
        CriteriaBuilder cb = session.getCriteriaBuilder();
        CriteriaQuery<Person> cq = cb.createQuery(Person.class);
        cq.from(Person.class);
        personList = session.createQuery(cq).getResultList();
        session.close();
        return personList;
    }

    public Person getById(Long id) {
        Session session = sessionUtil.openSession();
        Person person = session.get(Person.class, id);
        session.close();
        return person;
    }

    public Person update(Person people) {
        try(Session session = sessionUtil.openTransactionSession()) {
            session.saveOrUpdate(people);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("Person whit id: " + people.getId() + " is missing.");
        }
        return people;
    }

    public void delete(Long id) {
        try(Session session = sessionUtil.openTransactionSession()) {
            Person person = session.load(Person.class, id);
            session.delete(person);
            session.getTransaction().commit();
        } catch (EntityNotFoundException e) {
            System.out.println("People whit id: " + id + " is missing.");
        }
    }
}
