public class Covid {

    public Covid(){}

    public int[] getSickNextWeek(int[][] verbindingsmatrix, int[] besmettingsvector){
        int[] result = new int[besmettingsvector.length];
        for (int p = 0; p < besmettingsvector.length; ++p) {
            if (besmettingsvector[p] == 1) {
                //Persoon is besmet
                result[p] = 1;
                //Zoek mensen met wie deze persoon contact heeft gehad
                int[] contacts = verbindingsmatrix[p];
                //System.out.println(Arrays.toString(contacts));
                for (int i = 0; i < contacts.length; ++i) {
                    if (contacts[i] == 1) {
                        //Persoon wordt besmet
                        //Check eerst of ze thuis zijn
                        if (besmettingsvector[i] < 1) result[i] = 1;
                    }
                }
            }
        }
        return result;
    }

    public boolean iedereenBesmet(int[] vector) {
        for (int persoon : vector) {
            if (persoon == 0) return false;
        }
        return true;
    }

    public int weekAllSick(int[][] verbindingsmatrix, int[] besmettingsvector){
        //Nagaan of nog iemand niet besmet is
        if (iedereenBesmet(besmettingsvector)) return 0;
        else return weekAllSick(verbindingsmatrix, getSickNextWeek(verbindingsmatrix, besmettingsvector)) + 1;
    }

    public int[] getSickNextWeek_magThuisBlijven(int[][] verbindingsmatrix, int[] besmettingsvector){
        int[] result = new int[besmettingsvector.length];
        for (int p = 0; p < besmettingsvector.length; ++p) {
            if (besmettingsvector[p] == 1) {
                //Persoon is 1 week besmet en besmet mensen
                result[p] = 2;
                //Zoek mensen met wie deze persoon contact heeft gehad
                int[] contacts = verbindingsmatrix[p];
                for (int i = 0; i < contacts.length; ++i) {
                    if (contacts[i] == 1) {
                        //Persoon wordt besmet
                        //Check eerst of ze thuis of al ziek zijn
                        if (besmettingsvector[i] < 1) result[i] = 1;
                    }
                }
            }
            //Check ook mensen die thuis zijn om te geniezen
            else if (besmettingsvector[p] == 2) result[p] = 3;
            else if (besmettingsvector[p] == 3) result[p] = 0;

        }
        return result;
    }

    public int[] getSickAfterWeeks(int[][] verbindingsmatrix, int[] besmettingsvector, int aantalWeken){
        if (aantalWeken == 0) return besmettingsvector;
        return getSickAfterWeeks(verbindingsmatrix, getSickNextWeek_magThuisBlijven(verbindingsmatrix, besmettingsvector), aantalWeken-1);
    }
}
