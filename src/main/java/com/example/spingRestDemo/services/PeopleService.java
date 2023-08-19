package com.example.spingRestDemo.services;

import com.example.spingRestDemo.models.Person;
import com.example.spingRestDemo.repositories.PeopleRepository;
import com.example.spingRestDemo.util.PersonNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
public class PeopleService {
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleService(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    public Person findOne(int id) {
        Optional<Person> personOptional = peopleRepository.findById(id);
        return personOptional.orElseThrow(PersonNotFoundException::new);
    }

    public void save(Person person) {
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());

        peopleRepository.save(person);
    }

    public void update(int id, Person person) {
        Person targetPerson = findOne(id);

        person.setCreatedAt(targetPerson.getCreatedAt());
        person.setUpdatedAt(LocalDateTime.now());

        person.setId(id);
        peopleRepository.save(person);
    }

    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

}
