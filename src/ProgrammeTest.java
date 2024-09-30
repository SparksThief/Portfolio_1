import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

public class ProgrammeTest {

    @Test
    void testProgrammeInitialization() {
        Programme programme = new Programme();
        assertNotNull(programme.getActivities(), "Activities list should be initialized.");
        assertEquals(0, programme.getActivities().size(), "Activities list should initially be empty.");
    }

    @Test
    void testAddProject() {
        Programme programme = new Programme();
        Project project = new Project(false, true); // Adding a basic project
        programme.addActivity(project);

        assertEquals(1, programme.getActivities().size(), "Programme should have one activity after adding a project.");
        assertTrue(programme.getActivities().get(0) instanceof Project, "The first activity should be a Project.");
        assertFalse(((Project)programme.getActivities().get(0)).isBachelorProject(), "Project should not be a bachelor project.");
        assertTrue(((Project)programme.getActivities().get(0)).isBasicProject(), "Project should be a basic project.");
    }

    @Test
    void testAddCourse() {
        Programme programme = new Programme();
        Course course = new Course(10, true); // Adding a basic course with 10 ECTS
        programme.addActivity(course);

        assertEquals(1, programme.getActivities().size(), "Programme should have one activity after adding a course.");
        assertTrue(programme.getActivities().get(0) instanceof Course, "The first activity should be a Course.");
        assertEquals(10, ((Course)programme.getActivities().get(0)).getECTS(), "Course should have 10 ECTS.");
        assertTrue(((Course)programme.getActivities().get(0)).isBasicCourse(), "Course should be a basic course.");
    }

    @Test
    void testValidProgramme() {
        Programme programme = new Programme();

        // Add required projects: 3 basic, 2 non-basic, 1 bachelor
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(true, false));

        // Add courses to meet ECTS requirements: 4 basic (total 40 ECTS), 1 non-basic (10 ECTS)
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, false));

        // Validate the programme
        assertTrue(programme.isValid(), "The programme should be valid with the correct number of projects and ECTS points.");
    }

    @Test
    void testInvalidProgrammeDueToProjects() {
        Programme programme = new Programme();

        // Add insufficient basic projects
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));

        // Add other required projects
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(true, false));

        // Add valid courses
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, false));

        // Validate the programme
        assertFalse(programme.isValid(), "The programme should be invalid due to insufficient basic projects.");
    }

    @Test
    void testInvalidProgrammeDueToECTS() {
        Programme programme = new Programme();

        // Add all required projects
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(true, false));

        // Add courses with insufficient ECTS (total < 50)
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));

        // Validate the programme
        assertFalse(programme.isValid(), "The programme should be invalid due to insufficient total ECTS points.");
    }

    @Test
    void testAddAndRemove() {
        Programme programme = new Programme();

        // Add a course and remove it
        Course course = new Course(10, true);
        programme.addActivity(course);
        assertEquals(1, programme.getActivities().size(), "Programme should have one activity after adding a course.");

        // Simulate removal by setting a new list
        programme.setActivities(new ArrayList<>());
        assertEquals(0, programme.getActivities().size(), "Programme should have no activities after removal.");
    }
}