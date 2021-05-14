package nl.hva.schoolSummary;

import java.util.ArrayList;

public class SchoolClass {

    public static final int MAX_AANTAL_STUDENTEN = 21;
    private Teacher teacher;
    private ArrayList<Student> students;
    private int year;
    private String schoolClassName;

    SchoolClass(int year, String schoolClassName, Teacher teacher, ArrayList<Student> students) {
        this.teacher = teacher;
        this.students = students;
        this.year = year;
        this.schoolClassName = schoolClassName;
    }

    public void addOneStudent(Student student){
        students.add(student);
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

    public void setStudents(ArrayList<Student> students) {
        this.students = students;
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

    public void setSchoolClassName(String schoolClassName) {
        this.schoolClassName = schoolClassName;
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

}




