public class Course extends StudyActivity {
    private boolean isBasicCourse;
// Heeeej virker den her test??????????
    //Constructor
    public Course(int ECTS, boolean isBasicCourse) {
        super(ECTS); //Kalder konstruktøren fra StudyActivity klassen
        this.isBasicCourse = isBasicCourse;
    }

    public boolean isBasicCourse() {
        return isBasicCourse;
    }

    public void setBasicCourse(boolean isBasicCourse) {
        this.isBasicCourse = isBasicCourse;
    }
}
