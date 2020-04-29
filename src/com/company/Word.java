package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Word implements Serializable {
    private static final long serialVersionUID = 1;
    List<Letter> letters = new ArrayList<>();
    String word;

    Word(String word) {
        this.word = word;
        breakIntoLetters(word);

    }

    public void breakIntoLetters(String word) {
        Pattern pattern = Pattern.compile("[^.!?\\s]");
        Matcher matcher = pattern.matcher(word);
        while (matcher.find()) {
            String matcherLetter = matcher.group();
            Letter letter = new Letter(matcherLetter);
            letters.add(letter);
        }
    }

    public void getWordSize() {
        word.length();
    }


    @Override
    public String toString() {
        return word ;
    }


    @Override
    public boolean equals(Object obj) {
        return word.equals(obj);
    }

    @Override
    public int hashCode() {
        return word.hashCode();
    }
}
