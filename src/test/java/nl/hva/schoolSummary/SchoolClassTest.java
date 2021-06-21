package nl.hva.schoolSummary;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import java.io.IOException;
import java.util.ArrayList;

class SchoolClassTest {

    @Test
    void addOneStudent() {

        ArrayList<Student> testStudents1 = new ArrayList<>();
        Teacher Johnson = new Teacher("768345", "Johnson", "Teacher", "Johnson.Thomasen@hva.nl",
                "04-05-2021", "M", "Math");
        SchoolClass K4A = new SchoolClass(2022, "K4A", Johnson, testStudents1);

        testStudents1.add(new Student("809567", "Gudo", "Student", "Gudo.Soeterik@hva.nl","M","04-05-2021","Economics"));
        testStudents1.add(new Student("678234", "Joep ", "Student", "Joep.ter.Keurs@hva.nl","M","04-05-2021","Culture"));
        testStudents1.add(new Student("742342", "Jochem", "Student", "Jochem.Ingelse@hva.nl","M","04-05-2021","Economics"));
        testStudents1.add(new Student("645432", "Robbert-Jan", "Student", "Robbert-Jan.Hamhuis@hva.nl","M","04-05-2021","Programming"));
        testStudents1.add(new Student("123264", "Laurens", "Student", "Laurens.Kunst@hva.nl","M","04-05-2021","Programming"));
        testStudents1.add(new Student("856345", "Corneel", "Student", "Corneel.Barneveld@hva.nl","M","04-05-2021","Economics"));
        testStudents1.add(new Student("577543", "Twan", "Student", "Twan.de.Chalmot@hva.nl","M","04-05-2021","Programming"));
        testStudents1.add(new Student("645675", "Wouter", "Student", "Wouter.Koot@hva.nl","M","04-05-2021","Economics"));
        testStudents1.add(new Student("809567", "Willem", "Student", "Willem.de.valk@hva.nl","M","04-05-2021","Culture"));
        testStudents1.add(new Student("768323", "Louwrens", "Student", "Louwrens.Mooiers@hva.nl","M","04-05-2021","Economics"));
        testStudents1.add(new Student("789654", "Alie", "Student", "Alie.Worst@hva.nl","M","04-05-2021","Programming"));
        testStudents1.add(new Student("809567", "Ewoud", "Student", "Ewoud.Markvoort@hva.nl","M","04-05-2021","Science"));
        testStudents1.add(new Student("809567", "Nard", "Student", "Nard.Buitenhuis@hva.nl","M","04-05-2021","Economics"));
        testStudents1.add(new Student("809567", "Iemke", "Student", "Iemke.Siemelink@hva.nl","F","04-05-2021","Culture"));
        testStudents1.add(new Student("809567", "Leonie", "Student", "Leonie.van.den.Belten@hva.nl","F","04-05-2021","Science"));
        testStudents1.add(new Student("809567", "Rosemarije", "Student", "Rosemarije.Vloedbeld@hva.nl","F","04-05-2021","Culture"));
        testStudents1.add(new Student("809567", "Eline", "Student", "Eline.Bredewold@hva.nl","F","04-05-2021","Economics"));
        testStudents1.add(new Student("809567", "Fientje", "Student", "Fientje.Lemcke@hva.nl","F","04-05-2021","Culture"));
        testStudents1.add(new Student("809567", "Valerie", "Student", "Valerie.Mooiers@hva.nl","F","04-05-2021","Programming"));
        testStudents1.add(new Student("809567", "Marjoleine", "Student", "Marjoleine.Croese@hva.nl","F","04-05-2021","Science"));
        testStudents1.add(new Student("000001", "Testkind", "Student", "Testkind.Testkind@hva.nl","F","04-05-2021","Testvak"));

        K4A = new SchoolClass(2021, "K4A", Johnson, testStudents1);

        SchoolClass finalK4A = K4A;
        Assertions.assertThrows(IOException.class, () ->{
            finalK4A.addOneStudent(new Student("000000", "Test", "Student", "Test.Test@hva.nl", "F","04-05-2021","Test"));});


    }
}