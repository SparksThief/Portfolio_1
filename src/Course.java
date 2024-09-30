// Skaber Course subclass der extender (nedarver) StudyActivity.
public class Course extends StudyActivity {
    private boolean isBasicCourse;

    //Constructor
    public Course(int ECTS, boolean isBasicCourse) {
        super(ECTS); //Kalder konstruktøren fra StudyActivity klassen
        if (ECTS !=5 && ECTS !=10) {
            throw new IllegalArgumentException("Courses must have either 5 or 10 ECTS");
        }
        this.isBasicCourse = isBasicCourse;
    }

    public boolean isBasicCourse() {
        return isBasicCourse;
    }

    public void setBasicCourse(boolean isBasicCourse) {
        this.isBasicCourse = isBasicCourse;
    }
}
