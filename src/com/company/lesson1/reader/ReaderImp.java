package com.company.lesson1.reader;

import com.company.lesson1.entity.Person;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReaderImp implements Reader{
    private List<String> listOfLines;
    private String currentLine;
    private String filePath;

    public ReaderImp(String filePath) {
        this.filePath = filePath;
        this.listOfLines = new ArrayList<>();
    }

    @Override
    public List<String> getLinesFromFile() {
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            while ((currentLine = br.readLine()) != null) {

                listOfLines.add(currentLine);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return listOfLines;
    }

}
