package com.company.lesson1.validator;

import java.util.List;

public interface Validator {
    List<String> getCorrectData(List<String> listOfLines) throws Exception;
}
