package domain;

import java.util.ArrayList;

public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> {

	public BinarySearchTree(E data, BinarySearchTree<E> leftTree, BinarySearchTree<E> rightTree) {
		super(data, leftTree, rightTree);
	}
			
	public BinarySearchTree(E data) {
		super(data);
	}

	@Override
	public boolean lookup(E data) {
		if (data == null) throw new IllegalArgumentException();
		int result = data.compareTo(this.data);
		if (result == 0) return true;
		if (result < 0) return leftTree != null && leftTree.lookup(data);
		return rightTree != null && rightTree.lookup(data);
	}

	@Override
	public boolean addNode(E data) {
		if (data == null) throw new IllegalArgumentException();
		int result = data.compareTo(this.data);
		if (result == 0) return false; //No duplicates allowed
		if (result < 0) {
			if (leftTree == null) {
				leftTree = new BinarySearchTree<>(data);
				return true;
			} return leftTree.addNode(data);
		}
		else {
			if (rightTree == null) {
				rightTree = new BinarySearchTree<>(data);
				return true;
			} return rightTree.addNode(data);
		}
	}

	@Override
	public boolean removeNode(E data){
		if (data == null) throw new IllegalArgumentException();
		int result = data.compareTo(this.data);
		boolean deleted;
		if (result == 0) {
			if (this.isLeaf()) {
				this.data = null;
			} else if (leftTree != null) {
				E grootsteLinks = leftTree.searchGreatest();
				this.data = grootsteLinks;
				leftTree.removeNode(grootsteLinks);
			} else {
				E kleinsteRechts = rightTree.searchSmallest();
				this.data = kleinsteRechts;
				rightTree.removeNode(kleinsteRechts);
			}
			deleted = true;
		}
		else if (result < 0) {
			if (leftTree == null) return false;
			deleted = leftTree.removeNode(data);
		}
		else if (rightTree == null) return false;
		else deleted = rightTree.removeNode(data);

		if (deleted) cleanUp();
		return deleted;
	}

	@Override
	public E searchSmallest(){
		return leftTree == null ? data : leftTree.searchSmallest();
	}

	@Override
	public E searchGreatest(){
		return rightTree == null ? data : rightTree.searchGreatest();
	}

	@Override
	public ArrayList<E> getPath(E data) {
		if (data == null) throw new IllegalArgumentException();
		int result = data.compareTo(this.data);
		ArrayList<E> path = new ArrayList<>();
		if (result == 0) {
			path.add(data);
			return path;
		} else if (result < 0){
			ArrayList<E> left = leftTree == null ? null : leftTree.getPath(data);
			if (left != null && left.get(0) != null) path.addAll(left);
		} else {
			ArrayList<E> right = rightTree == null ? null : rightTree.getPath(data);
			if (right != null && right.get(0) != null) path.addAll(right);
		}

		if (path.size() == 0) return null;
		path.add(0, this.data);
		return path;
	}

}


