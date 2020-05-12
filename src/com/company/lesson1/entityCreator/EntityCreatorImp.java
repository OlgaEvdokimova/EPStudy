package com.company.lesson1.entityCreator;

import com.company.lesson1.constants.Constants;
import com.company.lesson1.entity.Person;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class EntityCreatorImp implements EntityCreator {
    private List<Person> persons;


    public EntityCreatorImp() {
        this.persons = new ArrayList<>();
    }

    @Override
    public List<Person> createAndGetPersons(List<String> validLines) {
        String firstName;
        String lastName;
        String middleName;
        int age;
         Iterator<String> i = validLines.iterator();
        while (i.hasNext()) {
            String[] splitLine = i.next().split("\\s");

            lastName = splitLine[Constants.LAST_NAME];
            firstName = splitLine[Constants.FIRST_NAME];
            middleName = splitLine[Constants.MIDDLE_NAME];
            //System.out.println(splitLine[Constants.AGE]);
            age = Integer.parseInt(splitLine[Constants.AGE]);
            persons.add(new Person(lastName, firstName, middleName, age));
        }
        return persons;
    }
}
