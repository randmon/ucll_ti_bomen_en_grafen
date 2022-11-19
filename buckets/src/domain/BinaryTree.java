package domain;

import java.util.ArrayList;

public class BinaryTree<E>{
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

	public boolean lookup(E data) {
		if (isLeaf()) return this.data.equals(data);
		return (this.data.equals(data))
				|| (leftTree != null && leftTree.lookup(data))
				|| (rightTree != null && rightTree.lookup(data));
	}

	public boolean isLeaf() {
		return leftTree == null && rightTree == null;
	}

	public boolean addNode(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	public boolean removeNode(E data){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	/**Searches the whole tree for leaves with data null, and sets the whole object as null*/
	public boolean cleanUp() {
		if (data == null) return true; //Not able to delete self! Ask from parent by returning true!
		if (leftTree != null) {
			if (leftTree.cleanUp()) leftTree = null;
		}
		if (rightTree != null) {
			if (rightTree.cleanUp()) rightTree = null;
		}
		return false;
	}

	public E searchSmallest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	public E searchGreatest(){
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	public int countNodes() {
		int count = 1;
		if (leftTree != null) count += leftTree.countNodes();
		if (rightTree != null) count += rightTree.countNodes();
		return count;
	}

	public ArrayList<E> getPath(E data) {
		throw new UnsupportedOperationException("Should not be implemented, implement in BinarySearchTree file");
	}

	public int count(E data) {
		int count = 0;
		if (this.data.equals(data)) count ++;
		if (leftTree != null) count += leftTree.count(data);
		if (rightTree != null) count += rightTree.count(data);
		return count;
	}

	public boolean allNodesHaveTwoChildren() {
		//Als het een leaf is, return true
		//Anders, moet twee kinderen hebben en
		//Linker- en rechterbomen moeten ook twee kinderen hebben of leaves zijn
		return isLeaf() || (hasTwoChildren() && leftTree.allNodesHaveTwoChildren() && rightTree.allNodesHaveTwoChildren());
	}

	public boolean hasTwoChildren() {
		return leftTree != null && rightTree != null;
	}

	public boolean onlyLeavesOnDepth(int depth) {
		if (depth == 0) return isLeaf();
		boolean left = true;
		boolean right = true;
		if (leftTree != null) left = leftTree.onlyLeavesOnDepth(depth-1);
		if (rightTree != null) right = rightTree.onlyLeavesOnDepth(depth-1);
		return left && right;
	}

	public int getMaxDepth() {
		if (isLeaf()) return 0;
		int left = 0;
		int right = 0;
		if (leftTree != null) left = leftTree.getMaxDepth();
		if (rightTree != null) right = rightTree.getMaxDepth();
		return Math.max(left, right) + 1;
	}

	public boolean noLeavesBeforeDepth(int depth) {
		if (depth > getMaxDepth()) return false;
		if (depth == 0) return true;
		boolean left = true;
		boolean right = true;
		if (leftTree != null) left = leftTree.noLeavesBeforeDepth(depth-1);
		if (rightTree != null) right = rightTree.noLeavesBeforeDepth(depth-1);
		return !isLeaf() && left && right;
	}

	public boolean isPerfect() {
		int diepte = getMaxDepth();
		return allNodesHaveTwoChildren() && onlyLeavesOnDepth(diepte) && noLeavesBeforeDepth(diepte);
	}

}
