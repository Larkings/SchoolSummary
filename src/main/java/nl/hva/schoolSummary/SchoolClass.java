package nl.hva.schoolSummary;

import java.io.IOException;
import java.util.ArrayList;

public class SchoolClass {

    public static final int MAX_AANTAL_STUDENTEN = 21;
    private Teacher teacher;
    private final ArrayList<Student> students;
    private ArrayList<Student> students2;
    private int year;
    private final String schoolClassName;
    public ReserveClass H3B_reserves;

    public SchoolClass(int year, String schoolClassName, Teacher teacher, ArrayList<Student> students) {
        this.teacher = teacher;
        this.students = students;
        this.year = year;
        this.schoolClassName = schoolClassName;
    }

    /**
     * The addOneStudent method will ad a new student to the class in case there is still a spot left.
     * In case there isn't a spot left the student will be added to the reserve class which is a shortlist in case before the start of the year somebody decides to not attend the class.
     * Otherwise you'll automatically be added to the schoolclass for next year.
     */

    public void addOneStudent(Student student) throws Exception {
        if (students.size() >= MAX_AANTAL_STUDENTEN ){
            StringBuilder sb = new StringBuilder();
            sb.append(MAX_AANTAL_STUDENTEN);
            ArrayList<Student> students2 = new ArrayList<>();
            this.students2 = students2;
            students2.add(student);
            H3B_reserves = new ReserveClass (getYear(),getSchoolClassName()+" Reserve",getTeacher(),getStudents2());
           throw new IOException ("There are currently "+ sb +" students in the class, the class is full. \n"+
                   "You'll be added to "+H3B_reserves.getSchoolClassName()+".\n");
        } else{
            students.add(student);
        }
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void replaceTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public ArrayList<Student> getStudents() {
        return students;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getSchoolClassName() {
        return schoolClassName;
    }

    public Person getPersonById(String inID){
        Person foundPerson = null;

        ArrayList<Person> persons = new ArrayList<>();
        persons.add(this.teacher);
        persons.addAll(this.students);

        for (Person person : persons) {
            if (person.getId().equals(inID)) {
                foundPerson = person;
            }
        }
        return foundPerson;
    }

    public ArrayList<Student> getStudents2() {
        return students2;
    }

}




