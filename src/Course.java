public class Course extends StudyActivity {
    private boolean isBasicCourse;
    private SubjectModule subjectModule; // Reference til SubjectModule

    public Course(int ECTS, boolean isBasicCourse, SubjectModule subjectModule) {
        super(ECTS);
        this.isBasicCourse = isBasicCourse;
        this.subjectModule = subjectModule;
    }

    public boolean isBasicCourse() {
        return isBasicCourse;
    }

    public void setBasicCourse(boolean isBasicCourse) {
        this.isBasicCourse = isBasicCourse;
    }

    public SubjectModule getSubjectModule() {
        return subjectModule;
    }

    public void setSubjectModule(SubjectModule subjectModule) {
        this.subjectModule = subjectModule;
    }
}
