import java.util.List;

public class Main {
    public static void main(String[] args) {

        // Opretter nyt program-object
        Programme programme = new Programme();

        // Tilføjelse af project objekter
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));


        // tilføjer bachelorprojekt
        programme.addActivity(new Project(true, false));

        // Tilføjelse af course objecter
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));


        // if(isValidProgramme) tjekker om programmet overholder reglerne
        // else er hvis programmet ikke overholder reglerne
        if (programme.isValid()) {
            System.out.println("Bachelor programme is valid.");
        } else {
            System.out.println("Bachelor programme is not valid. Check requirements.");
        }

    }
}