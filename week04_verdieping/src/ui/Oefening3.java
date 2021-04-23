package ui;

import domain.BinarySearchTree;

public class Oefening3 {
    public static void main(String[] args) {
        BinarySearchTree<Integer> boom = new BinarySearchTree<>(30);
        boom.addNode(20);
        boom.addNode(39);
        boom.addNode(20);
        boom.addNode(10);
        boom.addNode(15);
        boom.addNode(25);
        boom.addNode(23);
        boom.addNode(39);
        boom.addNode(35);
        boom.addNode(42);

        System.out.println("Preorder:");
        boom.printPreorder();
        System.out.println("\n");
        System.out.println("Postorder:");
        boom.printPostorder();
    }
}
