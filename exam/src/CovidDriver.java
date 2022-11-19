import java.util.Arrays;

public class CovidDriver {

    public static void main(String[] args) {

        int[][] verbindingsmatrix = {
                { 0, 1, 0, 1, 0, 0, 0 },
                { 0, 0, 1, 0, 0, 0, 0 },
                { 1, 0, 0, 1, 1, 0, 0 },
                { 0, 0, 0, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 1 },
                { 0, 0, 0, 0, 0, 0, 0 } };

        int[] besmettingsvector = {0, 0, 0, 1, 0, 0, 0};

        Covid covid = new Covid();

        int[] sickNextWeek = covid.getSickNextWeek(verbindingsmatrix.clone(), besmettingsvector.clone());
        System.out.println("(a) Sick next week:");
        System.out.println(Arrays.toString(sickNextWeek));

        int aantalWeken = covid.weekAllSick(verbindingsmatrix.clone(), besmettingsvector.clone());
        System.out.println("(b) All sick weeks:");
        System.out.println(aantalWeken);

        for(int week = 0; week < 20; week ++){
            int[] sickAfterWeek = covid.getSickAfterWeeks(verbindingsmatrix.clone(), besmettingsvector.clone(), week);
            System.out.println("(a) Sick after " + week +" week:");
            System.out.println(Arrays.toString(sickAfterWeek));
        }
    }
}
