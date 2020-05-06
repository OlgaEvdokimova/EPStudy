package com.company.lesson1.validator;

import com.company.lesson1.constants.Constants;
import com.company.lesson1.exceptions.IncorrectDataException;
import com.company.lesson1.exceptions.AgeNotNumerException;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ValidatorImp implements Validator {


    private List<String> validLines;
    private String[] splitLine;

    public ValidatorImp() {
        this.validLines = new ArrayList<>();
    }

    @Override
    public List<String> getCorrectData(List<String> listOfLines) throws IncorrectDataException, AgeNotNumerException {
        Iterator<String> i = listOfLines.iterator();
        boolean number = true;
        while (i.hasNext()) {
            splitLine = i.next().split("\\s");
            if (!(splitLine.length == 4)) {
                throw new IncorrectDataException("Incorrect Data in Line");
            }
            try {
                Integer.parseInt(splitLine[Constants.AGE]);
            } catch (Exception e) {
                number = false;
            }
            if (!number) {
                throw new AgeNotNumerException(splitLine[Constants.AGE] + " не число");
            }
            validLines.add(splitLine.toString());
        }
        return validLines;
    }
}
