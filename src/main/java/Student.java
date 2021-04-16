package java;

public class Student extends Person implements Presence{

    public Student(String id, String name, String role, String email,String inGen, String inBirthDate, String inSub) {
        super.setId(id);
        super.setName(name);
        super.setRole(role);
        super.setEmail(email);
        super.setGender(inGen);
        super.setBirthday(inBirthDate);
        super.setSubject(inSub);
    }

    public Student() {

    }

    public static void view (Person c) {
        if (c instanceof Student) {
            Student b1 = (Student ) c;
            b1.check();
        }
    }

    public String getSubjectFollow(){
        return super.getSubject();
    }

    public void check() {
        System.out.println("Success.");
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm a student and my name is ");
    }

    @Override
    public String getSubject() {
        return "I'm following the subject: " + super.getSubject();
    }

    public void greetings(){
        System.out.println("You're ready for this schoolyear!");
    }

    @Override
    public void register() {
        System.out.println("You're registered for the new schoolyear");

    }

    ;


}
