package ui;

import domain.BinaryTree;

public class BinaryTreeDriver {
    public static void main(String[] args) {
        BinaryTree<String> boom = new BinaryTree<>("A",
                new BinaryTree<>("H",
                        new BinaryTree<>("A"),
                        new BinaryTree<>("H",
                                new BinaryTree<>("C",
                                        null,
                                        new BinaryTree<>("E")),
                                new BinaryTree<>("E"))),
                new BinaryTree<>("G",
                        null,
                        new BinaryTree<>("I",
                                new BinaryTree<>("H",
                                        null,
                                        new BinaryTree<>("E")),
                                new BinaryTree<>("E"))));

        System.out.println("A: " + boom.count("A"));
        System.out.println("B: " + boom.count("B"));
        System.out.println("C: " + boom.count("C"));
        System.out.println("D: " + boom.count("D"));
        System.out.println("E: " + boom.count("E"));
        System.out.println("F: " + boom.count("F"));
        System.out.println("G: " + boom.count("G"));
        System.out.println("H: " + boom.count("H"));
        System.out.println("I: " + boom.count("I"));
    }
}
