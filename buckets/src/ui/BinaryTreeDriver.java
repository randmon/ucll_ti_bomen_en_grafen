package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {

	public static void main(String[] args) {
		BinaryTree<Integer> boom1 = new BinaryTree<>(1,
				new BinaryTree<>(2),
				new BinaryTree<>(3));

		BinaryTree<Integer> boom2 = new BinaryTree<>(1,
				new BinaryTree<>(2,
						new BinaryTree<>(3),
						null),
				new BinaryTree<>(5));

		BinaryTree<Integer> boom3 = new BinaryTree<>(1,
				new BinaryTree<>(2,
						new BinaryTree<>(3),
						new BinaryTree<>(4)),
				new BinaryTree<>(5,
						new BinaryTree<>(6,
								new BinaryTree<>(8),
								new BinaryTree<>(9)),
						new BinaryTree<>(7,
								new BinaryTree<>(10),
								new BinaryTree<>(11))));

		BinaryTree<Integer> boom4 = new BinaryTree<>(1,
				new BinaryTree<>(2,
						new BinaryTree<>(2),
						new BinaryTree<>(2)),
				new BinaryTree<>(3,
						new BinaryTree<>(3),
						new BinaryTree<>(3)));

		System.out.println("boom1 allNodesHaveTwoChildren (true): " + boom1.allNodesHaveTwoChildren());
		System.out.println("boom2 allNodesHaveTwoChildren (false): " + boom2.allNodesHaveTwoChildren());
		System.out.println("boom3 allNodesHaveTwoChildren (true): " + boom3.allNodesHaveTwoChildren());

		System.out.println("\nOnly leaves on depth 0 (boom 1) (false): " + boom1.onlyLeavesOnDepth(0));
		System.out.println("Only leaves on depth 0 (boom 2)(false): " + boom2.onlyLeavesOnDepth(0));

		System.out.println("\nOnly leaves on depth 1 (boom 1)(true): " + boom1.onlyLeavesOnDepth(1));
		System.out.println("Only leaves on depth 1 (boom 2)(false): " + boom2.onlyLeavesOnDepth(1));
		System.out.println("Only leaves on depth 2 (boom 2)(true): " + boom2.onlyLeavesOnDepth(2));

		System.out.println("\nNo leaves before depth 1 (boom 1)(true): " + boom1.noLeavesBeforeDepth(1));
		System.out.println("No leaves before depth 2 (boom 2)(false): " + boom2.noLeavesBeforeDepth(2));

		System.out.println("\nBoom 1 is perfect: " + boom1.isPerfect());
		System.out.println("Boom 2 is niet perfect: " + boom2.isPerfect());
		System.out.println("Boom 3 is niet perfect: " + boom3.isPerfect());
		System.out.println("Boom 4 is perfect: " + boom1.isPerfect());

	}
}
