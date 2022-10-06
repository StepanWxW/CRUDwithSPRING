package org.crud.wxw.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Entity
@Getter
@Setter
@Table(name = "person", schema = "crudspring",catalog = "postgres")
@EqualsAndHashCode
@ToString
public class Person {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    @Column (name = "name")
    String name;
    @Column (name = "age")
    int age;
    @OneToMany (mappedBy = "person")
    List<Book> bookList;
}
