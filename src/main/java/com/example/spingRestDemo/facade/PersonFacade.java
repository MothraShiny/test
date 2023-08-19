package com.example.spingRestDemo.facade;

import com.example.spingRestDemo.DTO.PersonDTO;

import java.util.List;

public interface PersonFacade {
    PersonDTO getPerson(int id);
    List<PersonDTO> getPeople();
    void save(PersonDTO personDTO);
    void update(int id, PersonDTO personDTO);
    void delete(int id);
}
