// Skaber Project subclass der extender (nedarver) StudyActivity.
public class Project extends StudyActivity {
    /*
     Tilføjer to boolean instance variabler. To forskellige projektvariabler skal laves
     eftersom der er et krav om 1 bachelorprojekt og 3 basisprojekter.
     */
    private boolean isBachelorProject;
    private boolean isBasicProject;

    // Skaber constructor med instance variablerne.
    public Project(boolean isBachelorProject, boolean isBasicProject) {
       // Kalder superclass (StudyActivity) constructor 'ECTS' og giver værdien 15 fordi alle projekter vægter 15 ECTS point.
        super(15);
        this.isBachelorProject = isBachelorProject;
        this.isBasicProject = isBasicProject;
    }

    /*
     Bruger Getter method til at muliggøre at andre dele af programmet (Main) kan checke instance variablerne
     og returnere en true/false værdi.
     */
    public boolean isBasicProject() {
        return isBasicProject;
    }

    public boolean isBachelorProject() {
        return isBachelorProject;
    }

    // Bruger Setter method til bachelorProject så variablen kan sættes af andre dele af programmet.
    public void setBachelorProject(boolean bachelorProject) {
        this.isBachelorProject = bachelorProject;
    }
}