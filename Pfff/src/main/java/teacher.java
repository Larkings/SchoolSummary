import java.util.Scanner;
import java.util.ArrayList;

public class teacher extends Person {
    public static String name;
    public static int age;
    public static String answer;
    String mail;
    String subject;

    @SuppressWarnings("unchecked")
    void freshstart (){
        ArrayList subjects = new ArrayList();
        Scanner subput = new Scanner(System.in);
        System.out.println("What subjects do you give? (Math, Science, Dutch, English, France," +
                " IT, Pe, Biology, Economics)");
        Scanner answer = new Scanner(System.in);
        subject = subput.nextLine();
        boolean x = true;
        do {
            if (subject.equals("Math")){
                subjects.add(subject);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    System.out.println("Which subject do you also give?");
                    subject = subput.nextLine();
                    subjects.add(subject);
                    System.out.println(subjects);
                } else {
                    x = true;
                }

            } else if(subject.equals("Science")){
                subjects.add(subject);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subject.equals("Dutch")){
                subjects.add(subject);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subject.equals("English")){
                subjects.add(subject);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subject.equals("France")){
                subjects.add(subject);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subject.equals("IT")){
                subjects.add(subject);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subject.equals("PE")){
                subjects.add(subject);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subject.equals("Biology")){
                subjects.add(subject);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subject.equals("Economics")){
                subjects.add(subject);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }

            } else {
                System.out.println("That isn't a subject given on this school.");
            } ;
        }
        while(!x);


    };

    void allready(){

    };
}
