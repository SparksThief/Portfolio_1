import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ProgrammeTest {

    @Test
    // Tester at en ny Programme instance initialiserer sin liste af aktiviteter korrekt.
    void testProgrammeInitialization() {
        Programme programme = new Programme();
        assertNotNull(programme.getActivities(), "Activities list should be initialized.");
        assertEquals(0, programme.getActivities().size(), "Activities list should initially be empty.");
    }

    @Test
    /*
     Tester tilføjelse af Project til et Programme.
     Bekræfter, at antallet af aktiviteter stiger med en.
     Tjekker aktivitet af typen Project.
     Verificerer at programmet ikke er et bachelorprojekt men et basisprojekt.
    */
    void testAddProject() {
        Programme programme = new Programme();
        Project project = new Project(false, true); // Tilføjer et basisprojekt.
        programme.addActivity(project);

        assertEquals(1, programme.getActivities().size(), "Programme should have one activity after adding a project.");
        assertTrue(programme.getActivities().get(0) instanceof Project, "The first activity should be a Project.");
        assertFalse(((Project)programme.getActivities().get(0)).isBachelorProject(), "Project should not be a bachelor project.");
        assertTrue(((Project)programme.getActivities().get(0)).isBasicProject(), "Project should be a basic project.");
    }

    @Test
    /*
     Tester tilføjelse af et Course til et Programme.
     Bekræfter, at aktiviteten er en Course med 10 ECTS point.
     Verificerer, at kurset er et basiskursus.
    */
    void testAddCourse() {
        Programme programme = new Programme();
        Course course = new Course(10, true); // Adding a basic course with 10 ECTS.
        programme.addActivity(course);

        assertEquals(1, programme.getActivities().size(), "Programme should have one activity after adding a course.");
        assertTrue(programme.getActivities().get(0) instanceof Course, "The first activity should be a Course.");
        assertEquals(10, ((Course)programme.getActivities().get(0)).getECTS(), "Course should have 10 ECTS.");
        assertTrue(((Course)programme.getActivities().get(0)).isBasicCourse(), "Course should be a basic course.");
    }

    @Test
    // Tester at Programme bliver betragtet som gyldigt, hvis der er nok projekter og kurser.
    void testValidProgramme() {
        Programme programme = new Programme();
        // Tilføjer 3 basisprojekter, 2 vilkårlige projekter, og 1 bachelorprojekt.
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(true, false));
        // Tilføjer 4 basiskurser, 1 valgkursus som er et basiskursus, og 4 vilkårlige kurser, hvilket opfylder ECTS kravet.
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));
        // Bekræfter, at isValid() returnerer true.
        assertTrue(programme.isValid(), "The programme should be valid with the correct number of projects and ECTS points.");
    }

    @Test
    // Tester, at et Programme bliver betragtet som ugyldigt, hvis der er for få projekter.
    void testInvalidProgrammeDueToProjects() {
        Programme programme = new Programme();

        // Tilføjer 2 basisprojekter, 2 vilkårlige og 1 bachelorprojekt (5/6).
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(true, false));

        // Tilføjer 4 basiskurser, 1 valgkursus og 4 vilkårlige, så programmets ECTS af kurser svarer til 90 ECTS.
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));

        // Bekræfter, at isValid() returnerer false på grund af manglende projekter.
        assertFalse(programme.isValid(), "The programme should be invalid due to insufficient basic projects.");
    }

    @Test
    // Tester, at Programmet bliver betragtet som ugyldigt, hvis der ikke er nok ECTS point.
    void testInvalidProgrammeDueToECTS() {
        Programme programme = new Programme();
        // Tilføjer alle 6 nødvendige projekter
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(true, false));

        // Tilføjer kun to kurser med 10 ECTS point hver (total < 90 ECTS).
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));

        // Bekræfter, at isValid() returnerer false på grund af utilstrækkelige ECTS point.
        assertFalse(programme.isValid(), "The programme should be invalid due to insufficient total ECTS points.");
    }

    @Test
    // Tester tilføjelse og fjernelse af en aktivitet i Programme.
    void testAddAndRemove() {
        Programme programme = new Programme();
        // Tilføjer et Course og tjekker, at aktiviteten tilføjes korrekt.
        Course course = new Course(10, true);
        programme.addActivity(course);
        assertEquals(1, programme.getActivities().size(), "Programme should have one activity after adding a course.");

        programme.setActivities(new ArrayList<>());
        assertEquals(0, programme.getActivities().size(), "Programme should have no activities after removal.");
    }
}