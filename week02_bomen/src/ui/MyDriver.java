package ui;

import domain.BinaryTree;

public class MyDriver {
    public static void main(String[] args) {
        BinaryTree<String> nodeC = new BinaryTree<>("C");
        BinaryTree<String> nodeE = new BinaryTree<>("E");
        BinaryTree<String> nodeH = new BinaryTree<>("H");

        BinaryTree<String> nodeA = new BinaryTree<>("A");
        BinaryTree<String> nodeD = new BinaryTree<>("D", nodeC, nodeE);
        BinaryTree<String> nodeI = new BinaryTree<>("I", nodeH, null);

        BinaryTree<String> nodeB = new BinaryTree<>("B", nodeA, nodeD);
        BinaryTree<String> nodeG = new BinaryTree<>("G", null, nodeI);

        BinaryTree<String> boom = new BinaryTree<>("F", nodeB, nodeG);

        System.out.print("pre order: ");
        boom.printPreorder();

        System.out.print("\nin order: ");
        boom.printInorder();

        System.out.print("\npost order: ");
        boom.printPostorder();

        System.out.println("\ncount: " + boom.countNodes());
        System.out.println("depth: " + boom.getDepth());

        System.out.print("leaves: " + boom.countLeaves() + " - ");
        boom.getDataLeaves().forEach(System.out::print);
        System.out.println("\n");
        System.out.println(boom.contains("D"));
        System.out.println(boom.contains("H"));
        System.out.println(boom.contains("F"));
        System.out.println(boom.contains("Q"));
    }
}
