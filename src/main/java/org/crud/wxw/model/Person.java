package org.crud.wxw.model;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.crud.wxw.entity.PersonEntity;

import java.util.List;
import java.util.stream.Collectors;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Person {
    int id;
    String name;
    int age;
    List<Book> bookList;
}
