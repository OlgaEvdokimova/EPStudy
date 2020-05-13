package lessonOrigin;

public class Main {


    private static final String PATH = "E:/JavaOlya/EpTasks/EPStudy/person.txt";

    public static void main(String[] args) {

        PersonLoad personLoad = new PersonLoad();
        try {
            personLoad.getPersons(PATH);
        } catch (IncorrectDataException | AgeNotNumerException e) {
            e.printStackTrace();
        }
    }
}


