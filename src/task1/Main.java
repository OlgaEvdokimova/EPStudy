package task1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            String currentLine;
            BufferedReader bf = new BufferedReader(new FileReader("E:\\JavaOlya\\EpTasks\\EPStudy\\src\\1.txt"));
            List<String> list = new ArrayList<>();
            while ((currentLine = bf.readLine()) != null) {
                list.add(currentLine);
            }
            System.out.println(list);
            Collections.reverse(list);
            System.out.println(list);
            BufferedWriter bw = new BufferedWriter(new FileWriter("E:\\JavaOlya\\EpTasks\\EPStudy\\src\\2.txt"));
            for (String str : list){
                bw.write(str + "\n" );
            }
            bw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}