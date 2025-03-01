import java.util.ArrayList;

public class BinaryTree<E extends Comparable<E>>{
	E data;
	BinaryTree<E> leftTree, rightTree;

	public BinaryTree(E data){
		this(data,null,null);
	}

	public BinaryTree(E data, BinaryTree<E> leftTree, BinaryTree<E> rightTree){
		if (data == null) {
			throw new IllegalArgumentException();
		}
		this.data= data;
		this.leftTree= leftTree;
		this.rightTree= rightTree;
	}

	public void printPreorder(){
		System.out.print(this.data + " ");
		if (this.leftTree != null) this.leftTree.printPreorder();
		if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printInorder(){
		if (this.leftTree != null) this.leftTree.printInorder();
		System.out.print(this.data + " ");
		if (this.rightTree != null) this.rightTree.printInorder();
	}

	public void printPostorder(){
		if (this.leftTree != null) this.leftTree.printPostorder();
		if (this.rightTree != null) this.rightTree.printPostorder();
		System.out.print(this.data + " ");
	}

	public int countNodes() {
		int count = 1;
		if (leftTree != null) count += leftTree.countNodes();
		if (rightTree != null) count += rightTree.countNodes();
		return count;
	}

	public boolean isLeaf() {
		return leftTree == null && rightTree == null;
	}

	public int countLeaves() {
		if (isLeaf()) return 1;
		int count = 0;
		if (leftTree != null) count += leftTree.countLeaves();
		if (rightTree != null) count += rightTree.countLeaves();
		return count;
	}

	public ArrayList<E> getDataLeaves() {
		ArrayList<E> result = new ArrayList<>();
		if (isLeaf()){
			result.add(data);
			return result;
		}
		if (leftTree != null) result.addAll(leftTree.getDataLeaves());
		if (rightTree != null) result.addAll(rightTree.getDataLeaves());
		return result;
	}

	public int getDepth() {
		int left = 0, right = 0;
		if (leftTree != null) left = leftTree.getDepth();
		if (rightTree != null)  right = rightTree.getDepth();
		return 1 + Math.max(right, left);
	}

	public boolean contains(E data) {
		if (isLeaf()) return this.data.equals(data);
		return (this.data.equals(data))
				|| (leftTree != null && leftTree.contains(data))
				|| (rightTree != null && rightTree.contains(data));
	}

	//*ONDERSTAANDE METHODES NIET IMPLEMENTEREN! DEZE MOETEN GEIMPLEMENTEERD WORDEN IN DE BinarySearchTree file!*//


	boolean addNode(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	ArrayList<E> getAsSortedArray() {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

}