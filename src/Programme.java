// Importerer ArrayList og List, så vi kan implementere de forskellige study activities som en liste.
import java.util.ArrayList;
import java.util.List;

// Tilføjer ny class med variablen activities som er en liste af typen StudyActivity, som er en class.
public class Programme {

    private List<StudyActivity> activities;

    // Constructor
    // Initialiserer en ArrayList, fordi et program kan indeholde mange aktiviteter.
    public Programme() {
        this.activities = new ArrayList<>();
    }

    /* Metode til at tilføje aktiviteter
     Parameteren 'activity' kan enten være et course eller project fordi vi bruger inheritance
     og arver fra StudyActivity.
     */
    public void addActivity(StudyActivity activity) {
        activities.add(activity);
    }


    // Validerer om bachelorprogrammet er gyldigt
    public boolean isValid() {
        int projectCount = 0;
        int basicProjectCount = 0;
        int bachelorProjectCount = 0;
        int totalCourseECTS = 0;
        int basicCourseECTS = 0;

        // Gennemgår hver aktivitet i array-listen 'activities' med for each loop med if statements.
        for (StudyActivity activity : activities) {
            if (activity instanceof Project) { // Tjekker om activity er en instance of Project class.
                Project project = (Project) activity; // Caster til typen Project.
                projectCount++; // Tæller op for hvert projekt i listen.

                if (project.isBachelorProject()) { // Tjekker om projektet er et bachelor projekt.
                    bachelorProjectCount++; // Tæller op hvis det er.
                } else if (project.isBasicProject()) { // Tjekker om projektet er et basisprojekt.
                    basicProjectCount++; // Tæller op hvis det er.
                }
            } else if (activity instanceof Course) { // Tjekker om activity er en instance of Course class.
                Course course = (Course) activity; // Caster til typen Course.
                totalCourseECTS += course.getECTS(); // Lægger antal ECTS sammen med totalCourseECTS.

                if (course.isBasicCourse()) { // Tjekker om kurset er et basic course.
                    basicCourseECTS += course.getECTS(); // Lægger antal ECTS sammen med basicCourseECTS.
                }
            }
        }

        // Validerer om reglerne for projects er overholdt.
        boolean validProjects = false;
        if (projectCount == 6 && basicProjectCount == 3 && bachelorProjectCount == 1) {
            validProjects = true;
        } else {
            System.out.println("Project requirements not met.");
        }
        System.out.println("Valid projects: " + validProjects);

        // Validerer om reglerne for courses overholdes.
        boolean validCourses = false;
        if (totalCourseECTS == 90 && basicCourseECTS >= 40) {
            validCourses = true;
        } else {
            System.out.println("Course ECTS requirements not met. Total course ECTS: " + totalCourseECTS);
        }
        System.out.println("Valid courses: " + validCourses);

        /* Hvis reglerne er overholdt for både projects og courses har vi et gyldigt bachelor programme
         og isValid returneres som true. */
        return validProjects && validCourses;
    }

    // Getter så andre dele af programmet kan hente/læse listen af aktiviter.
    public List<StudyActivity> getActivities() {
        return activities;
    }

    // Setter så andre dele af programmet kan ændre/opdatere listen med aktiviter.
    public void setActivities(List<StudyActivity> activities) {
        this.activities = activities;
    }
}