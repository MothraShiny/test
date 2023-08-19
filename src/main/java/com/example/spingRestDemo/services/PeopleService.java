package com.example.spingRestDemo.services;

import com.example.spingRestDemo.models.Person;

import java.util.List;

public interface PeopleService {
    List<Person> findAll();
    Person findOne(int id);
    void save(Person person);
    void update(int id, Person person);
    void delete(int id);
}
