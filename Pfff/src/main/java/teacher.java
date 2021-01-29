import java.util.Scanner;
import java.util.ArrayList;

public class teacher extends Person {
    public static String name;
    public static int age;
    public static String answer;
    String mail;
    String subject;

    void freshstart () {
        boolean original = true;
        ArrayList subjects = new ArrayList();
        Scanner subput = new Scanner(System.in);
       do {
           boolean x = true;
           boolean b = true;
           boolean a = true;
           System.out.println("What subjects do you give? (Math, Science, Dutch, English, France," +
                   " IT, PE, Biology, Economics)");
           Scanner answer = new Scanner(System.in);
           subject = subput.nextLine();
           do {
               if (subject.equals(("Math")) || subject.equals("math") || subject.equals("Science") || subject.equals("science") ||
                       subject.equals("Dutch") || subject.equals("dutch") ||subject.equals("english") || subject.equals("france") ||
                       subject.equals("English") || subject.equals("France") || subject.equals("IT") || subject.equals("it") ||
                       subject.equals("PE") || subject.equals("pe") || subject.equals("biology") || subject.equals("economics") ||
                       subject.equals("Biology") || subject.equals("Economics")) {
                   subjects.add(subject);
                   x = true;
                   original = true;
                   do {
                       System.out.println("Do you give more subjects?");
                       String arrayAnswer = answer.next();
                       if (arrayAnswer.equals("yes") || (arrayAnswer.equals("Yes"))) {
                           System.out.println("Which subject do you also give?");
                           subject = subput.nextLine();
                           subjects.add(subject);
                           b = false;
                       } else if(arrayAnswer.equals("No") || (arrayAnswer.equals("no"))){
                           b = true;
                       } else {
                           System.out.println("You can only answer yes or no.");
                           b = false;
                       }
                   } while (!b);
               } else {
                   System.out.println("That isn't a subject given on this school.");
                   x = false;
               }

               do {
                   System.out.println("So you teach the subject(s) " + subjects +" is that corect?" );
                   Scanner verify = new Scanner(System.in);
                   String verified = verify.nextLine();
                   if (verified.equals("Yes") || verified.equals("yes")){
                       a = true;
                   } else if (verified.equals("No") || verified.equals("no")){
                       subjects. clear();
                       System.out.println("Your input will be cleared, start again and add the correct subject(s).");
                       a = true;
                       original = false;
                   } else {
                       System.out.println("You can only answer yes or no.");
                       a = false;
                   }
               } while (!a);
           }
           while (!x);

       } while (!original);

        System.out.println("Here is a quick summary:");
    }


    void allready(){

    };
}
