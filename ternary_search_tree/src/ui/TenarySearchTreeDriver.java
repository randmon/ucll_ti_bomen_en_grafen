package ui;

import domain.TenarySearchTree;

public class TenarySearchTreeDriver {

    public static void main(String[] args) {
        TenarySearchTree<Integer> boom = new TenarySearchTree<>();
        boom.addNode(2);
        boom.addNode(5);
        boom.addNode(1);
        boom.addNode(8);
        boom.addNode(3);
        boom.addNode(10);
        boom.addNode(4);
        boom.addNode(9);

        printBoom(boom);
    }

    private static void printBoom(TenarySearchTree<Integer> boom) {
        if (boom == null) System.out.println("Lege boom");
        else {
            boom.printPreOrder();
            System.out.println();
        }
    }
}
