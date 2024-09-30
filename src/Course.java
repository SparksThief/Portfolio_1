// Skaber Course subclass der extender (nedarver) StudyActivity.
public class Course extends StudyActivity {
    private boolean isBasicCourse; // Instance variabel

    // Constructor
    public Course(int ECTS, boolean isBasicCourse) {
        super(ECTS); // Kalder constructor fra StudyActivity class for at kunne videregive (ECTS);.
        this.isBasicCourse = isBasicCourse; // Initialiserer instance variabel.
    }

    // Getter så andre dele af programmet kan hente/læse om det er et basiskursus.
    public boolean isBasicCourse() {
        return isBasicCourse;
    }

    // Setter så andre dele af programmet kan ændre/opdatere variablen.
    public void setBasicCourse(boolean isBasicCourse) {
        this.isBasicCourse = isBasicCourse;
    }
}
