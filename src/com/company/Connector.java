package com.company;

import java.io.*;

public class Connector  {
    public  void writeWithSerialisation(File file, Text text) {
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file))) {
            for (Sentence s : text.sentences) {
                writer.writeObject(s);
            }
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }

    public  Text readWithSerialization(File file) {
        Text text = null;
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))) {
            text = (Text) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex){
            ex.getException();
        }
        return text;
    }
}
