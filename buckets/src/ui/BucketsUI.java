package ui;

import domain.Bucket;

public class BucketsUI {
    public static void main(String[] args) {

		// gewichtenmatrix van het voorbeeld
        double[][] matrix = {
                {0, 0.96, 0.98, 0.99, 0, 0},
                {0, 0, 0.99, 0.96, 0, 0},
				{0,0,0, 0, 0, 0.98},
				{0, 0, 0, 0, 0.99, 0.97},
				{0, 0, 0, 0, 0, 0.97},
				{0, 0, 0, 0, 0, 0}};

        Bucket bucket = new Bucket(matrix);

        System.out.println("Resultaat:");
        System.out.println(bucket.buizensysteem(100,0,5));
        //Het correct resultaat is 94.21 (Voor afrondingen op het resultaat worden geen punten afgetrokken.)

    }
}
