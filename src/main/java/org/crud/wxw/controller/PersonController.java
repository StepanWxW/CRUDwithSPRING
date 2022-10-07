package org.crud.wxw.controller;

import org.crud.wxw.model.Person;
import org.crud.wxw.repository.impl.PersonRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("people")
public class PersonController {
    private final PersonRepositoryImpl personRepository;
    @Autowired
    public PersonController(PersonRepositoryImpl personRepository) {
        this.personRepository = personRepository;
    }

    @GetMapping
    public String getAll(Model model){
    model.addAttribute("people", personRepository.getAll());
        return "person/people";
    }
    @GetMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personRepository.getById(id));
        return "person/person";
    }
    @GetMapping("/new")
    public String newPerson (@ModelAttribute ("person") Person person) {
        return "person/new";
    }
    @PostMapping
    public String create(@ModelAttribute ("person") Person person){
        personRepository.create(person);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("person", personRepository.getById(id));
        return "person/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") Long id) {
        personRepository.update(person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        personRepository.delete(id);
        return "redirect:/people";
    }
}
