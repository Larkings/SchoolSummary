package nl.hva.schoolSummary;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import java.util.function.Function;
import java.io.File;
import java.io.IOException;
import java.io.FileWriter;
import io.javalin.Javalin;


public class Questionable {
    public SchoolClass H3B;

    public Questionable() {
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
        students1.add(new Student("768323", "Louwrens", "Student", "Louwrens.Mooiers@hva.nl","M","04-05-2021","Economics"));
        students1.add(new Student("789654", "Alie", "Student", "Alie.Worst@hva.nl","M","04-05-2021","Programming"));
        students1.add(new Student("231675", "Ewoud", "Student", "Ewoud.Markvoort@hva.nl","M","04-05-2021","Science"));
        students1.add(new Student("786423", "Nard", "Student", "Nard.Buitenhuis@hva.nl","M","04-05-2021","Economics"));
        students1.add(new Student("634534", "Iemke", "Student", "Iemke.Siemelink@hva.nl","F","04-05-2021","Culture"));
        students1.add(new Student("967885", "Leonie", "Student", "Leonie.van.den.Belten@hva.nl","F","04-05-2021","Science"));
        students1.add(new Student("956756", "Rosemarije", "Student", "Rosemarije.Vloedbeld@hva.nl","F","04-05-2021","Culture"));
        students1.add(new Student("345375", "Eline", "Student", "Eline.Bredewold@hva.nl","F","04-05-2021","Economics"));
        students1.add(new Student("745643", "Fientje", "Student", "Fientje.Lemcke@hva.nl","F","04-05-2021","Culture"));
        students1.add(new Student("637453", "Valerie", "Student", "Valerie.Mooiers@hva.nl","F","04-05-2021","Programming"));
        students1.add(new Student("846564", "Marjoleine", "Student", "Marjoleine.Croese@hva.nl","F","04-05-2021","Science"));

        H3B = new SchoolClass(2021, "H3B", romeo, students1);

        Javalin app = Javalin.create().start(7000);
        app.get("/", ctx -> ctx.result(currentClass()));
        
    }

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

    public void startQuestionnaire() {
        System.out.println("What is your ID, otherwise type in 'none'");
        String inID = new Scanner(System.in).nextLine();
        Person foundPerson = H3B.getPersonById(inID);
        if (foundPerson != null) {
            try {
                File myObj = new File("registrationForm.md");
                if (myObj.createNewFile()) {
                    System.out.println("File created: " + myObj.getName());
                    try {
                        FileWriter myWriter = new FileWriter("registrationForm.md",false);
                        myWriter.write(getExistencePerson(inID));
                        myWriter.close();
                        System.out.println("Successfully wrote to the file.");
                        System.out.println();
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
                } else {
                    System.out.println("File already exists.");
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

    private void createPersonQuestionnaire(){
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

        System.out.println("Are you a teacher or a student?");
        String intype = new Scanner(System.in).nextLine();


        switch (intype) {
            case "Teacher", "teacher" -> {

                System.out.println("What subject do you teach?");
                String inteach = new Scanner(System.in).nextLine();

                getRandomNumberString();
                H3B.replaceTeacher(new Teacher(getRandomNumberString(), inName, intype, inMail, inBirthDate, inGen,inteach));

                try {
                    File myObj = new File("registrationForm.md");
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                        try {
                            FileWriter myWriter = new FileWriter("registrationForm.md",false);
                            myWriter.write(showTeacherInfo());
                            myWriter.close();
                            System.out.println("Successfully wrote to the file.");
                            System.out.println();
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
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }
            }


            case "Student", "student" -> {

                System.out.println("What subject do you follow?");
                String inSub = new Scanner(System.in).nextLine();


                getRandomNumberString();
                H3B.addOneStudent(new Student(getRandomNumberString(), inName, intype, inMail,inGen, inBirthDate, inSub));

                try {
                    File myObj = new File("registrationForm.md");
                    if (myObj.createNewFile()) {
                        System.out.println("File created: " + myObj.getName());
                        try {
                            FileWriter myWriter = new FileWriter("registrationForm.md",false);
                            myWriter.write(showStudentInfo());
                            myWriter.close();
                            System.out.println("Successfully wrote to the file.");
                            System.out.println();
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
                    } else {
                        System.out.println("File already exists.");
                    }
                } catch (IOException e) {
                    System.out.println("An error occurred.");
                    e.printStackTrace();
                }



            }

        }
    }

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

    private String showStudentsInClass(){

        StringBuilder result = new StringBuilder();
        for (int i = 0; i <(H3B.getStudents().size()-1); i++ )
            result.append(H3B.getStudents().get(i).getName()).append(", ").append(H3B.getStudents().get(i).getEmail()).append(".\n");
        return result.toString();
    }

    private String currentClass(){
        StringBuilder sb = new StringBuilder();

        sb.append("This is class ").append(H3B.getSchoolClassName()).append(" for the year ").append(H3B.getYear()).append(". \n");
        sb.append(numberAmountClass.apply(H3B.getStudents().size()));
        sb.append("The teacher of ").append(H3B.getSchoolClassName()).append(" is ").append(H3B.getTeacher().getName()).append(".\n");
        sb.append("And here are the students of the class ").append(H3B.getSchoolClassName()).append(" accompanied with their mail: \n");
        sb.append("\n");
        sb.append(showStudentsInClass());

        return sb.toString();
    }

    public static Function<Integer, String> numberAmountClass = (number) -> {
        if (number %2 ==0){
            return "The amount of students in class H3B is "+ number + ", that is an even number.";
        } else {
            return "The amount of students in class H3B is "+ number + ", that is an odd number.";
        }
    };

}
