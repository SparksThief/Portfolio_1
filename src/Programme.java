import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Programme {

    private List<StudyActivity> activities;
    private Set<SubjectModule> subjectModules; // Hold styr på unikke SubjectModules

    // Constructor
    public Programme() {
        this.activities = new ArrayList<>();
        this.subjectModules = new HashSet<>();
    }

    // Tilføj en aktivitet til programmet
    public void addActivity(StudyActivity activity) {
        activities.add(activity);
        if (activity instanceof Course) {
            Course course = (Course) activity;
            if (course.getSubjectModule() != null) {
                subjectModules.add(course.getSubjectModule());
            }
        } else if (activity instanceof Project) {
            Project project = (Project) activity;
            if (project.getSubjectModule() != null) {
                subjectModules.add(project.getSubjectModule());
            }
        }
    }

    // Valider om programmet er gyldigt
    public boolean isValid() {
        int projectCount = 0;
        int basicProjectCount = 0;
        int bachelorProjectCount = 0;
        int totalCourseECTS = 0;
        int basicCourseECTS = 0;

        // Gennemgå alle aktiviteter og tæl kurser og projekter
        for (StudyActivity activity : activities) {
            if (activity instanceof Project) {
                Project project = (Project) activity;
                projectCount++;

                if (project.isBachelorProject()) {
                    bachelorProjectCount++;
                } else if (project.isBasicProject()) {
                    basicProjectCount++;
                }
            } else if (activity instanceof Course) {
                Course course = (Course) activity;
                totalCourseECTS += course.getECTS();

                if (course.isBasicCourse()) {
                    basicCourseECTS += course.getECTS();
                }
            }
        }

        // Valider projekter
        boolean validProjects = projectCount == 6 && basicProjectCount == 3 && bachelorProjectCount == 1;
        if (!validProjects) {
            System.out.println("Invalid project requirements.");
        }

        // Valider kurser
        boolean validCourses = totalCourseECTS >= 50 && basicCourseECTS >= 40;
        if (!validCourses) {
            System.out.println("Invalid course requirements.");
        }

        // Valider SubjectModules
        boolean validModules = true;
        if (subjectModules.size() != 2) {
            validModules = false;
            System.out.println("You need exactly 2 subject modules, but you have " + subjectModules.size() + ".");
        }

        for (SubjectModule module : subjectModules) {
            if (module.getTotalCourseECTS() != 20 || module.getProject() == null || module.getProject().getECTS() != 15) {
                validModules = false;
                System.out.println("Each subject module must have 20 ECTS from courses and a 15 ECTS project.");
            }
        }

        return validProjects && validCourses && validModules;
    }

    public List<StudyActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<StudyActivity> activities) {
        this.activities = activities;
    }
}
