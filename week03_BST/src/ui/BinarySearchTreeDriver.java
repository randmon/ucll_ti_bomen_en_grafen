package ui;

import 	domain.BinarySearchTree;

public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> boom = new BinarySearchTree<>(6);
		boom.addNode(4);
		boom.addNode(8);
		boom.addNode(3);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(9);
		boom.addNode(10);
		boom.addNode(11);
		printBoomInfo(boom);

		System.out.println();
		printBoolean("Remove 9: ", boom.removeNode(9));
		printBoolean("Remove 11: ", boom.removeNode(11));
		printBoolean("Remove 6: ", boom.removeNode(6));
		printBoomInfo(boom);

		System.out.println(boom.getPath(1000));
		System.out.println(boom.getPath(7));
		System.out.println(boom.getPath(4));
		System.out.println(boom.getPath(8));
	}

	private static void printBoomInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) System.out.println("Lege boom");
		else {
			System.out.println("\n");
			boom.printInorder();
			System.out.println();
			System.out.println("De grootste waarde uit deze boom = " + boom.searchGreatest());
			System.out.println("De kleinste waarde uit deze boom = " + boom.searchSmallest());
			System.out.println("Nodes: " + boom.countNodes());
		}
	}

	private static void printBoolean(String s, boolean b) {
		System.out.print(s);
		System.out.println(b);
	}
}
