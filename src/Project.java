// Skaber Project subclass der extender (nedarver) StudyActivity.
public class Project extends StudyActivity {
    private boolean isBachelorProject; // Instance variabel
    private boolean isBasicProject; // Instance variabel

    // Skaber constructor med instance variablerne.
    public Project(boolean isBachelorProject, boolean isBasicProject) {
        // Kalder constructor fra StudyActivity class og giver værdien 15 da alle projekter vægter 15 ECTS.
        super(15);
        this.isBachelorProject = isBachelorProject;
        this.isBasicProject = isBasicProject;
    }

    // Getter så andre dele af programmet kan hente/læse værdien kan hentes/læses.
    public boolean isBasicProject() {
        return isBasicProject;
    }

    public boolean isBachelorProject() {
        return isBachelorProject;
    }

    // Setter så andre dele af programmet kan ændre/opdatere variablerne.
    public void setBachelorProject(boolean bachelorProject) {
        this.isBachelorProject = bachelorProject;
    }

    public void setBasicProject(boolean basicProject) {
        this.isBasicProject = basicProject;
    }
}