import java.util.List;

// Tilføjer ny class som indeholder en liste over courses og variablen project.
public class SubjectModule {
    private List<Course> courses;
    private Project project;

    public void SetCourses(List<Course> courses) {
        int totalECTS = courses.stream().mapToInt(Course::getECTS).sum();
        if (totalECTS !=20) {
            throw new IllegalArgumentException("A subject module must have exactly 20 ECTS in courses.");
        }
        this.courses = courses;
    }

    public void SetProject(Project project) {
        if (project.getECTS() !=15) {
            throw new IllegalArgumentException("A subject module must have exactly 15 ECTS in projects.");
        }
        this.project = project;
    }
}