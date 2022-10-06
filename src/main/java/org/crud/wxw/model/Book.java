package org.crud.wxw.model;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@Table(name = "book", schema = "crudspring",catalog = "postgres")
@EqualsAndHashCode
@ToString
public class Book {
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    int id;
    @Column (name = "name")
    String name;
    @Column (name = "author")
    String author;
    @Column (name = "year")
    int year;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinColumn(name = "person_id", referencedColumnName = "id")
    Person person;

}
