public class Project extends StudyActivity {
    private boolean isBachelorProject;
    private boolean isBasicProject;
    private SubjectModule subjectModule; // Reference til SubjectModule

    public Project(boolean isBachelorProject, boolean isBasicProject, SubjectModule subjectModule) {
        super(15); // Alle projekter er 15 ECTS
        this.isBachelorProject = isBachelorProject;
        this.isBasicProject = isBasicProject;
        this.subjectModule = subjectModule;
    }

    public boolean isBachelorProject() {
        return isBachelorProject;
    }

    public void setBachelorProject(boolean bachelorProject) {
        this.isBachelorProject = bachelorProject;
    }

    public boolean isBasicProject() {
        return isBasicProject;
    }

    public void setBasicProject(boolean basicProject) {
        this.isBasicProject = basicProject;
    }

    public SubjectModule getSubjectModule() {
        return subjectModule;
    }

    public void setSubjectModule(SubjectModule subjectModule) {
        this.subjectModule = subjectModule;
    }
}
