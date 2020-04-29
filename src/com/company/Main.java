package com.company;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class Main {

    public static void main(String[] args) throws IOException {
// existing text
        File file = new File("E:/JavaOlya/EpTasks/2REGEX/secret.txt");
        Text text = new Text(file);
        System.out.println("===============================");
        System.out.println(text.sentences);

// call 4 methods (tasks)
        text.replaceFirstWordAndTheLastWordInExclamatorySentences();
        text.findAndDeleteFirstLetter();
        //text.deleteSubstring("a", "f");
        text.findNoRepeatedWordsInFirstSentenceOfText();

// text after correcting
        System.out.println("===============================");
        System.out.println(text.sentences);
        File fileForWrite = new File("E:/JavaOlya/EpTasks/EPStudy/forWrite.txt");
        Writer.readToFile(fileForWrite, text);
    }

}


