package String2;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class Reader {
    public static  String readIntoString(File file){
        String wholeText = "";
        String line;

        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            while ((line = br.readLine()) != null) {
                wholeText += line;
            }
        }catch (IOException e) {
            e.printStackTrace();
        }
        return wholeText;
    }
}
