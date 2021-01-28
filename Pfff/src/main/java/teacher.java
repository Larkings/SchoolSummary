import java.util.Scanner;
import java.util.ArrayList;

public class teacher extends Person {
    public static String name;
    public static int age;
    public static String answer;
    String mail;
    String subject;

    void freshstart (){
        ArrayList subjects = new ArrayList();
        Scanner subput = new Scanner(System.in);
        System.out.println("What subjects do you give?");
        subject = subput.nextLine();
        do {
            if (subjectAnswers.equals("Math")){
                subjects.add(subjectAnswers);
            } else if(subjectAnswers.equals("Science")){
                subjects.add(subjectAnswers);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subjectAnswers.equals("Dutch")){
                subjects.add(subjectAnswers);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subjectAnswers.equals("English")){
                subjects.add(subjectAnswers);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subjectAnswers.equals("France")){
                subjects.add(subjectAnswers);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subjectAnswers.equals("IT")){
                subjects.add(subjectAnswers);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subjectAnswers.equals("PE")){
                subjects.add(subjectAnswers);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subjectAnswers.equals("Biology")){
                subjects.add(subjectAnswers);
                System.out.println("Do you give more subjects?");
                String arrayAnswer = answer.next();
                if (arrayAnswer.equals("yes")){
                    x = true;
                } else {
                    x = false;
                }
            } else if(subjectAnswers.equals("Economics")){
                subjects.add(subjectAnswers);
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
