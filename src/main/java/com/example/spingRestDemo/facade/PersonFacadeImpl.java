package com.example.spingRestDemo.facade;

import com.example.spingRestDemo.DTO.PersonDTO;
import com.example.spingRestDemo.mappers.PersonMapper;
import com.example.spingRestDemo.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonFacadeImpl implements PersonFacade{
    private final PersonMapper personMapper;
    private final PeopleService peopleService;

    @Autowired
    public PersonFacadeImpl(PersonMapper personMapper, PeopleService peopleService) {
        this.personMapper = personMapper;
        this.peopleService = peopleService;
    }

    @Override
    public PersonDTO getPerson(int id) {
        return personMapper.convertToPersonDTO(peopleService.findOne(id));
    }

    @Override
    public List<PersonDTO> getPeople() {
        return peopleService.findAll().stream()
                .map(personMapper::convertToPersonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(PersonDTO personDTO) {
        peopleService.save(personMapper.convertToPerson(personDTO));
    }

    @Override
    public void update(int id, PersonDTO personDTO) {
        peopleService.update(id, personMapper.convertToPerson(personDTO));
    }

    @Override
    public void delete(int id) {
        peopleService.delete(id);
    }
}
