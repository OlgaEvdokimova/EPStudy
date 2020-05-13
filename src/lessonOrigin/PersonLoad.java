package lessonOrigin;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class PersonLoad {

    private static final int LAST_MAME = 0;
    private static final int FIRST_MAME = 1;
    private static final int MIDDLE_MAME = 2;
    private static final int AGE = 3;

    public  List<Person> getPersons(String PATH) throws IncorrectDataException, AgeNotNumerException {
        List<Person> persons = new ArrayList<>();
        int age;

        try {
            String currentLine;
            BufferedReader br = new BufferedReader(new FileReader(PATH));
            while ((currentLine = br.readLine()) != null) {
                String[] splitLine = currentLine.split("\\s+");
                if (!(splitLine.length == 4)) {
                    throw new IncorrectDataException("Incorrect data");
                }
                try {
                    Integer.parseInt(splitLine[AGE]);
                } catch (NumberFormatException e) {
                    throw new AgeNotNumerException(splitLine[AGE] + " not number");
                }
                Person person = new Person();
                person.setLastName(splitLine[LAST_MAME]);
                person.setFirsName(splitLine[FIRST_MAME]);
                person.setMiddleName(splitLine[MIDDLE_MAME]);
                age = Integer.parseInt(splitLine[AGE]);
                person.setAge(age);
                persons.add(person);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return persons;
    }

}
