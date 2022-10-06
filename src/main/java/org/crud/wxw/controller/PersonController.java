package org.crud.wxw.controller;

import org.crud.wxw.repository.impl.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {
    private final PersonRepositoryImpl personRepository;
    @Autowired
    public PersonController(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping("/person")
    public String getAll(Model model){
    model.addAttribute("people", personRepository.getAll());
        return "person/people";
    }
    @GetMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personRepository.getById(id));
        return "person/person "+ id;
    }

}
