import java.util.ArrayList;
import java.util.Scanner;

/*ublic class student123 extends person123 {
    String lesson;
    int amount;

    void start(){
        boolean original = true;
        ArrayList<String> subjects = new ArrayList<>();
        Scanner subput = new Scanner(System.in);
        do {
            boolean x = true;
            boolean b = true;
            boolean a = true;
            System.out.println("How many lessons do you follow?");
            Scanner amount = new Scanner(System.in);
            this.amount = amount.nextInt();
            System.out.println("Which subjects do you follow? (Math, Science, Dutch, English, France," +
                    " IT, PE, Biology, Economics)");
            for (int i=1; i<this.amount+1; i++){
                System.out.println("Lesson "+ i +": ");
            }

            Scanner answer = new Scanner(System.in);
            lesson = subput.nextLine();
            do {
                if (lesson.equals(("Math")) || lesson.equals("math") || lesson.equals("Science") || lesson.equals("science") ||
                        lesson.equals("Dutch") || lesson.equals("dutch") || lesson.equals("english") || lesson.equals("france") ||
                        lesson.equals("English") || lesson.equals("France") || lesson.equals("IT") || lesson.equals("it") ||
                        lesson.equals("PE") || lesson.equals("pe") || lesson.equals("biology") || lesson.equals("economics") ||
                        lesson.equals("Biology") || lesson.equals("Economics")) {
                    subjects.add(lesson);
                    x = true;
                    original = true;
                    do {
                        System.out.println("Do you follow more subjects?");
                        String arrayAnswer = answer.next();
                        if (arrayAnswer.equals("yes") || (arrayAnswer.equals("Yes"))) {
                            System.out.println("Which subject do you also follow?");
                            lesson = subput.nextLine();
                            subjects.add(lesson);
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
                    System.out.println("So you follow the subject(s) " + subjects +" is that corect?" );
                    Scanner confirm = new Scanner(System.in);
                    String verified = confirm.nextLine();
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

    void known(){

    };

    }

*/