package com.example.spingRestDemo.controllers;

import com.example.spingRestDemo.DTO.PersonDTO;
import com.example.spingRestDemo.facade.PersonFacadeImpl;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/people")
@RestController
public class PeopleController {
    private final PersonFacadeImpl personFacadeImpl;

    @Autowired
    public PeopleController(PersonFacadeImpl personFacadeImpl) {
        this.personFacadeImpl = personFacadeImpl;
    }

    @GetMapping
    public List<PersonDTO> getPeople() {
        return personFacadeImpl.getPeople();
    }

    @GetMapping("/{id}")
    public PersonDTO getPerson(@PathVariable(name = "id") int id) {
        return personFacadeImpl.getPerson(id);
    }

    @PostMapping
    public void create(@RequestBody @Valid PersonDTO personDTO) {
        personFacadeImpl.save(personDTO);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable(name = "id") int id) {
        personFacadeImpl.delete(id);
    }

    @PatchMapping("/{id}")
    public void update(@PathVariable(name = "id") int id, @RequestBody @Valid PersonDTO personDTO) {
        personFacadeImpl.update(id, personDTO);
    }
}
