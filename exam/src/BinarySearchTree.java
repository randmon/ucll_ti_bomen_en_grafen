import java.util.*;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	public BinarySearchTree<E> createBalancedBST(List<E> treeData){
		//Middle node must become root
		if (treeData.size() == 0) return null;
		/*We the size/2 integer division to be the index of middle
		For example if a tree has 3 nodes, middle needs to be index 1 -> 3/2 = 1.5 -> 1
		If a tree has 4 nodes, middle needs to be index 2 and not 1, so that there are no empty spots on the leaves on the left
		Bottom layer becomes 1 - 2 - 4 - null with 3 as root,
		instead of 1 - null - 3 - 4 with 2 as root, which is not balanced */

		int middle = treeData.size()/2;
		BinarySearchTree<E> result = new BinarySearchTree<>(treeData.get(middle),
				//Add left and right balanced trees
				createBalancedBST(treeData.subList(0, middle)),
				createBalancedBST(treeData.subList(middle+1, treeData.size())));
		if (treeData.size() == 1) return new BinarySearchTree<>(treeData.get(0));

		return result;
	}

	public ArrayList<E> getAsSortedArray () {
		ArrayList<E> result = new ArrayList<>();
		result.add(this.data);
		if (leftTree != null) result.addAll(leftTree.getAsSortedArray());
		if (rightTree != null) result.addAll(rightTree.getAsSortedArray());
		result.sort(Comparable::compareTo);
		return result;
	}

	@Override
	public boolean addNode(E data) {
		if (data == null) throw new IllegalArgumentException();
		if (this.data.compareTo(data) == 0) return false; //No duplicates allowed
		else if (this.data.compareTo(data) > 0) {
			if (this.leftTree == null) {
				this.leftTree = new BinarySearchTree<>(data);
				return true;
			} else return (this.leftTree.addNode(data));
		} else if (this.rightTree == null) {
			this.rightTree = new BinarySearchTree<>(data);
			return true;
		}
		return (this.rightTree.addNode(data));
	}
}


