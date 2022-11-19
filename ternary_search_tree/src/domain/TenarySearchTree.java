package domain;

public class TenarySearchTree<E extends Comparable<E>> {
    private TenaryTree<E> root;

    public boolean isEmpty() {
        return this.root == null;
    }

    public boolean addNode(E data) {
        throw new UnsupportedOperationException("Not implemented");
    }

    public void printPreOrder() {
        if (this.isEmpty()) System.out.println("Geen data in TST");
        else root.printPreOrder();
    }

    private class TenaryTree<E extends Comparable<E>> {
        private final E data1, data2;
        private final TenaryTree<E> leftTree, middleTree, rightTree;

        public TenaryTree(E data) {
            throw new UnsupportedOperationException("Not implemented");
        }

        public void printPreOrder() {
            System.out.print(" " + this.data1 + "-" + this.data2);
            if (leftTree != null) leftTree.printPreOrder();
            if (middleTree != null) middleTree.printPreOrder();
            if (rightTree != null) rightTree.printPreOrder();
        }

        public boolean addNode(E data) {
            throw new UnsupportedOperationException("Not implemented");
        }
    }
}