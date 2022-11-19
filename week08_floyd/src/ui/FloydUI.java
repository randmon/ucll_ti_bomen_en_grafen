package ui;
import java.util.List;

import domain.WeightedGraph;
public class FloydUI {
	static final double infty = WeightedGraph.infty;
	
	public static void main(String[] args) {
		double [][] matrix = {
				{0,		1,		infty,	1,		5},
				{9,		0,		3,		2,		infty},
				{infty,	infty,	0, 		4,		infty},
				{infty,	infty,	2,		0,		3},
				{3,		infty,	infty,	infty,	0}
		};

		/*double[][] matrix = {
				{0,		2,		3,		11,		infty},
				{infty,	0,		infty,	7,		infty},
				{infty,	infty,	0,		4,		infty},
				{infty,	infty,	infty,	0,		1},
				{infty,	infty,	infty,	infty,	0}
		};*/
		
		printDoubleMatrix(matrix);
		
		WeightedGraph g = new WeightedGraph(matrix);
		int[][] p_matrix = g.getPointerMatrix();
		printIntMatrix(p_matrix);
		
		StringBuilder result = new StringBuilder("Shortest paths:\n");
		for (int i = 1; i <= matrix.length; i++) {
			for (int j = 1; j <= matrix.length; j++) {
				List<Integer> path = g.getShortestPath(i, j, p_matrix);
				
				if (path.size() == 0)
					result.append("Er is geen path from ").append(i).append(" to ").append(j).append("\n");
				else
					result.append("Shortest path from ").append(i).append(" to ").append(j).append(" lengte = ").append(g.calculateLength(path)).append(" via : ").append(path).append("\n");
			}
			result.append("\n");
		}
		
		System.out.println(result);
	}

	private static void printIntMatrix(int[][] matrix) {
		StringBuilder result = new StringBuilder("p_matrix: \n");
		for (int[] ints : matrix) {
			for (int j = 0; j < matrix.length; j++) {
				result.append(ints[j] == infty ? "inf" : ints[j]).append("\t");
			}
			result.append("\n");
		}
		result.append("\n");
		
		System.out.println(result);		
	}

	private static void printDoubleMatrix(double[][] matrix) {
		StringBuilder result = new StringBuilder("gewichtenmatrix: \n");
		for (double[] doubles : matrix) {
			for (int j = 0; j < matrix.length; j++) {
				result.append(doubles[j] == infty ? "inf" : doubles[j]).append("\t");
			}
			result.append("\n");
		}
		result.append("\n");
		
		System.out.println(result);
	}

}
