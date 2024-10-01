// File: ProgrammeTest.java
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;

public class ProgrammeTest {

    @Test
    public void testProgrammeValidationValidScenario() {
        // Create subject modules with courses
        List<Course> coursesModule1 = new ArrayList<>();
        coursesModule1.add(new Course(10, false, null)); // Non-basic course
        coursesModule1.add(new Course(10, false, null)); // Non-basic course
        Project projectModule1 = new Project(false, false, null);

        SubjectModule subjectModule1 = new SubjectModule(coursesModule1, projectModule1);

        List<Course> coursesModule2 = new ArrayList<>();
        coursesModule2.add(new Course(10, false, null)); // Non-basic course
        coursesModule2.add(new Course(10, false, null)); // Non-basic course
        Project projectModule2 = new Project(false, false, null);

        SubjectModule subjectModule2 = new SubjectModule(coursesModule2, projectModule2);

        // Create the programme
        Programme programme = new Programme();

        // Add subject modules' activities
        programme.addActivity(subjectModule1.getCourses().get(0));
        programme.addActivity(subjectModule1.getCourses().get(1));
        programme.addActivity(subjectModule1.getProject());

        programme.addActivity(subjectModule2.getCourses().get(0));
        programme.addActivity(subjectModule2.getCourses().get(1));
        programme.addActivity(subjectModule2.getProject());

        // Add basic courses to the programme
        programme.addActivity(new Course(10, true, null)); // Basic course
        programme.addActivity(new Course(10, true, null)); // Basic course
        programme.addActivity(new Course(10, true, null)); // Basic course
        programme.addActivity(new Course(10, true, null)); // Basic course

        // Add a bachelor project
        programme.addActivity(new Project(true, false, null)); // Bachelor project

        // Add basic projects (should be 3 in total)
        programme.addActivity(new Project(false, true, null)); // Basic project
        programme.addActivity(new Project(false, true, null)); // Basic project
        programme.addActivity(new Project(false, true, null)); // Basic project

        // Validate the programme
        assertTrue(programme.isValid(), "Programme should be valid");
    }

    @Test
    public void testInvalidProgrammeNotEnoughBasicCourses() {
        Programme programme = new Programme();

        // Add courses but not enough basic ECTS (only 30 instead of required 40)
        programme.addActivity(new Course(10, true, null));
        programme.addActivity(new Course(10, true, null));
        programme.addActivity(new Course(10, false, null)); // Non-basic course

        assertFalse(programme.isValid(), "Programme should be invalid due to insufficient basic course ECTS");
    }

    @Test
    public void testInvalidProgrammeIncorrectNumberOfProjects() {
        Programme programme = new Programme();

        // Add projects, but missing one basic project
        programme.addActivity(new Project(false, true, null)); // Basic project
        programme.addActivity(new Project(true, false, null)); // Bachelor project

        assertFalse(programme.isValid(), "Programme should be invalid due to incorrect number of projects");
    }

    @Test
    public void testSubjectModuleValidation() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(10, false, null));
        courses.add(new Course(10, false, null));
        Project project = new Project(false, false, null);

        SubjectModule subjectModule = new SubjectModule(courses, project);

        assertEquals(20, subjectModule.getTotalCourseECTS(), "Total ECTS for courses should be 20");
        assertNotNull(subjectModule.getProject(), "Subject module should have a project");
    }

    @Test
    public void testInvalidSubjectModuleECTS() {
        List<Course> courses = new ArrayList<>();
        courses.add(new Course(5, false, null)); // Not enough ECTS
        courses.add(new Course(5, false, null)); // Not enough ECTS
        Project project = new Project(false, false, null);

        SubjectModule subjectModule = new SubjectModule(courses, project);
        Programme programme = new Programme();

        // Adding invalid subject module to the programme
        programme.addActivity(subjectModule.getCourses().get(0));
        programme.addActivity(subjectModule.getCourses().get(1));
        programme.addActivity(subjectModule.getProject());

        assertFalse(programme.isValid(), "Programme should be invalid due to insufficient subject module ECTS");
    }
}