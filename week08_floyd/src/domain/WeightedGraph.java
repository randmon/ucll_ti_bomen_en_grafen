package domain;

import java.util.ArrayList;
import java.util.List;

public class WeightedGraph {
	private final double[][] gewichtenMatrix;
	public final static double infty = Double.POSITIVE_INFINITY;

    public WeightedGraph(double[][] matrix) {
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

    public int[][] getPointerMatrix() {
        int aantalKnopen = getAantalKnopen();
        int[][] P = new int[aantalKnopen][aantalKnopen];
        double[][] D = new double[aantalKnopen][];
        for (int k = 0; k < aantalKnopen; ++k) {
            D[k] = this.gewichtenMatrix[k].clone();
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
		List<Integer> pad = new ArrayList<>();
		if (from == to) return pad;

		int h = P[from-1][to-1];
        if (h == 0) {
            pad.add(from);
            pad.add(to);
        } else {

            pad = getShortestPath(from, h, P);
            pad.remove(pad.size()-1);
            pad.addAll(getShortestPath(h, to, P));
        }
		return pad;

	}

	public int berekenLengte(List<Integer> pad) {
		int som = 0;
		for (int i = 1; i < pad.size(); ++i) {
		    som += gewichtenMatrix[pad.get(i-1)-1][pad.get(i)-1];
        }
		return som;
	}

}
