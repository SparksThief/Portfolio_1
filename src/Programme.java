import java.util.ArrayList;
import java.util.List;
import java.util.HashSet;
import java.util.Set;

public class Programme {

    private List<StudyActivity> activities;

    //Constructor
    // Initialiser en ArrayList, fordi et program kan indeholde mange aktiviteter
    public Programme() {
        this.activities = new ArrayList<>();
    }

    //Metode til at tilføje aktiviteter
    // Parameteren 'activity' kan enten være et course eller project
    // fordi vi bruger inheritance og arver fra StudyActivity
    public void addActivity(StudyActivity activity) {
        activities.add(activity);
    }

    // Validerer om bachelorprogrammet er gyldigt ifølge alle reglerne
    // Validerer om bachelorprogrammet er gyldigt
    public boolean isValid() {
        int projectCount = 0;
        int basicProjectCount = 0;
        int bachelorProjectCount = 0;
        int subjectModuleProjectCount = 0;
        int totalCourseECTS = 0;
        int basicCourseECTS = 0;

        Set<StudyActivity> uniqueActivities = new HashSet<>(activities);

        // Tjekker for dublikanter
        if (uniqueActivities.size() != activities.size()) {
            System.out.println("Activities found twice");
            return false;
        }

        // Gennemgå alle aktiviteter
        for (StudyActivity activity : activities) {
            if (activity instanceof Project) {
                Project project = (Project) activity;
                projectCount++;

                if (project.isBachelorProject()) {
                    bachelorProjectCount++;
                } else if (project.isBasicProject()) {
                    basicProjectCount++;
                } else {
                    subjectModuleProjectCount++;
                }
            } else if (activity instanceof Course) {
                Course course = (Course) activity;
                totalCourseECTS += course.getECTS();

                if (course.isBasicCourse()) {
                    basicCourseECTS += course.getECTS();
                }
            }
        }

// Check that the total number of projects is exactly 6
        boolean validProjects = projectCount == 6 && basicProjectCount == 3 && bachelorProjectCount == 1 && subjectModuleProjectCount == 2;

        // Check course ECTS requirements
        boolean validCourses = totalCourseECTS >= 50 && basicCourseECTS >= 40;

        if (!validProjects) {
            System.out.println("Not enough projects or projects not associated with modules");
        }
        if (!validCourses) {
            System.out.println("Not enough ECTS points. Must have at least 50 total and 40 basic.");
        }

        return validProjects && validCourses;
    }

    public List<StudyActivity> getActivities() {
        return activities;
    }

    public void setActivities(List<StudyActivity> activities) {
        this.activities = activities;
    }
}

        /*

        Yelong's gamle kode, min nye er sat oven over.

        Valideringsregler nedenunder.
        Vi tjekker om:
        - Der er 6 projekter i alt.
        - Om 3 af projekterne er grundprojekter
        - Om 1 af projekterne er bachelorprojekt

        Det kan sikkert gøres pænere, men min hjerne gik død her.
        Det med grundprojekter drillede og skulle bare have det -
        til at virke :-)

        Vi laver 2 større if/else checks, 1 for projekter og 1 for point

        boolean validProjects = true;

        if (projectCount != 6) {
            validProjects = false;
            System.out.println("You need 6 projects, but you have " + projectCount + ".");
        }

        if (basicProjectCount != 3) {
            validProjects = false;
            System.out.println("You need 3 basic projects, but you have " + basicProjectCount + ".");
        }

        if (bachelorProjectCount != 1) {
            validProjects = false;
            System.out.println("You need 1 bachelor project, but you have " + bachelorProjectCount + ".");
        }

        System.out.println("Valid projects: " + validProjects);

        // Tjek om der er mindst 50 ECTS samlet og mindst 40 ECTS fra grundkurser
        boolean validCourses = true;

        if (totalCourseECTS < 50) {
            validCourses = false;
            System.out.println("You need at least 50 ECTS from courses, but you have " + totalCourseECTS + ".");
        }

        if (basicCourseECTS < 40) {
            validCourses = false;
            System.out.println("You need at least 40 ECTS from basic courses, but you have " + basicCourseECTS + ".");
        }

        System.out.println("Valid courses: " + validCourses);

        // Hvis begge valideringer er opfyldt, returneres true, ellers false
        return validProjects && validCourses;
    }

    //Getter til at hente listen af aktiviter
    public List<StudyActivity> getActivities() {
        return activities;
    }

    //Setter til at sætte en ny liste af aktiviter
    public void setActivities(List<StudyActivity> activities) {
        this.activities = activities;
    }
} */