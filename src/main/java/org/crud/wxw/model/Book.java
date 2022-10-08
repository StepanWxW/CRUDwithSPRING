package org.crud.wxw.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.crud.wxw.entity.BookEntity;

@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Book {
    int id;
    String name;
    String author;
    int year;
    Person person;

}
