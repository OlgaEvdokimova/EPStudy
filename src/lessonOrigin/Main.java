package lessonOrigin;

import java.io.File;

public class Main {


    private static final String PATH = "E:/JavaOlya/EpTasks/EPStudy/person.txt";

    public static void main(String[] args) {
        File file = new File(PATH);
        ValidPerson validPerson = new ValidPerson();
        if (file.exists()) {
            try {
                validPerson.getPersons(PATH);
            } catch (IncorrectDataException | AgeNotNumerException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("File not found");
        }
    }

}
