import java.util.Scanner;

public class Main {

    public static String type;
    public static boolean x = true;
    public static boolean a = true;

    public static void main (String[] args) {

        do {
            System.out.println("Do you want to use the schoolsystem?");
            Scanner inanswer = new Scanner(System.in);
            String answer = inanswer.nextLine();
            if (answer.equals("yes") || answer.equals("Yes")) {
                System.out.println("What is your name?");
                Scanner inname = new Scanner(System.in);
                String name = inname.nextLine();

                do {
                    System.out.println("Are you a teacher or a student?");
                    Scanner sort = new Scanner(System.in);
                    type = sort.nextLine();
                    if (type.equals("Teacher") || type.equals("teacher")) {
                        System.out.println("What is your ID?");
                        Scanner inID = new Scanner(System.in);
                        String TeacherID = inID.nextLine();

                        Person teacher = new Teacher(TeacherID,name);

                        a = true;
                    } else if (type.equals(("Student")) || type.equals("student")) {
                        //Student student = new Student();
                        System.out.println("What is your StudentID?");
                        Scanner inID = new Scanner(System.in);
                        String StudentID = inID.nextLine();

                        a = true;
                    } else {
                        System.out.println("Choose either a Teacher or a Student.");
                        a = false;
                    }
                } while (!a);

                x = true;
            } else if (answer.equals("No") || answer.equals("no")) {
                x = true;
            } else {
                System.out.println("Answer with either yes or no. ");
                x = false;
            }
        } while (!x);
    }
}
