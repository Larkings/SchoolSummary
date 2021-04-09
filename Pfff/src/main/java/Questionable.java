import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Questionable {
    private static ArrayList<Person> persons = new ArrayList();

    Questionable() {
        persons.add(new Student("809567"));
        persons.add(new Teacher("768345"));
        persons.add(new Teacher("789654"));
    }

    public void startQuestionnaire() {
        do {
            System.out.println("What is your ID");
            String inID = new Scanner(System.in).nextLine();
            Person foundPerson = getPerson(inID);

            if (foundPerson != null) {
                getExistencePerson(inID);
            } else {
                createPersonQuestionnaire();
            }
        } while (true);
    }

    private void createPersonQuestionnaire() {
        System.out.println("What is your gender?");
        System.out.println("What is your mail?");
        System.out.println("What is your birthdate?");
        System.out.println("are you a teacher or a student?");
        Scanner intype = new Scanner(System.in);
        String type = intype.nextLine();
        switch (type) {
            case "Teacher", "teacher" -> {
                Teacher teacher = new Teacher();
                System.out.println("What subject do you teach?");

                Random rand = new Random();
            }


            case "Student", "student" -> {
                System.out.println("What subject do you follow?");

                Random rand = new Random();


            }
        }
    }

    private void getExistencePerson(String s) {
        System.out.println(s);
    }

    private Person getPerson(String inID) {
        Person foundPerson = null;

        for(Person person : persons) {
            if (person.getId().equals(inID)) {
                 foundPerson = person;
            }
        }
        return foundPerson;
    }


}
