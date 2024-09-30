// Importerer List, så vi kan implementere de forskellige fagmoduler/courses.
import java.util.List;

// Tilføjer ny class med variablen courses som er en liste af typen Course, samt variablen project af typen Project
public class SubjectModule {
    private List<Course> courses;
    private Project project;

    // Getter - Giver andre klasser adgang til at læse værdien af variablen courses.
    public List<Course> getCourses() {
        return courses;
    }
    // Setter - Giver andre klasser adgang til at ændre/opdatere værdien af variablen courses.
    public void setCourses(List<Course> courses) {
        this.courses = courses;
    }

    // Getter så andre dele af programmet kan læse værdien af variablen.
    public Project getProject(){
        return project;
    }
    // Setter så andre dele af programmet kan opdatere variablen.
    public void setProject(Project project) {
        this.project = project;
    }
}