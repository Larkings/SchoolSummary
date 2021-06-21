package nl.hva.schoolSummary;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws Exception {
        Questionable questionable = new Questionable();

        questionable.startQuestionnaire();

        Person c = new Student();
        Student.view(c);

    }
}
