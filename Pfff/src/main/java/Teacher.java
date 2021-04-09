import java.util.ArrayList;

public class Teacher extends Person implements Presence{

    private String subjectGiven;
    private String id;
    private boolean pass;
    private String subjectFollow;
    private boolean passed;
    private String teacherRole = "teacher";
    private static ArrayList Teachers = new ArrayList();
    public Teacher(){

    };

    public Teacher(String id) {
        super(id);
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
