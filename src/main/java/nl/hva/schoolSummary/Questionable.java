package nl.hva.schoolSummary;

import java.io.FileNotFoundException;
import java.util.*;
import java.util.function.Function;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import java.util.stream.Collectors;
import io.javalin.Javalin;
import io.javalin.http.Context;
import org.jetbrains.annotations.NotNull;

public class Questionable {

    /**
     * Here the code starts with listening on de localhost on port 7000 while the schoolclass is created and the students are added to the class.
     * You'll be able to see who is in the class and how many males or females there are in the class.
     */

    Javalin app = Javalin.create().start(7000);

    public SchoolClass H3B;

    public Questionable() throws Exception {

        Teacher romeo = new Teacher("768345", "Romeo", "Teacher", "Romeo.Julianas@hva.nl",
                "04-05-2021", "M", "Math");

        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student("809567", "Gudo", "Student", "Gudo.Soeterik@hva.nl","M","04-05-2021","Economics"));
        students.add(new Student("678234", "Joep ", "Student", "Joep.ter.Keurs@hva.nl","M","04-05-2021","Culture"));
        students.add(new Student("742342", "Jochem", "Student", "Jochem.Ingelse@hva.nl","M","04-05-2021","Economics"));
        students.add(new Student("645432", "Robbert-Jan", "Student", "Robbert-Jan.Hamhuis@hva.nl","M","04-05-2021","Programming"));
        students.add(new Student("123264", "Laurens", "Student", "Laurens.Kunst@hva.nl","M","04-05-2021","Programming"));
        students.add(new Student("856345", "Corneel", "Student", "Corneel.Barneveld@hva.nl","M","04-05-2021","Economics"));
        students.add(new Student("577543", "Twan", "Student", "Twan.de.Chalmot@hva.nl","M","04-05-2021","Programming"));
        students.add(new Student("645675", "Wouter", "Student", "Wouter.Koot@hva.nl","M","04-05-2021","Economics"));
        students.add(new Student("809564", "Willem", "Student", "Willem.de.valk@hva.nl","M","04-05-2021","Culture"));
        students.add(new Student("768323", "Louwrens", "Student", "Louwrens.Mooiers@hva.nl","M","04-05-2021","Economics"));
        students.add(new Student("789654", "Alie", "Student", "Alie.Worst@hva.nl","M","04-05-2021","Programming"));
        students.add(new Student("231675", "Ewoud", "Student", "Ewoud.Markvoort@hva.nl","M","04-05-2021","Science"));
        students.add(new Student("786423", "Nard", "Student", "Nard.Buitenhuis@hva.nl","M","04-05-2021","Economics"));
        students.add(new Student("634534", "Iemke", "Student", "Iemke.Siemelink@hva.nl","F","04-05-2021","Culture"));
        students.add(new Student("967885", "Leonie", "Student", "Leonie.van.den.Belten@hva.nl","F","04-05-2021","Science"));
        students.add(new Student("956756", "Rosemarije", "Student", "Rosemarije.Vloedbeld@hva.nl","F","04-05-2021","Culture"));
        students.add(new Student("345375", "Eline", "Student", "Eline.Bredewold@hva.nl","F","04-05-2021","Economics"));
        students.add(new Student("745643", "Fientje", "Student", "Fientje.Lemcke@hva.nl","F","04-05-2021","Culture"));
        students.add(new Student("637453", "Valerie", "Student", "Valerie.Mooiers@hva.nl","F","04-05-2021","Programming"));
        students.add(new Student("846564", "Marjoleine", "Student", "Marjoleine.Croese@hva.nl","F","04-05-2021","Science"));


        H3B = new SchoolClass(2021, "H3B", romeo, students);

        app.get("/", ctx -> ctx.result(currentClass()));

        System.out.println("Welcome to the repeaters class "+ H3B.getSchoolClassName()+ "\n");

        System.out.println("You can check the information about schoolclass "+H3B.getSchoolClassName()+" online on http://localhost:7000/.");


        List <String> femaleStudentsID = students.stream()
                .filter(Student -> Student.getGender().equals("F"))
                .map(Person::getId )
                .collect(Collectors.toList());

        List <String> femaleStudentsName = students.stream()
                .filter(Student -> Student.getGender().equals("F"))
                .map(Person::getName)
                .collect(Collectors.toList());

        List <String> femaleStudentsMail = students.stream()
                .filter(Student -> Student.getGender().equals("F"))
                .map(Person::getEmail )
                .collect(Collectors.toList());

        List <String> maleStudentsID = students.stream()
                .filter(Student -> Student.getGender().equals("M"))
                .map(Person::getId)
                .collect(Collectors.toList());

        List <String> maleStudentsName = students.stream()
                .filter(Student -> Student.getGender().equals("M"))
                .map(Person::getName)
                .collect(Collectors.toList());

        List <String> maleStudentsMail = students.stream()
                .filter(Student -> Student.getGender().equals("M"))
                .map(Person::getEmail)
                .collect(Collectors.toList());


        Function<List, Integer> femaleSize = List::size;

        Integer femaleNumber = femaleSize.apply(femaleStudentsID);

        Function<List, Integer> maleSize = List::size;

        Integer maleNumber = maleSize.apply(maleStudentsID);


        app.get("/females", ctx -> ctx.result(listStringifyerFemale(showinfo(femaleStudentsID, femaleStudentsName,femaleStudentsMail))));
        System.out.println("You can find the names of the "+ femaleNumber+" female students in the current class on http://localhost:7000/females.");

        app.get("/males", ctx -> ctx.result(listStringifyerMale(showinfo(maleStudentsID, maleStudentsName,maleStudentsMail))));
        System.out.println("You can find the names of the "+ maleNumber+ " male students in the current class on http://localhost:7000/males."+ "\n");

        System.out.println("To registrate or to check your info follow the steps below: ");
    }

    @NotNull
    private String listStringifyerMale(String s){
        StringBuilder sb = new StringBuilder();

        sb.append("Here is a summary of all the males students in : ").append(H3B.getSchoolClassName()).append(".\n");
        sb.append("\n");
        sb.append(s);



        return sb.toString();
    }

    @NotNull
    private String listStringifyerFemale(String s){
        StringBuilder sb = new StringBuilder();

        sb.append("Here is a summary of all the females students in : ").append(H3B.getSchoolClassName()).append(".\n");
        sb.append("\n");
        sb.append(s);


        return sb.toString();
    }

    @NotNull
    private String showinfo(@NotNull List l, List e, List s){
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <(l.size()); i++ )
            result.append(l.get(i)).append(", ").append(e.get(i)).append(", ").append(s.get(i)).append("\n");
        return result.toString();
    }

    /**
     * At this point you'll get the choice to either see your information as a existing student or teacher or register as a new student or teacher for the class H3B.
     */

    @NotNull
    private String getExistencePerson(String s) {
        StringBuilder sb = new StringBuilder();

        sb.append("Here is a summary:").append(".\n");
        sb.append("\n");
        sb.append("Hi ").append(H3B.getPersonById(s).getName()).append(".\n");
        sb.append("The class you're in is ").append(H3B.getSchoolClassName()).append(".\n");
        sb.append("You're a: ").append(H3B.getPersonById(s).getRole()).append(".\n");
        sb.append("Your birthdate is: ").append(H3B.getPersonById(s).getBirthday()).append(".\n");
        sb.append(H3B.getPersonById(s).getSubject()).append(".\n");
        sb.append("\n");
        sb.append(numberAmountClass.apply(H3B.getStudents().size())).append(".\n");
        sb.append("Here are the students in class ").append(H3B.getSchoolClassName()).append(".\n");
        sb.append("\n");
        sb.append(showStudentsInClass());

        return sb.toString();
    }

    public void startQuestionnaire() throws Exception {
        System.out.println("What is your ID, otherwise type in 'none' to start te registration process");
        String inID = new Scanner(System.in).nextLine();
        Person foundPerson = H3B.getPersonById(inID);
        if (foundPerson != null) {
            try {
                FileWriter myWriter = new FileWriter("registrationForm.md");
                myWriter.write(getExistencePerson(inID));
                myWriter.close();
                System.out.println("Successfully wrote to the file.");
                System.out.println();
                app.get("/me", ctx -> ctx.result(getExistencePerson(inID)));
                System.out.println("You can check your information online on http://localhost:7000/me");
                try {
                    File readMe = new File("registrationForm.md");
                    Scanner myReader = new Scanner(readMe);
                    while (myReader.hasNextLine()) {
                        String data = myReader.nextLine();
                        System.out.println(data);
                    }
                    myReader.close();
                } catch (FileNotFoundException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
            System.out.println();
        } else {
            System.out.println("Your ID is not known to us in the system");
            System.out.println("Let's registrate");
            createPersonQuestionnaire();
        }
    }

    private static String getRandomNumberString(){
        Random rand = new Random();
        int number = rand.nextInt(999999);
        return String.format("%06d", number);
    }

    /**
     *At this point you are entering the registration part as a new addition to the class.
     *
     */

    private void createPersonQuestionnaire() throws Exception {
        System.out.println("What is your gender?");
        String inGen = new Scanner(System.in).nextLine();

        System.out.println("What is your name?");
        String inName = new Scanner(System.in).nextLine();

        try{
            System.out.println("What year is it?");
            int inyear = new Scanner(System.in).nextInt();
            H3B.setYear(inyear);
        } catch (Exception e){
            System.out.println("You can only type numbers!");
            H3B.setYear(H3B.getYear());
        }

        System.out.println("What is your mail?");
        String inMail = new Scanner(System.in).nextLine();

        System.out.println("What is your birthdate?");
        String inBirthDate = new Scanner(System.in).nextLine();

        /**
         * This is a point where you have to choose if you want to register as a teacher or student for the class.
         * Depending on what you'll choose you will be added to the class, as either a teacher or student.
         */

        System.out.println("Are you a teacher or a student?");
        String intype = new Scanner(System.in).nextLine();


        switch (intype) {
            case "Teacher", "teacher" -> {

                System.out.println("What subject do you teach?");
                String inteach = new Scanner(System.in).nextLine();

                getRandomNumberString();
                H3B.replaceTeacher(new Teacher(getRandomNumberString(), inName, intype, inMail, inBirthDate, inGen,inteach));

                /**
                 * After you have chosen the option teacher a markdown file will be created with your information as a teacher and about the class.
                 * You'll also be provided with a link which will display your information.
                 */
                try {
                    FileWriter myWriter = new FileWriter("registrationForm.md",false);
                    myWriter.write(showTeacherInfo());
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                    System.out.println();
                    app.get("/me", ctx -> ctx.result(showTeacherInfo()));
                    System.out.println("You can check your information online on http://localhost:7000/me");
                    try {
                        File readMe = new File("registrationForm.md");
                        Scanner myReader = new Scanner(readMe);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }

            }

            /**
             * After you have chosen the option teacher a markdown file will be created with your information as a student and about the class.
             * You'll also be provided with a link which will display your information.
             * If the schoolclass is full you'll be added to the H3B reserves class which is a shortlist in case somebody decides not to attend the H3B class, otherwise you'll have to try next year.
             */

            case "Student", "student" -> {

                System.out.println("What subject do you follow?");
                String inSub = new Scanner(System.in).nextLine();


                getRandomNumberString();
                H3B.addOneStudent(new Student(getRandomNumberString(), inName, intype, inMail,inGen, inBirthDate, inSub));

                try {
                    FileWriter myWriter = new FileWriter("registrationForm.md",false);
                    myWriter.write(showStudentInfo());
                    myWriter.close();
                    System.out.println("Successfully wrote to the file.");
                    System.out.println();
                    app.get("/me", ctx -> ctx.result(showStudentInfo()));
                    System.out.println("You can check your information online on http://localhost:7000/me");
                    try {
                        File readMe = new File("registrationForm.md");
                        Scanner myReader = new Scanner(readMe);
                        while (myReader.hasNextLine()) {
                            String data = myReader.nextLine();
                            System.out.println(data);
                        }
                        myReader.close();
                    } catch (FileNotFoundException e) {
                        System.out.println("An error occurred.");
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }
        }
    }

    @NotNull
    private String showTeacherInfo(){
        StringBuilder sb = new StringBuilder();

        sb.append("Here is a summary: \n");
        sb.append("\n");
        sb.append("Hi ").append(H3B.getTeacher().getName()).append(", \n");
        sb.append("You are a: ").append(H3B.getTeacher().getRole()).append(".\n");
        sb.append("Your birthdate is: ").append(H3B.getTeacher().getBirthday()).append(".\n");
        sb.append("You are a: ").append(H3B.getTeacher().getGender()).append(".\n");
        sb.append("Your mail-address is: ").append(H3B.getTeacher().getEmail()).append(".\n");
        sb.append("Your teacherID is: ").append(H3B.getTeacher().getId()).append(".\n");
        sb.append(H3B.getTeacher().getSubject()).append(".\n");
        sb.append(H3B.getTeacher().register()).append(".\n");
        sb.append("\n");
        sb.append("You have been added to the class and replaced the teacher of ").append(H3B.getSchoolClassName()).append(" for the year ").append(H3B.getYear()).append(". \n");
        sb.append(numberAmountClass.apply(H3B.getStudents().size()));
        sb.append("The teacher of ").append(H3B.getSchoolClassName()).append(" is ").append(H3B.getTeacher().getName()).append(".\n");
        sb.append("And here are the students of the class ").append(H3B.getSchoolClassName()).append(" accompanied with their mail: \n");
        sb.append("\n");
        sb.append(showStudentsInClass());
        sb.append(H3B.getTeacher().greetings()).append("\n");

        return sb.toString();
    }

    @NotNull
    private String showStudentInfo(){
        StringBuilder sb = new StringBuilder();

        sb.append("Here is a summary: \n");
        sb.append("\n");
        sb.append("Hi ").append(H3B.getStudents().get(H3B.getStudents().size() - 1).getName()).append(".\n");
        sb.append("You are a: ").append(H3B.getStudents().get(H3B.getStudents().size() - 1).getRole()).append(".\n");
        sb.append("Your birthdate is: ").append(H3B.getStudents().get(H3B.getStudents().size() - 1).getBirthday()).append(".\n");
        sb.append("You are a: ").append(H3B.getStudents().get(H3B.getStudents().size() - 1).getGender()).append(".\n");
        sb.append("Your mail-address is: ").append(H3B.getStudents().get(H3B.getStudents().size() - 1).getEmail()).append(".\n");
        sb.append("Your studentID is: ").append(H3B.getStudents().get(H3B.getStudents().size() - 1).getId()).append(".\n");
        sb.append("You follow the subjects: ").append(H3B.getStudents().get(H3B.getStudents().size() - 1).getSubjectFollow()).append(".\n");
        sb.append(H3B.getStudents().get(H3B.getStudents().size() -1).register()).append(".\n");
        sb.append("\n");
        sb.append("The class you're added to for year ").append(H3B.getYear()).append(" is ").append(H3B.getSchoolClassName()).append(".\n");
        sb.append(numberAmountClass.apply(H3B.getStudents().size())).append("\n");
        sb.append("Your teacher is: ").append(H3B.getTeacher().getName()).append(" ,and the mail of your teacher is: ").append(H3B.getTeacher().getEmail()).append(".\n");
        sb.append("And here are the other students in the same class ").append(H3B.getSchoolClassName()).append(" accompanied with their mail: ").append("\n");
        sb.append("\n");
        sb.append(showStudentsInClass());
        sb.append("\n");
        sb.append(H3B.getStudents().get(H3B.getStudents().size() -1).greetings()).append("\n");

        return sb.toString();
    }

    @NotNull
    private String showStudentsInClass(){

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <(H3B.getStudents().size()-1); i++ )
            result.append(H3B.getStudents().get(i).getName()).append(", ").append(H3B.getStudents().get(i).getEmail()).append(".\n");
        return result.toString();
    }

    @NotNull
    private String currentClass(){
        StringBuilder sb = new StringBuilder();

        sb.append("This is class ").append(H3B.getSchoolClassName()).append(" for the year ").append(H3B.getYear()).append(". \n");
        sb.append(numberAmountClass.apply(H3B.getStudents().size())).append("\n");
        sb.append("The teacher of ").append(H3B.getSchoolClassName()).append(" is ").append(H3B.getTeacher().getName()).append(".\n");
        sb.append("And here are the students of the class ").append(H3B.getSchoolClassName()).append(" accompanied with their mail: \n");
        sb.append("\n");
        sb.append(showStudentsInClass());

        return sb.toString();
    }

    public static Function<Integer, String> numberAmountClass = number -> {
        if (number %2 ==0){
            return "The amount of students in class H3B is "+ number + ", that is an even number.";
        } else {
            return "The amount of students in class H3B is "+ number + ", that is an odd number.";
        }
    };


}
