

public class Student extends Person implements Presence{
    private String subjectFollow;
    private String studentRole = "student";



    public Student(String id)
    { super(id);
    this.setRole(studentRole);
    }

    public Student() {

    }

    public void learn(){
    }
    public void attending() { }

    public void register() {

    }

    public void setId(int id) {
        /* als studentid goed wordt ingevuld wordt de opgegegeven studentid opgeslagen.
     Mocht de studentid null zijn wordt er een nieuwe gegenereerd.
                   */
    }

    @Override
    public void introduce() {
        System.out.println("Hi, I'm a student and my name is ");;
    }



}
