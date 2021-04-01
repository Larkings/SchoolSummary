import javax.xml.transform.stream.StreamSource;

public class SchoolClass {

    private String schoolClassName;
    private int studentInClass;
    private Student [] students;

    public static final int MAX_AANTAL_STUDENTEN = 21;


    public SchoolClass(String schoolClassName){
        this.schoolClassName = schoolClassName;
        this.studentInClass =studentInClass;
        this.students = new Student[MAX_AANTAL_STUDENTEN];

    }

    public boolean addStudent(Student student){
        if (this.studentInClass >= this.students.length){
            return false;
        }

        this.students[this.studentInClass] = student;
        this.studentInClass++;

        return true;
    }

}



    //private String teacherName;
    //    private String studentName;
    //    private String subject;
    //
    //
    //
    //    public void lessonStart(){
    //        System.out.println("test");
    //    }
    //
    //    public String getTeacherName() {
    //        return teacherName;
    //    }
    //
    //    public String getStudentName(){
    //        return studentName;
    //    }
    //
    //
    //    public int getStudentInClass() {
    //        return studentInClass;
    //    }
    //
    //    public String getSchoolClassName() {
    //        return schoolClassName;
    //    }
    //
    //    public String setSchoolClassName(){
    //        return schoolClassName;
    //    }
    //
    //    public String getSubject(){
    //        return subject;
    //    }



