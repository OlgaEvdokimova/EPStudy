package lessonOrigin;

public class Person {

    String firsName;
    String lastName;
    String middleName;
    int age;
public Person(){}

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Person(String lastName, String firsName, String middleName, int age) {
        this.firsName = firsName;
        this.lastName = lastName;
        this.middleName = middleName;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firsName='" + firsName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", middleName='" + middleName + '\'' +
                ", age=" + age +
                '}';
    }

}
