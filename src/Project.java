public class Project extends StudyActivity {
    private boolean isBachelorProject;
    private boolean isBasicProject;

    /*
    Jeg blev nødt til at introducere en ekstra variabel isBasicProject,
    som skal bruges til at validere om det er et basic projekt eller ikke
    og som hellere ikke er et bachelorprojekt. Ellers ville den tro, at alle
    projekter som ikke er bachelorprojekt, er samme type basic projekt
    også vil den ikke godtage, at mindst 3 skal være basic for så tror den at alle
    er basic projekter.
     */
    public Project(boolean isBachelorProject, boolean isBasicProject) {
        super(15); //15 fordi alle projekter vægter 15 ECTS point
        this.isBachelorProject = isBachelorProject;
        this.isBasicProject = isBasicProject;
    }

    public boolean isBasicProject() {
        return isBasicProject;
    }

    public boolean isBachelorProject() {
        return isBachelorProject;
    }

    public void setBachelorProject(boolean bachelorProject) {
        this.isBachelorProject = bachelorProject;
    }
}