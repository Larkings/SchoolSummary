package java;

public class Teacher extends Person implements Presence{

    public Teacher(String id, String name, String role, String email, String birthDate, String gender, String subjectTaught) {
        super.setId(id);
        super.setName(name);
        super.setRole(role);
        super.setEmail(email);
        super.setGender(gender);
        super.setBirthday(birthDate);
        super.setSubject(subjectTaught);
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm a teacher and my name is ");
    }

    @Override
    public String getSubject() {
        return "I'm teaching the subject: " + super.getSubject();
    }

    public void greetings(){
        System.out.println("You're ready for this schoolyear!");
    }

    @Override
    public void register() {
        System.out.println("You're registered for the new schoolkids");
    }

    ;

}
