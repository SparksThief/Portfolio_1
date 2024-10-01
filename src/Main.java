import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        // Opretter et nyt bachelor program
        Programme programme = new Programme();

        /*
         * Forklaring om hvorfor vi bruger null:
         *
         * 1. Kurser og projekter, der tilhører et SubjectModule:
         *    - Når vi opretter kurser eller projekter, der tilhører et SubjectModule,
         *      skal vi bruge en reference til det specifikke SubjectModule i stedet for null.
         *      Dette er tilfældet for kurser og projekter, der er en del af modulaktiviteterne.
         *
         * 2. Grundprojekter og bachelorprojekter (uden for SubjectModules):
         *    - Projekter som grundprojekter og bachelorprojekter har ikke nogen tilknytning
         *      til et SubjectModule. Derfor bruger vi null som værdi for SubjectModule,
         *      da de ikke tilhører et modul.
         *
         * 3. Grundkurser uden for SubjectModules:
         *    - Ligesom med projekterne har grundkurser, der ikke tilhører et SubjectModule,
         *      null som SubjectModule-reference, fordi de ikke er en del af modulaktiviteterne.
         */

        // Opret to SubjectModules med kurser og et projekt i hver
        // SubjectModule 1
        SubjectModule subjectModule1 = new SubjectModule(
                new ArrayList<>(), // Tom liste til kurser, som vi tilføjer nedenfor
                new Project(false, false, null) // Projekt til modul 1 (ikke bachelor, ikke basic)
        );

        // SubjectModule 2
        SubjectModule subjectModule2 = new SubjectModule(
                new ArrayList<>(), // Tom liste til kurser, som vi tilføjer nedenfor
                new Project(false, false, null) // Projekt til modul 2 (ikke bachelor, ikke basic)
        );

        // Tilføj kurser til SubjectModule 1
        subjectModule1.getCourses().add(new Course(10, false, subjectModule1));
        subjectModule1.getCourses().add(new Course(10, false, subjectModule1));

        // Tilføj kurser til SubjectModule 2
        subjectModule2.getCourses().add(new Course(10, false, subjectModule2));
        subjectModule2.getCourses().add(new Course(10, false, subjectModule2));

        // Tilføj grundprojekter (basic projects) uden for SubjectModules
        programme.addActivity(new Project(false, true, null)); // Basic project
        programme.addActivity(new Project(false, true, null)); // Basic project
        programme.addActivity(new Project(false, true, null)); // Basic project

        // Tilføj bachelorprojekt
        programme.addActivity(new Project(true, false, null)); // Bachelor project

        // Tilføj kurser (mindst 50 point samlet, og mindst 40 point skal være grundkurser)
        programme.addActivity(new Course(10, true, null)); // Basic course
        programme.addActivity(new Course(10, true, null)); // Basic course
        programme.addActivity(new Course(10, true, null)); // Basic course
        programme.addActivity(new Course(10, true, null)); // Basic course
        programme.addActivity(new Course(10, false, null)); // Elective course (ikke basic)

        // Tilføj kurser og projekter fra SubjectModule 1 og 2 til programmet
        programme.addActivity(subjectModule1.getCourses().get(0));
        programme.addActivity(subjectModule1.getCourses().get(1));
        programme.addActivity(subjectModule1.getProject());

        programme.addActivity(subjectModule2.getCourses().get(0));
        programme.addActivity(subjectModule2.getCourses().get(1));
        programme.addActivity(subjectModule2.getProject());

        // Valider programmet og udskriv resultatet
        if (programme.isValid()) {
            System.out.println("Bachelor programme is valid");
        } else {
            System.out.println("Bachelor programme is not valid. Check requirements");
        }
    }
}
