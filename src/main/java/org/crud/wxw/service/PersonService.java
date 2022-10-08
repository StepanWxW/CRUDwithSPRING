package org.crud.wxw.service;

import org.crud.wxw.entity.PersonEntity;
import org.crud.wxw.mapper.PersonMapper;
import org.crud.wxw.model.Person;
import org.crud.wxw.repository.impl.PersonRepositoryImpl;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonService {
    PersonRepositoryImpl personRepository = new PersonRepositoryImpl();
    PersonMapper personMapper = new PersonMapper();
    public PersonEntity create(Person person) {
        PersonEntity personEntity = personMapper.toModelEntity(person);
        personRepository.create(personEntity);
        return personEntity;
    }

    public List<Person> getAll() {
        return personRepository.getAll().stream().map(PersonMapper::toModel).collect(Collectors.toList());
    }

    public Person getById(Long id) {
        return personMapper.toModel(personRepository.getById(id));
    }
    public PersonEntity update(Person person) {
        return personRepository.update(personMapper.toModelEntity(person));
    }

    public void delete(Long id) {
        personRepository.delete(id);
    }

    public PersonService(PersonRepositoryImpl personRepository, PersonMapper personMapper) {
        this.personRepository = personRepository;
        this.personMapper = personMapper;
    }
}
