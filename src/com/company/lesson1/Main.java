package com.company.lesson1;


import com.company.lesson1.entity.Person;
import com.company.lesson1.entityCreator.EntityCreator;
import com.company.lesson1.entityCreator.EntityCreatorImp;
import com.company.lesson1.exceptions.IncorrectDataException;
import com.company.lesson1.reader.Reader;
import com.company.lesson1.reader.ReaderImp;
import com.company.lesson1.validator.Validator;
import com.company.lesson1.validator.ValidatorImp;

import java.io.IOException;
import java.util.List;

public class Main {
    private static final String PATH = "E:/JavaOlya/EpTasks/EPStudy/person.txt";

    public static void main(String[] args) {
        Reader reader = new ReaderImp(PATH);
        Validator validator = new ValidatorImp();
        EntityCreator entityCreator = new EntityCreatorImp();

        List<String> linesFromReader = reader.getLinesFromFile();
        List<String> linesFromValidator = null;
        try {
            linesFromValidator = validator.getCorrectData(linesFromReader);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        List<Person> personList = entityCreator.createAndGetPersons(linesFromValidator);
       System.out.println(personList);

    }
}

