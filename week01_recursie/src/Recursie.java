import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Recursie {
    // Oefening 1: n-de Fibonacci-getal
    //Very inneficient because we need to calculate many branches to add them together
    public static int fibonacci(int getal) {
        if (getal <= 0) throw new IllegalArgumentException();
        if (getal <= 2) return 1;
        return fibonacci(getal - 2) + fibonacci(getal-1);
    }

    // Oefening 2 : som van cijfers
    public static int somVanCijfers(int getal) {
        if (getal < 0) return somVanCijfers(Math.abs(getal));
        if (getal < 10) return getal;
        return getal % 10 + somVanCijfers(getal/ 10);
    }

    // Oefening 3: keer een string om
    public static String keerOm(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 0) return "";
        return  s.charAt(s.length()-1) + keerOm(s.substring(0, s.length()-1));
    }

    //oefening 4: countX
    public static int countX(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 0) return 0;
        int result = s.toLowerCase().startsWith("x") ? 1 : 0;
        return result + countX(s.substring(1));

    }

    //oefening 5 : countHi
    public static int countHi(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return 0;
        int result = s.toLowerCase().startsWith("hi") ? 1 : 0;
        return result + countHi(s.substring(1));
    }

    // oefening 6
    public static String changeXY(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() == 0) return "";
        char result = s.toLowerCase().charAt(0) == 'x' ? 'y' : s.charAt(0);
        return result + changeXY(s.substring(1));
    }

    // oefening 7

    public static String changePi(String s) {
        if (s == null) throw new IllegalArgumentException();
        if (s.length() < 2) return s;
        return s.toLowerCase().startsWith("pi") ? "3.14" + changePi(s.substring(2)) : s.charAt(0) + changePi(s.substring(1));
    }

    // oefening 8:
    public static int tweelog(int getal) {
        if (getal <= 0) throw new IllegalArgumentException();
        if (getal == 1) return 0;
        return 1 + tweelog(getal/2);
    }

    // oefening 9;
    public static double findMaximum(List<Double> lijst) {
        if (lijst == null || lijst.size() == 0) throw new IllegalArgumentException();
        if (lijst.size() == 1) return lijst.get(0);
        return Math.max(lijst.get(0), findMaximum(lijst.subList(1, lijst.size())));
    }

    // oefening 10;
    public static ArrayList<String> findSubstrings(String s) {
        if (s == null) throw new IllegalArgumentException();
        ArrayList<String> result = new ArrayList<>();
        if (s.length() == 0) result.add("");
        else {
            for (int i = 0; i < s.length(); ++i) {
                String current = String.valueOf(s.charAt(i));
                ArrayList<String> toAddLijst = findSubstrings(s.substring(i+1));
                for (String toAdd : toAddLijst) {
                    if (toAdd.length() > 0) result.add(current + toAdd);
                }
                result.add(current);
            }
        }
        result.sort(Comparator.comparing(String::length));
        return result;
    }

    // oefening 11;
    public static int aantalKaarten(int n) {
        if (n <= 0) throw new IllegalArgumentException();
        if (n == 1) return 2;
        return 2 * n + n - 1 + aantalKaarten(n-1);
    }
}