package com.company;

import java.io.*;

public class Writer {
    public static void readToFile (File file, Text text) {
        try {
            ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(file));

            for (Sentence s : text.sentences) {
                writer.writeObject(s);
            }
            writer.close();
        } catch (
                IOException e) {
            e.printStackTrace();
        }
    }
}
