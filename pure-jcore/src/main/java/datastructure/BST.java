package datastructure;

public class BST <E extends Comparable<E>> {
	
	private TreeNode<E> root;

	public BST() {
		root = null;
	}

	/*
	 * Time complexity: O(log(n))
	 */
	public TreeNode<E> search(E target) {
		TreeNode<E> curr = root;
		if (curr == null) return null;
		while (curr != null) {
			E val = curr.getValue();
			int direction = val.compareTo(target);
			if (direction == 0) return curr;
			else if (direction > 0) {
				curr = curr.leftChild;
			} else {
				curr = curr.rightChild;
			}
		}
		return null;
	}

	public BST<E> insert(E target) {
		TreeNode<E> curr = root;
		TreeNode<E> prev = root;
		if (curr == null) {
			root = new TreeNode<E>(target);
		}
		while (curr != null) {
			int direction = curr.getValue().compareTo(target);
			if (direction >= 0) {
				// curr is greater than target
				if (curr.leftChild != null) {
					curr = curr.leftChild;
				} else {
					curr.leftChild = new TreeNode<E>(target);
					break;
				}
			} else {
				// curr is smaller than target
				if (curr.rightChild != null) {
					curr = curr.rightChild;
				} else {
					curr.rightChild = new TreeNode<E>(target);
					break;
				}
			}
		}
		return this;
	}
	
	///////// Inner Class ///////////
	/** Tree Node for Search Tree. **/
	public static class TreeNode<T extends Comparable<T>> {
		
		private T t;
		
		private TreeNode<T> leftChild;
		private TreeNode<T> rightChild;

		public TreeNode(T t) {
			this.t = t;
			leftChild = null;
			rightChild = null;
		}

		public T getValue() {
			return t;
		}
		
		public void setValue(T t) {
			this.t = t;
		}
		
		public TreeNode<T> getLeftChild() {
			return leftChild;
		}

		public void setLeftChild(TreeNode<T> leftChild) {
			this.leftChild = leftChild;
		}

		public TreeNode<T> getRightChild() {
			return rightChild;
		}

		public void setRightChild(TreeNode<T> rightChild) {
			this.rightChild = rightChild;
		}
		
		public String toString() {
			return this.toString();
		}
	}
	
	///// graph print ////
	public String printAsGraph() {
		TreeGraphPrinter<E> graphPrinter = new TreeGraphPrinter<E>();
		return graphPrinter.printTreeGraph(root);
	}

}
