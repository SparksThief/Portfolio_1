import org.junit.jupiter.api.Test; // Korrekt import af Test annotation
import static org.junit.jupiter.api.Assertions.assertTrue; // Korrekt import af assertTrue
import static org.junit.jupiter.api.Assertions.assertFalse; // Korrekt import af assertFalse;

class MainTest1 {

    @Test
    void testValidProgram() {
        // Test af et gyldigt program med alle nødvendige komponenter
        Programme programme = new Programme();

        // Tilføj basiskurser og et almindeligt kursus
        programme.addActivity(new Course(10, true)); // Basic course
        programme.addActivity(new Course(10, true)); // Basic course
        programme.addActivity(new Course(10, true)); // Basic course
        programme.addActivity(new Course(10, true)); // Basic course
        programme.addActivity(new Course(10, false)); // Non-basic course

        // Tilføj projekter
        programme.addActivity(new Project(false, true)); // Basic project
        programme.addActivity(new Project(false, true)); // Basic project
        programme.addActivity(new Project(false, true)); // Basic project
        programme.addActivity(new Project(false, false)); // Almindeligt projekt
        programme.addActivity(new Project(false, false)); // Almindeligt projekt
        programme.addActivity(new Project(true, false)); // Bachelor project

        // Validere at programmet er gyldigt
        assertTrue(programme.isValid(), "Programmet burde være gyldigt.");
    }


    @Test
    void testInvalidProgramMissingECTS() {
        // Test af et program med utilstrækkelige ECTS-point
        Programme programme = new Programme();
        programme.addActivity(new Course(5, true)); // Ikke nok ECTS-point

        // Validere at programmet er ugyldigt
        assertFalse(programme.isValid(), "Programmet burde være ugyldigt pga. manglende ECTS.");
    }

    @Test
    void testDuplicateActivities() {
        // Test af et program med duplikataktiviteter
        Programme programme = new Programme();
        StudyActivity activity = new Course(10, true);
        programme.addActivity(activity);
        programme.addActivity(activity); // Tilføjer samme aktivitet igen.

        // Validere at programmet er ugyldigt pga. duplikater
        assertFalse(programme.isValid(), "Programmet burde være ugyldigt pga. duplikataktiviteter.");
    }

    @Test
    void testInvalidNumberOfProjects() {
        // Test af program med forkert antal projekter
        Programme programme = new Programme();
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Project(false, true)); // Basic Project
        programme.addActivity(new Project(true, false)); // Bachelor Project

        // Validere at programmet er ugyldigt pga. manglende projekter
        assertFalse(programme.isValid(), "Programmet burde være ugyldigt pga. forkert antal projekter.");
    }

    @Test
    void testMinimumRequiredBasicCourses() {
        // Test af program med for få basiskurser
        Programme programme = new Programme();
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Project(false, true)); // Basic Project
        programme.addActivity(new Project(true, false)); // Bachelor Project

        // Validere at programmet er ugyldigt, da det ikke opfylder minimums-ECTS krav for basiskurser
        assertFalse(programme.isValid(), "Programmet burde være ugyldigt pga. manglende basiskurser.");
    }
}
