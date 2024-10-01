import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Opretter et nyt bachelor program
        Programme programme = new Programme();

        // Opret to SubjectModules med kurser og et projekt i hver
        // SubjectModule 1
        SubjectModule subjectModule1;
        subjectModule1 = new SubjectModule(
                new ArrayList<>(), // Tom liste til kurser, som vi tilføjer nedenfor
                new Project(false, false, null) // Projekt til modul 1 (ikke bachelor, ikke basic)
        );

        // SubjectModule 2
        SubjectModule subjectModule2 = new SubjectModule(
                new ArrayList<>(), // Tom liste til kurser, som vi tilføjer nedenfor
                new Project(false, false, null) // Projekt til modul 2 (ikke bachelor, ikke basic)
        );

        // Tilføj kurser til SubjectModule 1
        for (int i = 0; i < 2; i++) {
            subjectModule1.getCourses().add(new Course(10, false, subjectModule1));
        }

        // Tilføj kurser til SubjectModule 2
        for (int i = 0; i < 2; i++) {
            subjectModule2.getCourses().add(new Course(10, false, subjectModule2));
        }

        // Tilføj grundprojekter (basic projects) uden for SubjectModules
        for (int i = 0; i < 3; i++) {
            programme.addActivity(new Project(false, true, null));
        } // Basic project

        // Tilføj bachelorprojekt
        programme.addActivity(new Project(true, false, null)); // Bachelor project

        // Tilføj kurser (mindst 50 point samlet, og mindst 40 point skal være grundkurser)
        for (int i = 0; i < 4; i++) {
            programme.addActivity(new Course(10, true, null));
        } // Basic course

        programme.addActivity(new Course(10, false, null)); // Elective course (ikke basic)

        // Tilføj kurser og projekter fra SubjectModule 1 og 2 til programmet
        for (int i = 0; i < 2; i++) {
            programme.addActivity(subjectModule1.getCourses().get(i));
        }
        programme.addActivity(subjectModule1.getProject());

        for (int i = 0; i < 2; i++) {
            programme.addActivity(subjectModule2.getCourses().get(i));
        }
        programme.addActivity(subjectModule2.getProject());

        // Valider programmet og udskriv resultatet
        if (programme.isValid()) {
            System.out.println("Bachelor programme is valid");
        } else {
            System.out.println("Bachelor programme is not valid. Check requirements");
        }
    }
}
