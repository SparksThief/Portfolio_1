import java.util.List;

public class SubjectModule {
    private List<Course> courses;
    private Project project;

    // Constructor
    public SubjectModule(List<Course> courses, Project project) {
        this.courses = courses;
        this.project = project;
    }

    // Returnerer listen af kurser
    public List<Course> getCourses(){
        return courses;
    }

    // Sætter listen af kurser
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Returnerer projektet
    public Project getProject(){
        return project;
    }

    // Sætter projektet
    public void setProject(Project project) {
        this.project = project;
    }

    // Beregner samlet ECTS fra kurser i moduler
    public int getTotalCourseECTS() {
        int totalECTS = 0;
        for (Course course : courses) {
            totalECTS += course.getECTS();
        }
        return totalECTS;
    }
}
