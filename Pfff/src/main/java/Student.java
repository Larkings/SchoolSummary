import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Student extends Person implements Presence{
    private String subjectFollow;
    private int id;
    private String studentRole = "student";


    public Student(String id, String name)
    { super(name, id );
    this.setRole(studentRole);
    }

       public void learn(){
            }

        public void attending() {

        }

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
