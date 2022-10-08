package org.crud.wxw.controller;

import org.crud.wxw.model.Person;
import org.crud.wxw.repository.impl.PersonRepositoryImpl;
import org.crud.wxw.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
@RequestMapping("people")
public class PersonController {
    private final PersonService personService;
    @Autowired
    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping
    public String getAll(Model model){
    model.addAttribute("people", personService.getAll());
        return "person/people";
    }
    @GetMapping("/{id}")
    public String getId(@PathVariable("id") Long id, Model model) {
        model.addAttribute("person", personService.getById(id));
        return "person/person";
    }
    @GetMapping("/new")
    public String newPerson (@ModelAttribute ("person") Person person) {
        return "person/new";
    }
    @PostMapping
    public String create(@ModelAttribute ("person") Person person){
        personService.create(person);
        return "redirect:/people";
    }
    @GetMapping("/{id}/edit")
    public String edit(Model model, @PathVariable("id") Long id){
        model.addAttribute("person", personService.getById(id));
        return "person/edit";
    }
    @PatchMapping("/{id}")
    public String update(@ModelAttribute("person") Person person, @PathVariable("id") Long id) {
        personService.update(person);
        return "redirect:/people";
    }
    @DeleteMapping("/{id}")
    public String delete(@PathVariable("id") Long id) {
        personService.delete(id);
        return "redirect:/people";
    }
}
