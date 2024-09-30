public class Main {
    public static void main(String[] args) {

        /*
         * Vi tester nu om programmet gør som forventet,
         * ved at initialisere/oprette et nyt bachelor program,
         * tilføje projekter og kurser til det
         * tjekker om der er nok point
         * og validere til sidst
         * */

        /*
         * For at programmet er validt, skal det indeholde:
         * 6 projekter
         * 3 af projekterne skal være grundprojekter og IKKE bachelorprojekter
         * 1 projekt skal være bachelorprojekt
         *
         * Der skal være 50 samlet ECTS point
         * Mindt 40 af de 50 point skal være fra grundkurser
         * Der må ikke være dubletter af aktiviteter
         */

        // Her initialisere i et nyt bachelor program
        Programme programme = new Programme();

        // Tilføj grundprojekter og ikke bachelor projekter
        // Brug intellij til at hjælpe jer med at oprette aktiviter
        // Intellij vil give forslag, hvis i bare skriver "programme",
        // så kommer den frem med forskellige tilgængelige metoder
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, true));
        programme.addActivity(new Project(false, false));
        programme.addActivity(new Project(false, false));

        // tilføj bachelorprojekt
        programme.addActivity(new Project(true, false));

        // Tilføj x antal kurser
        // HUSK! mindst 50 point samlet og mindt 40 point fra grundkursus
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
        programme.addActivity(new Course(10, true));
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