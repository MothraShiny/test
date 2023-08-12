package com.example.spingRestDemo.controllers;

import com.example.spingRestDemo.DTO.PersonDTO;
import com.example.spingRestDemo.facade.PersonFacade;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/people")
@RestController
public class PeopleController {
    private final PersonFacade personFacade;

    @Autowired
    public PeopleController(PersonFacade personFacade) {
        this.personFacade = personFacade;
    }

    @GetMapping
    public List<PersonDTO> getPeople() {
        return personFacade.getPeople();
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable(name = "id") int id) {
        return personFacade.getPerson(id);
    }

    @PostMapping
    public void create(@RequestBody @Valid PersonDTO personDTO) {
        personFacade.save(personDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        personFacade.delete(id);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable(name = "id") int id, @RequestBody @Valid PersonDTO personDTO) {
        personFacade.update(id, personDTO);
    }
}
