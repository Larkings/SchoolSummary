package nl.hva.schoolSummary;

public class Main {

    public static void main(String[] args) {

        Questionable questionable = new Questionable();

        questionable.startQuestionnaire();

        Person c = new Student();
        Student.view(c);


    }
}
