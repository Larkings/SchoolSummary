package nl.hva.schoolSummary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

class SchoolClassTestTeacher {

    @Test
    void replaceTeacher() {

        Teacher Adam = new Teacher("776553", "Adam", "Teacher", "Adam.berends@hva.nl",
                "04-05-2021", "M", "Math");

        ArrayList<Student> testStudents2 = new ArrayList<>();

        SchoolClass K4B = new SchoolClass(2022, "K4B", Adam, testStudents2);

        testStudents2.add(new Student("809567", "Gudo", "Student", "Gudo.Soeterik@hva.nl","M","04-05-2021","Economics"));



        K4B.replaceTeacher(new Teacher("677683","Lloyd","Teacher", "lloyd.larbi@hva.nl", "01-01-1997", "M","Math"));


        Assertions.assertEquals("Lloyd", K4B.getTeacher().getName()) ;


    }
}