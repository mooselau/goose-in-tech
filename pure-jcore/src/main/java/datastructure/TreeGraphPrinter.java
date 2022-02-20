package datastructure;

import java.util.Stack;
import datastructure.BST.TreeNode;

public class TreeGraphPrinter<E extends Comparable<E>> {
	
	public String printTreeGraph(TreeNode<E> node) {
		return printSingleNode(node, true);
	}

	private String printSingleNode(TreeNode<E> node, boolean isLeft) {
		StringBuilder sb = new StringBuilder();
		Stack<TreeNode<E>> stack = new Stack<TreeNode<E>>();
		TreeNode<E> curr = node;
		while(curr != null) {
			if (isLeft) {
				sb.append("|\t" + curr.toString());				
			} else {
				sb.append("\\\t" + curr.toString());
			}
			
			if (curr.getLeftChild() != null) {
				stack.push(curr.getLeftChild());
			}
			if (curr.getRightChild() != null) {
				stack.push(curr.getRightChild());
			}
			curr = stack.pop();
		}
		return sb.toString();
	}
	
}
