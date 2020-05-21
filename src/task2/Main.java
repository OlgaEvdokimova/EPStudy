package task2;

import java.io.File;
import java.util.Arrays;

public class Main {

    private static final String PATH = "E:\\JavaOlya\\EpTasks\\EPStudy\\src";

    public static void main(String[] args) {
        File file = new File(PATH);
        File[] listOfFolders = file.listFiles();
        for (File item : listOfFolders) {

                System.out.println(item);


        }
    }
}
