package domain;

import java.util.ArrayList;

public class Graph {
	private final int[][] weightMatrix;
    private final int inf = Integer.MAX_VALUE;

	public Graph(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			throw new IllegalArgumentException();
		}

		this.weightMatrix = matrix.clone();
	}

    private int countNodes() {
        return weightMatrix.length;
    }


	private int[][] initMatrixDijkstra(int fromNode) {
		int length = countNodes();
		// laatste rij is rij met kortste lengtes vanuit fromNode
		int[][] result = new int[length + 1][length];
		//Initialiseer laatste rij als "leeg"
		for (int i = 0; i < length; ++i) {
			result[length][i] = inf;
		}
		//Kopieer matrix waardes
		for (int row = 0; row < length; ++row) {
			for (int col = 0; col < length; ++col) {
				int weight = weightMatrix[row][col];
				result[row][col] = weight < inf ? weight : 0;
			}
		}
		//Zet kolom van startknoop allemaal nullen
		for (int i = 0; i < length+1; ++i) {
			result[i][fromNode-1] = 0;
		}

		return result;
	}

	public int[][] dijkstra(int fromNode) {
		int[][] result = initMatrixDijkstra(fromNode);
		
		System.out.println("Initial matrix: \n");
		printIntMatrix(result);

		int length = countNodes();
		for (int i = 0; i < length-1; ++i) {
			//zoek minimale afstand
			int min = inf;
			int[] nodePair = {inf, inf}; //index die het nieuwe minimum is
			for (int j = 0; j < length; ++j) {
				//herhaal voor alle knopen die al bezocht zijn
				if (result[length][j] != inf) {
					for (int k = 0; k < length; ++k) {
						//als knoop k+1 nog niet gevonden is,
						//als er een verbinding is tussen knoop j+1 en knoop k+1
						//en als de verbinding tussen deze knopen korter is dan min
						if (result[length][k] == inf
								&& result[j][k] != 0
								&& result[length][j] + result[j][k] < min) {
							//Zet nodePair en min
							nodePair[0] = j;
							nodePair[1] = k;
							min = result[length][j] + result[j][k];
						}
					}
				}
			}
			//Tussenresultaat wegschrijven indien er verbetering is
			if (nodePair[0] != inf && nodePair[1] != inf) {
				result[length][nodePair[1]] = min; //Zet kost onderaan
				for (int j = 0; j < length; ++j) {
					//Rest van kolom op 0 zetten
					if (j != nodePair[0]) result[j][nodePair[1]] = 0;
				}
			}
		}

		return result;
	}

	private ArrayList<Integer> findPath(int fromNode, int toNode, int[][] res) {
		ArrayList<Integer> path = new ArrayList<>();
		path.add(toNode);

		int lengte = countNodes();
		while (toNode != fromNode) {
			int k = 1;
			while (k-1 < lengte && res[k-1][toNode-1] == 0) k++;
			path.add(0, k);
			toNode = k;
		}
		return path;
	}

	public String berekenPaden(int fromNode) {
        StringBuilder uit = new StringBuilder();
        int[][] res = this.dijkstra(fromNode);

        System.out.println("Result matrix: \n");
        printIntMatrix(res);

        for (int i = 0; i < countNodes(); i++) {
            if ((i + 1) != fromNode) {
                if (res[countNodes()][i] == Integer.MAX_VALUE) {
                    uit.append("There is no path from ").append(fromNode).append(" to ").append(i + 1).append("\n");
                } else {
                    uit.append("Shortest distance from ").append(fromNode).append(" to ").append(i + 1).append(" = ").append(res[countNodes()][i]).append("\n");
                    uit.append("via ");

                    int j = (i + 1);
                    ArrayList<Integer> pad = findPath(fromNode, j, res);
                    uit.append(pad).append("\n");
                }
            }
        }

		return uit.toString();
	}
	
	private static void printIntMatrix(int[][] matrix) {
		StringBuilder result = new StringBuilder();
		for (int[] row : matrix) {
			for (int j = 0; j < matrix[0].length; j++) {
				result.append(row[j] == Integer.MAX_VALUE ? "inf" : row[j]).append("\t");
			}
			result.append("\n");
		}
		result.append("\n");
		System.out.println(result);		
	}
}
