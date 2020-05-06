package com.company.lesson1.entityCreator;

import com.company.lesson1.entity.Person;

import java.util.List;

public interface EntityCreator {
    List<Person> createAndGetPersons(List<String> validLines);

}
