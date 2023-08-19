package com.example.spingRestDemo.mappers;

import com.example.spingRestDemo.DTO.PersonDTO;
import com.example.spingRestDemo.models.Person;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

@Component
public class PersonMapper{
    private final ModelMapper modelMapper;

    public PersonMapper() {
        this.modelMapper = new ModelMapper();
    }

    public Person convertToPerson(PersonDTO personDTO) {
        return modelMapper.map(personDTO, Person.class);
    }

    public PersonDTO convertToPersonDTO(Person person) {
        return modelMapper.map(person, PersonDTO.class);
    }

}
