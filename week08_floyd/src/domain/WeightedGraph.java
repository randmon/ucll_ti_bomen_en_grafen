package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] weightMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
        if (!isValidWeightMatrix(matrix))
            throw new IllegalArgumentException("No valid weight matrix");
        this.weightMatrix = matrix;
    }

    private boolean isValidWeightMatrix(double[][] matrix) {
        return matrix != null && matrix.length == matrix[0].length;
    }

    private int getAantalKnopen() {
        return weightMatrix.length;
    }

    public int[][] getPointerMatrix() {
        int aantalKnopen = getAantalKnopen();
        int[][] P = new int[aantalKnopen][aantalKnopen];
        double[][] D = new double[aantalKnopen][];
        for (int k = 0; k < aantalKnopen; ++k) {
            D[k] = this.weightMatrix[k].clone();
        }

        //elke knoop toevoegen als tussenstation
        for (int station = 0; station < aantalKnopen; ++station) {
            //van elke knoop (rij)
            for (int i = 0; i < aantalKnopen; ++i) {
                //naar elke knoop (kolom)
                for (int j = 0; j < aantalKnopen; ++j) {
                    double som = D[i][station] + D[station][j];
                    if (som < D[i][j]) {
                        D[i][j] = som;
                        P[i][j] = station+1;
                    }
                }
            }
        }
		return P;
	}

	public List<Integer> getShortestPath(int from, int to, int[][] P) {
		List<Integer> path = new ArrayList<>();
		if (from == to) return path;

		int h = P[from-1][to-1];
        if (h == 0) {
            path.add(from);
            path.add(to);
        } else {

            path = getShortestPath(from, h, P);
            path.remove(path.size()-1);
            path.addAll(getShortestPath(h, to, P));
        }
		return path;

	}

	public int calculateLength(List<Integer> path) {
		int som = 0;
		for (int i = 1; i < path.size(); ++i) {
		    som += weightMatrix[path.get(i-1)-1][path.get(i)-1];
        }
		return som;
	}

}
