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

        // Gennemgår hver aktivitet array-listen 'activities' med for each loop med if statements.
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


        // If statements til at validere om bachelorprogrammet er gyldigt ifølge alle reglerne.
        boolean validProjects = true;

        if (projectCount != 6) { // Der skal være 6 projekter i alt.
            validProjects = false;
            System.out.println("You need 6 projects, but you have " + projectCount + ".");
        }

        if (basicProjectCount != 3) { // Der skal være 3 basisprojekter.
            validProjects = false;
            System.out.println("You need 3 basic projects, but you have " + basicProjectCount + ".");
        }

        if (bachelorProjectCount != 1) { // Der skal være 1 bachelorprojekt.
            validProjects = false;
            System.out.println("You need 1 bachelor project, but you have " + bachelorProjectCount + ".");
        }

        System.out.println("Valid projects: " + validProjects);

        // If statements til at tjekke om der er mindst 50 ECTS samlet og mindst 40 ECTS fra grundkurser.
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

        // Hvis begge valideringer er opfyldt, returneres true, ellers false.
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