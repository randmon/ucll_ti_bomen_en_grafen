public class BinarySearchTreeDriver {

	public static void main(String[] args) {
		BinarySearchTree<Integer> boom = new BinarySearchTree<>(6);
		boom.addNode(3);
		boom.addNode(4);
		boom.addNode(1);
		boom.addNode(5);
		boom.addNode(7);
		boom.addNode(2);
		boom.addNode(6);
		//de correcte uitgeprinte volgorde moet zijn: 1 2 3 4 5 6 7
		BinarySearchTree<Integer> d = boom.createBalancedBST(boom.getAsSortedArray());
		printBoomInfo(d);
	}

	private static void printBoomInfo(BinarySearchTree<Integer> boom) {
		if (boom == null) System.out.println("Lege boom");
		else {
			boom.printInorder();
		}
	}
}
