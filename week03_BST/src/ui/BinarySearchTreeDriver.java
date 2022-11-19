package ui;

import 	domain.BinarySearchTree;

public class BinarySearchTreeDriver {
	public static void main(String[] args) {
		BinarySearchTree<Integer> tree = new BinarySearchTree<>(6);
		tree.addNode(4);
		tree.addNode(8);
		tree.addNode(3);
		tree.addNode(5);
		tree.addNode(7);
		tree.addNode(9);
		tree.addNode(10);
		tree.addNode(11);
		printTreeInfo(tree);

		print("Remove 9: " + tree.removeNode(9));
		print("Remove 11: " + tree.removeNode(11));
		print("Remove 6: " + tree.removeNode(6));
		printTreeInfo(tree);

		print("Path to 1000: " + tree.getPath(1000));
		print("Path to 7: " + tree.getPath(7));
		print("Path to 4: " + tree.getPath(4));
		print("Path to 8: " + tree.getPath(8));
	}

	private static void printTreeInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) print("Lege boom");
		else {
			print("\n");
			boom.printInorder();
			print("\n");
			print("De grootste waarde uit deze boom = " + boom.searchGreatest());
			print("De kleinste waarde uit deze boom = " + boom.searchSmallest());
			print("Nodes: " + boom.countNodes());
		}
	}

	private static void print(Object o) {
		System.out.println(o);
	}
}
