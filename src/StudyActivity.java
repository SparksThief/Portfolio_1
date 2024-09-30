public abstract class StudyActivity {
    protected int ECTS;

    //Constructor
    public StudyActivity(int ECTS) {
        this.ECTS = ECTS;
    }

    // Bruges til at hente ECTS
    public int getECTS() {
        return ECTS;
    }

    public void setECTS(int ECTS) {
        this.ECTS = ECTS;
    }
}