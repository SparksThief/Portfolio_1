import java.util.List;

public class Main {
    public static void main(String[] args) {

        Programme programme = new Programme();


        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));


        // tilføj bachelorprojekt
        programme.addActivity(new Project(true, false));

        // Tilføj x antal kurser
        // HUSK! mindst 50 point samlet og mindst 40 point fra grundkursus
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));


        // I kan udskrive resultatet som i har lyst, dette er en måde at gøre det på
        // Det kan gøres med en if/else
        // if(isValidProgramme) tjekker om programmet overholder reglerne
        // else er hvis programmet ikke overholder reglerne

        if (programme.isValid()) {
            System.out.println("Bachelor programme is valid");
        } else {
            System.out.println("Bachelor programme is not valid. Check requirements");
        }

    }
}