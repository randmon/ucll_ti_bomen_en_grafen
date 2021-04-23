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
	
	public void printPreorder() {
		System.out.print(this.data + " ");
		if (this.leftTree != null) this.leftTree.printPreorder();
		if (this.rightTree != null) this.rightTree.printPreorder();
	}

	public void printPostorder() {
		if (this.leftTree != null) this.leftTree.printPostorder();
		if (this.rightTree != null) this.rightTree.printPostorder();
		System.out.print(this.data + " ");
	}

	public void printInorder() {
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
}
