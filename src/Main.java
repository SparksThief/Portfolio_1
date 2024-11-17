public class Main {
    public static void main(String[] args) {

        // Opretter nyt program-object
        Programme programme = new Programme();

        /* Tilføjelse af project objekter - 3 basisprojekter, 2 vilkårlige (svarer til fagmodulsprojekter)
        og 1 bachelorprojekt */
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(true, false));

        // Tilføjelse af kursus objekter - 4 basiskurser + 1 valgkursus (=50 ects),
        // 4 vilkårlige (svarer til fagmodulkurser) (=40 ects) */
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, false));
        programme.addActivity(new Course(10, false));
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