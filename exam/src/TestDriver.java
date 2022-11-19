public class TestDriver {
    public static void main(String[] args) {
        BinarySearchTree<Integer> boom = new BinarySearchTree<>(2);
        boom.addNode(1);
        boom.addNode(3);
        boom.addNode(4);

        boom.printPostorder();

        BinarySearchTree<Integer> balanced = boom.createBalancedBST(boom.getAsSortedArray());
        System.out.println();
        balanced.printInorder();
        System.out.println();
        balanced.printPostorder();
    }
}
