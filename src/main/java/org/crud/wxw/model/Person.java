package org.crud.wxw.model;

import lombok.*;


import java.util.List;

@Getter
@Setter
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    Long id;

    private String name;

    private int age;
    private List<Book> bookList;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

}
