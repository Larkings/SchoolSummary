

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


    public String getSubjectFollow(){
        return super.getSubject();
    };

    @Override
    public void introduce() {
        System.out.println("Hi, I'm a student and my name is ");;
    }



}
