import java.util.List;

public class SubjectModule {
    private List<Course> courses;
    private Project project;

    public List<Course> getCourses(){
        return courses;
    }

    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    public Project getProject(){
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}