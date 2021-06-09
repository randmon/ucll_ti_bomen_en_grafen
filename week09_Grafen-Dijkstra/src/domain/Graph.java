package domain;

import java.util.ArrayList;

public class Graph {
	private final int[][] gewichtenMatrix;
    private final int inf = Integer.MAX_VALUE;

	public Graph(int[][] matrix) {
		if (matrix == null || matrix.length == 0 || matrix.length != matrix[0].length) {
			throw new IllegalArgumentException();
		}

		this.gewichtenMatrix = matrix.clone();
	}

    private int getAantalKnopen() {
        return gewichtenMatrix.length;
    }


	private int[][] initMatrixDijkstra(int vanKnoop) {
		int lengte = getAantalKnopen();
		// laatste rij is rij met kortste lengtes vanuit vanKnoop
		int[][] res = new int[lengte + 1][lengte];
		//Initialiseer laatste rij als "leeg"
		for (int i = 0; i < lengte; ++i) {
			res[lengte][i] = inf;
		}
		//Kopieer matrix waardes
		for (int rij = 0; rij < lengte; ++rij) {
			for (int kolom = 0; kolom < lengte; ++kolom) {
				int gewicht = gewichtenMatrix[rij][kolom];
				res[rij][kolom] = gewicht < inf ? gewicht : 0;
			}
		}
		//Zet kolom van startknoop allemaal nullen
		for (int i = 0; i < lengte+1; ++i) {
			res[i][vanKnoop-1] = 0;
		}

		return res;
	}

	public int[][] dijkstra(int vanKnoop) {
		int[][] res = initMatrixDijkstra(vanKnoop);
		
		System.out.println("Initiele matrix: \n");
		printIntMatrix(res);

		int lengte = getAantalKnopen();
		for (int i = 0; i < lengte-1; ++i) {
			//zoek minimale afstand
			int min = inf;
			int[] knopenpaar = {inf, inf}; //index die het nieuwe minimum is
			for (int j = 0; j < lengte; ++j) {
				//herhaal voor alle knopen die al bezocht zijn
				if (res[lengte][j] != inf) {
					for (int k = 0; k < lengte; ++k) {
						//als knoop k+1 nog niet gevonden is,
						//als er een verbinding is tussen knoop j+1 en knoop k+1
						//en als de verbinding tussen deze knopen korter is dan min
						if (res[lengte][k] == inf
								&& res[j][k] != 0
								&& res[lengte][j] + res[j][k] < min) {
							//Zet knopenpaar en min
							knopenpaar[0] = j;
							knopenpaar[1] = k;
							min = res[lengte][j] + res[j][k];
						}
					}
				}
			}
			//Tussenresultaat wegschrijven indien er verbetering is
			if (knopenpaar[0] != inf && knopenpaar[1] != inf) {
				res[lengte][knopenpaar[1]] = min; //Zet kost onderaan
				for (int j = 0; j < lengte; ++j) {
					//Rest van kolom op 0 zetten
					if (j != knopenpaar[0]) res[j][knopenpaar[1]] = 0;
				}
			}
		}


		return res;
	}

	private ArrayList<Integer> vindPad(int vanKnoop, int naarKnoop, int[][] res) {
		ArrayList<Integer> pad = new ArrayList<>();
		pad.add(naarKnoop);

		int lengte = getAantalKnopen();
		while (naarKnoop != vanKnoop) {
			int k = 1;
			while (k-1 < lengte && res[k-1][naarKnoop-1] == 0) k++;
			pad.add(0, k);
			naarKnoop = k;
		}
		return pad;
	}

	public String berekenPaden(int vanKnoop) {
        String uit = "";
        int[][] res = this.dijkstra(vanKnoop);

        System.out.println("Resulterende matrix: \n");
        printIntMatrix(res);

        for (int i = 0; i < getAantalKnopen(); i++) {
            if ((i + 1) != vanKnoop) {
                if (res[getAantalKnopen()][i] == Integer.MAX_VALUE) {
                    uit += "Er is geen pad van " + vanKnoop + " naar " + (i + 1) + "\n";
                } else {
                    uit += "Kortste afstand van " + vanKnoop + " naar " + (i + 1) + " = " + res[getAantalKnopen()][i] + "\n";
                    uit += "via ";

                    int j = (i + 1);
                    ArrayList<Integer> pad = vindPad(vanKnoop, j, res);
                    uit += pad + "\n";
                }
            }
        }

		return uit;
	}
	
	private static void printIntMatrix(int[][] matrix) {
		String result ="";
		for (int[] rij : matrix) {
			for (int j = 0; j < matrix[0].length; j++) {
				result += (rij[j] == Integer.MAX_VALUE ? "inf" : rij[j]) + "\t";
			}
			result += "\n";
		}
		result += "\n";
		
		System.out.println(result);		
	}

}
