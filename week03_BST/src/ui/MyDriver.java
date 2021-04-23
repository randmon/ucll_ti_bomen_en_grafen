package ui;

import domain.BinarySearchTree;

public class MyDriver {
    public static void main(String[] args) {
        BinarySearchTree<Integer> boom = new BinarySearchTree<>(5);

        boom.addNode(3);
        boom.addNode(7);
        boom.addNode(4);
        boom.addNode(2);
        boom.addNode(1);
        boom.addNode(6);

        boom.printInorder();
    }
}
