import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Questionable {
    SchoolClass H3B;

    Questionable() {
        Teacher romeo = new Teacher("768345", "Romeo", "Teacher", "Romeo.Julianas@hva.nl",
                "04-05-2021", "M", "Math");
        ArrayList<Student> students1 = new ArrayList<>();

        students1.add(new Student("809567", "Gudo", "Student", "Gudo.Soeterik@hva.nl","M","04-05-2021","Economics"));
        students1.add(new Student("678234", "Joep ", "Student", "Joep.ter.Keurs@hva.nl","M","04-05-2021","Culture"));
        students1.add(new Student("742342", "Jochem", "Student", "Jochem.Ingelse@hva.nl","M","04-05-2021","Economics"));
        students1.add(new Student("645432", "Robbert-Jan", "Student", "Robbert-Jan.Hamhuis@hva.nl","M","04-05-2021","Programming"));
        students1.add(new Student("123264", "Laurens", "Student", "Laurens.Kunst@hva.nl","M","04-05-2021","Programming"));
        students1.add(new Student("856345", "Corneel", "Student", "Corneel.Barneveld@hva.nl","M","04-05-2021","Economics"));
        students1.add(new Student("577543", "Twan", "Student", "Twan.de.Chalmot@hva.nl","M","04-05-2021","Programming"));
        students1.add(new Student("645675", "Wouter", "Student", "Wouter.Koot@hva.nl","M","04-05-2021","Economics"));
        students1.add(new Student("809567", "Willem", "Student", "Willem.de.valk@hva.nl","M","04-05-2021","Culture"));
        students1.add(new Student("768345", "Louwrens", "Student", "Louwrens.Mooiers@hva.nl","M","04-05-2021","Economics"));
        students1.add(new Student("789654", "Alie", "Student", "Alie.Worst@hva.nl","M","04-05-2021","Programming"));

        H3B = new SchoolClass("2021", "H3B", romeo, students1);
    }


    private void getExistencePerson(String s) {

        System.out.println();
    }


    public void startQuestionnaire() {
        do {
            System.out.println("What is your ID, otherwise type in 'none'");
            String inID = new Scanner(System.in).nextLine();
            Person foundPerson = H3B.getPersonById(inID);

            if (foundPerson != null) {
                getExistencePerson(inID);
            } else {
                createPersonQuestionnaire();
            }
        } while (false);
    }

    public static String getRandomNumberString() {
        Random rand = new Random();
        int number = rand.nextInt(999999);
        return String.format("%06d", number);
    }

    private void createPersonQuestionnaire() {
        System.out.println("What is your gender?");
        String inGen = new Scanner(System.in).nextLine();

        System.out.println("What is your name?");
        String inName = new Scanner(System.in).nextLine();


        System.out.println("What is your mail?");
        String inMail = new Scanner(System.in).nextLine();

        System.out.println("What is your birthdate?");
        String inBirthDate = new Scanner(System.in).nextLine();

        System.out.println("are you a teacher or a student?");
        String intype = new Scanner(System.in).nextLine();


        switch (intype) {
            case "Teacher", "teacher" -> {

                System.out.println("What subject do you teach?");
                String inteach = new Scanner(System.in).nextLine();

                getRandomNumberString();
                H3B.replaceTeacher(new Teacher(getRandomNumberString(), inName, intype, inMail, inteach, inBirthDate, inGen));
                showTeacherInfo();
            }


            case "Student", "student" -> {

                System.out.println("What subject do you follow?");
                String inSub = new Scanner(System.in).nextLine();


                getRandomNumberString();
                H3B.addOneStudent(new Student(getRandomNumberString(), inName, intype, inMail,inGen, inBirthDate, inSub));

                showStudentInfo();
            }

        }
    }

    public void showTeacherInfo() {
        System.out.println("Here is a summary:");
        System.out.println();
        System.out.println("Hi " + H3B.getTeacher().getName() + ", ");
        System.out.println("You are a: " + H3B.getTeacher().getRole() + ".");
        System.out.println("Your birthdate is: " + H3B.getTeacher().getBirthday() + ".");
        System.out.println("You are a: " + H3B.getTeacher().getGender() + ".");
        System.out.println("Your mail-address is: " + H3B.getTeacher().getEmail() + ".");
        System.out.println("Your teacherID is: " + H3B.getTeacher().getId() + ".");
        System.out.println("You teach the subjects: " + H3B.getTeacher().getSubject() + ".");
    }



    public void showStudentInfo() {

        // id te gebruiken inplaats van laatst ingevoerde student
        System.out.println("Here is a summary:");
        System.out.println();
        System.out.println("Hi " + H3B.getStudents().get(H3B.getStudents().size() -1).getName() + ", ");
        System.out.println("You are a: " + H3B.getStudents().get(H3B.getStudents().size() -1).getRole() + ".");
        System.out.println("Your birthdate is: " + H3B.getStudents().get(H3B.getStudents().size() -1).getBirthday() + ".");
        System.out.println("You are a: " + H3B.getStudents().get(H3B.getStudents().size() -1).getGender() + ".");
        System.out.println("Your mail-address is: " + H3B.getStudents().get(H3B.getStudents().size() -1).getEmail() + ".");
        System.out.println("Your teacherID is: " + H3B.getStudents().get(H3B.getStudents().size() -1).getId() + ".");
        System.out.println("You follow the subjects: " + H3B.getStudents().get(H3B.getStudents().size() -1).getSubjectFollow() + ".");
    }


}
