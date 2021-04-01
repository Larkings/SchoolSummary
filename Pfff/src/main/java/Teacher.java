public class Teacher extends Person implements Presence{

    private String subjectGiven;
    private String id;
    private boolean pass;
    private String subjectFollow;
    private boolean passed;
    private String teacherRole = "teacher";

    public Teacher(String id, String name) {
        super(id, name);
        this.setRole(teacherRole);
    }

    public void teach(){

    }

    public String getSubjectGiven(){
        return subjectGiven;
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm a teacher and my name is ");
    }
}
