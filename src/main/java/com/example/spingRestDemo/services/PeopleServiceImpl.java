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
public class PeopleServiceImpl implements PeopleService{
    private final PeopleRepository peopleRepository;

    @Autowired
    public PeopleServiceImpl(PeopleRepository peopleRepository) {
        this.peopleRepository = peopleRepository;
    }

    @Override
    public List<Person> findAll() {
        return peopleRepository.findAll();
    }

    @Override
    public Person findOne(int id) {
        Optional<Person> personOptional = peopleRepository.findById(id);
        return personOptional.orElseThrow(PersonNotFoundException::new);
    }

    @Override
    public void save(Person person) {
        person.setCreatedAt(LocalDateTime.now());
        person.setUpdatedAt(LocalDateTime.now());

        peopleRepository.save(person);
    }

    @Override
    public void update(int id, Person person) {
        Person targetPerson = findOne(id);

        person.setCreatedAt(targetPerson.getCreatedAt());
        person.setUpdatedAt(LocalDateTime.now());

        person.setId(id);
        peopleRepository.save(person);
    }

    @Override
    public void delete(int id) {
        peopleRepository.deleteById(id);
    }

}
