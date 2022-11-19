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

        BinaryTree<String> tree = new BinaryTree<>("F", nodeB, nodeG);

        print("pre order: ");
        tree.printPreorder();

        print("\nin order: ");
        tree.printInorder();

        print("\npost order: ");
        tree.printPostorder();

        print("\ncount: " + tree.countNodes());
        print("depth: " + tree.getDepth());

        System.out.print("leaves: " + tree.countLeaves() + " - ");
        tree.getDataLeaves().forEach(System.out::print);
        print("\n");

        print("Tree contains 'D': " + tree.contains("D"));
        print("Tree contains 'H': " + tree.contains("H"));
        print("Tree contains 'F': " + tree.contains("F"));
        print("Tree contains 'Q': " + tree.contains("Q"));
    }

    public static void print(Object o) {
        System.out.println(o);
    }
}
