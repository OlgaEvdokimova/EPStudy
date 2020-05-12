package com.company.lesson1.validator;

import com.company.lesson1.constants.Constants;
import com.company.lesson1.exceptions.IncorrectDataException;
import com.company.lesson1.exceptions.AgeNotNumerException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class ValidatorImp implements Validator {


    private List<String> validLines;

    public ValidatorImp() {
        this.validLines = new ArrayList<>();
    }

    @Override
    public List<String> getCorrectData(List<String> listOfLines)  {
        for (String line : listOfLines) {
            String validLine ;
            try {
                validLine = getLine(line);
                validLines.add(validLine);
            }
            catch (AgeNotNumerException | IncorrectDataException e){
                System.out.println(e.getMessage());
            }
        }
        return validLines;
    }

    public String getLine(String line)throws IncorrectDataException, AgeNotNumerException  {
        StringBuilder stringBuilder = new StringBuilder();
        String[] splitLine = line.split("\\s+");
        if (!(splitLine.length == 4)) {
            throw new IncorrectDataException("Incorrect Data in Line");
        }
        if (!isValidNumber(splitLine)) {
            throw new AgeNotNumerException(splitLine[Constants.AGE] + " не число");
        }
        for (String element : splitLine) {
            stringBuilder.append(element).append(" ");
        }
        return stringBuilder.toString();

    }

    public boolean isValidNumber(String[] splitLine) {
        boolean num = false;
        try {
            Integer.parseInt(splitLine[Constants.AGE]);
            num = true;
        } catch (NumberFormatException e) {
            e.getMessage();
        }
        return num;
    }
}


//    @Override
//    public List<String> getCorrectData(List<String> listOfLines) throws IncorrectDataException, AgeNotNumerException {
//        for (String line : listOfLines) {
//            StringBuilder stringBuilder = new StringBuilder();
//            String[] splitLine = line.split("\\s+");
//            if (!(splitLine.length == 4)) {
//                throw new IncorrectDataException("Incorrect Data in Line");
//            }
//            if (!isValidNumber(splitLine)) {
//                throw new AgeNotNumerException(splitLine[Constants.AGE] + " не число");
//            }
//            for (String element : splitLine) {
//                stringBuilder.append(element).append(" ");
//            }
//            validLines.add(stringBuilder.toString());
//        }
//        return validLines;
//    }
//
//    public boolean isValidNumber(String[] splitLine) {
//        boolean num = false;
//        try {
//            Integer.parseInt(splitLine[Constants.AGE]);
//            num = true;
//        } catch (AgeNotNumerException e) {
//            e.getMessage();
//        }
//        return num;
//    }
//}