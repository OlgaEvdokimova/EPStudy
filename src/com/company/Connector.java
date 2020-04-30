package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Connector {
    public void writeWithSerialisation(File file, Text text) {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {

                writer.writeObject(text.sentences);

        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public List<Sentence> readWithSerialization(File file) {
        List<Sentence> sentences = new ArrayList<>();
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {

            sentences = (List<Sentence>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.getException();
        }
        return sentences;
    }
}
