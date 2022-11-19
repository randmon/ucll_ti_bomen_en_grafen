package ui;

import domain.Graph;

public class MyBFSUI {
    public static void main(String[] args) {
        int[][] data = {
                { 0, 1, 1, 1, 0, 0, 0, 0 },
                { 1, 0, 1, 0, 1, 0, 0, 0 },
                { 1, 1, 0, 0, 0, 1, 0, 0 },
                { 1, 0, 0, 0, 0, 1, 1, 0 },
                { 0, 1, 0, 0, 0, 1, 0, 1 },
                { 0, 0, 1, 1, 1, 0, 1, 0 },
                { 0, 0, 0, 1, 0, 1, 0, 1 },
                { 0, 0, 0, 0, 1, 0, 1, 0 }
        };
        Graph g = new Graph(data);

        int start = 1;
        int destination = 8;

        System.out.println(g.geefAncestors(start, destination));
        System.out.println(BreadthFirstSearchUI.zetPadOmNaarString(start, destination, g.findPath(start, destination)));

        System.out.println();

        start = 2;
        destination = 7;

        System.out.println(g.geefAncestors(start, destination));
        System.out.println(BreadthFirstSearchUI.zetPadOmNaarString(start, destination, g.findPath(start, destination)));
    }
}
