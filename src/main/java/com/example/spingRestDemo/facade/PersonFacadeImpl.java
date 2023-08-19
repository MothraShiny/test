package com.example.spingRestDemo.facade;

import com.example.spingRestDemo.DTO.PersonDTO;
import com.example.spingRestDemo.mappers.PersonMapper;
import com.example.spingRestDemo.services.PeopleServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PersonFacadeImpl implements PersonFacade{
    private final PersonMapper personMapper;
    private final PeopleServiceImpl peopleServiceImpl;

    @Autowired
    public PersonFacadeImpl(PersonMapper personMapper, PeopleServiceImpl peopleServiceImpl) {
        this.personMapper = personMapper;
        this.peopleServiceImpl = peopleServiceImpl;
    }

    @Override
    public PersonDTO getPerson(int id) {
        return personMapper.convertToPersonDTO(peopleServiceImpl.findOne(id));
    }

    @Override
    public List<PersonDTO> getPeople() {
        return peopleServiceImpl.findAll().stream()
                .map(personMapper::convertToPersonDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void save(PersonDTO personDTO) {
        peopleServiceImpl.save(personMapper.convertToPerson(personDTO));
    }

    @Override
    public void update(int id, PersonDTO personDTO) {
        peopleServiceImpl.update(id, personMapper.convertToPerson(personDTO));
    }

    @Override
    public void delete(int id) {
        peopleServiceImpl.delete(id);
    }
}
