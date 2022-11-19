package domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Graph {
    private final int[][] verbindingsMatrix;
    public static final int infty = Integer.MAX_VALUE;

    public Graph(int[][] matrix) {
        if (!isGeldigeVerbindingsMatrix(matrix))
            throw new IllegalArgumentException("No valid verbindingsmatrix");

        this.verbindingsMatrix = matrix.clone();
    }

    private boolean isGeldigeVerbindingsMatrix(int[][] matrix) {
        if (matrix == null || matrix.length != matrix[0].length)
            return false;

        for (int i = 0; i < matrix.length; i++)
            if (matrix[i][i] != 0)
                return false;

        for (int[] ints : matrix)
            for (int j = 0; j < matrix.length; j++)
                if (ints[j] != 0 && ints[j] != 1)
                    return false;
        return true;
    }

    private int getAantalKnopen() {
        return this.verbindingsMatrix.length;
    }

    private boolean areConnected(int from, int to) {
        return this.verbindingsMatrix[from-1][to-1] == 1;
    }

    private int[] findAncestors(int start, int destination) {
        int aantalKnopen = getAantalKnopen();
        int[] ancestors = new int[aantalKnopen];
        initArray(ancestors, infty);

        Queue<Integer> queue = new LinkedList<>();
        // https://docs.oracle.com/en/java/javase/11/docs/api/java.base/java/util/Queue.html
        queue.add(start);
        ancestors[start - 1] = 0;

        int huidig = queue.remove();
        while (huidig != destination) {
            //Zoek alle nog niet bezochte knopen vanuit huidig
            for (int i = 1; i <= aantalKnopen; ++i) {
                if (areConnected(huidig, i) && (ancestors[i-1] == infty)) {
                    //voeg knoop i toe aan queue
                    queue.add(i);

                    //duid aan dat huidig de ouder is van i in ancestormatrix
                    ancestors[i-1] = huidig;
                }
            }

            //voorste element van queue wordt nieuwe huidige knoop
            if (!queue.isEmpty()) {
                huidig = queue.poll();
            } else {
                break;
            }
        }

        return ancestors;
    }

    public List<Integer> findPath(int start, int destination) {
        if (start <= 0 || start > this.getAantalKnopen() || destination <= 0 || destination > this.getAantalKnopen())
            throw new IllegalArgumentException();

        int[] ancestors = this.findAncestors(start, destination);
        List<Integer> path = new LinkedList<>();

        int ouder = ancestors[destination-1];
        while (ouder != 0 && ouder != infty) {
            path.add(0, destination);
            destination = ouder;
            ouder = ancestors[destination-1];
        }

        if (ouder == 0) path.add(0, destination);
        return path;

    }

    private void initArray(int[] array, int value) {
        Arrays.fill(array, value);
    }


    // methode om tussenliggend resultaat te kunnen schrijven naar het scherm
    public String geefAncestors(int start, int destination) {
        StringBuilder res = new StringBuilder("Ancestors van " + start + " naar " + destination + ":\n");
        int[] ancestors = this.findAncestors(start, destination);
        for (int ancestor : ancestors) {
            res.append(ancestor != infty ? ancestor + " " : "infty" + " ");
        }
        return res.toString();
    }

    public int[][] getVerbindingsMatrix() {
        return verbindingsMatrix;
    }
}
