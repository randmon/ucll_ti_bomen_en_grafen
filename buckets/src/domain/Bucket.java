package domain;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Bucket {
    private final double[][] gewichtenMatrix;
    public static final int infty = Integer.MAX_VALUE;

    public Bucket(double[][] matrix) {
        if (!isGeldigeGewichtenmatrix(matrix))
            throw new IllegalArgumentException("No valid gewichtenmatrix");
        this.gewichtenMatrix = matrix;
    }

    private boolean isGeldigeGewichtenmatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }

    private void initArray(int[] array) {
        Arrays.fill(array, infty);
    }

    public static void printArray(double[] matrix) {
        StringBuilder result = new StringBuilder();
        for (double v : matrix) {
            result.append(v).append(" ");
        }
        result.append("\n");
        System.out.println(result);
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

    private boolean areConnected(int from, int to) {
        return this.gewichtenMatrix[from-1][to-1] !=0;
    }


    private int[] findAncestors(int start, int destination) {
        int aantalKnopen = getAantalKnopen();
        int[] ancestors = new int[aantalKnopen];
        initArray(ancestors);

        Queue<Integer> queue = new LinkedList<>();
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

    public double buizensysteem(double input, int bron, int put) {
        List<Integer> path = findPath(bron+1, put+1);
        System.out.println(path);
        double result = input;
        for (int i = 0; i < path.size()-1; ++i) {
            //Zoek buis tussen nodes
            double loss = gewichtenMatrix[path.get(i)-1][path.get(i+1)-1];
            result = result * loss;
        }
        return result * 100.0 / 100.0;
    }
}
