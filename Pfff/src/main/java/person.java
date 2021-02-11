import java.util.Scanner;

public class person {
    public static String name;
    public static int age;
    public static String answer;

    public void begin() {
        String state;
        boolean x = false;
        Scanner nameput = new Scanner(System.in);
        System.out.println("Hello, this is a Classsummary program where you can see your information about your class " +
                "and subjects you follow.");
        System.out.println("Could you tell me your name?");
        name = nameput.nextLine();
        Scanner ageput = new Scanner(System.in);
        System.out.println("Hello " + name);

        do {
            System.out.println("Are you new?");
            Scanner answerinput = new Scanner(System.in);
            answer = answerinput.nextLine();
            switch (answer) {
                case "yes", "Yes", "YEs", "YES", "yES" -> {
                    System.out.println("What is your age");
                    age = ageput.nextInt();
                    System.out.println("So your name is "+ name +" and you're "+ age + " years old.");
                    do {
                        System.out.println("Are you a teacher of student?");
                        Scanner yesStatePut = new Scanner(System.in);
                        state = yesStatePut.nextLine();
                        switch (state) {
                            case "Teacher", "teacher" -> {
                                teacher teacher = new teacher();
                                teacher.freshstart();
                                x = true;
                            }
                            case "Student", "student" -> {
                                student student = new student();
                                student.start();
                                x = true;
                            }
                            default -> System.out.println("Still waiting for the right answer bruv, why are you doubting. Just say yes or no.");
                        }
                    }
                    while (!x);

                }
                case "no", "No", "NO", "nO" -> {
                    do {
                        System.out.println("Are you a teacher of student?");
                        Scanner yesStatePut = new Scanner(System.in);
                        state = yesStatePut.nextLine();
                        switch (state) {
                            case "Teacher", "teacher" -> {
                                System.out.println("Let's show your classes and students");
                                for (int i=0; i<5; i++){
                                    System.out.println("loading...");
                                }
                                x = true;

                            }
                            case "Student", "student" -> {

                                System.out.println("Let's show your summary");
                                for (int i=0; i<5; i++){
                                    System.out.println("loading...");
                                }
                                x = true;
                            }
                            default -> System.out.println("Still waiting for the right answer bruv, why are you doubting. Just say yes or no.");
                        }
                    }
                    while (!x);

                    x = true;
                }
                default -> System.out.println("Still waiting for the right answer bruv, why are you doubting. Just say yes or no.");
            }
        }
        while (!x);

    }
}