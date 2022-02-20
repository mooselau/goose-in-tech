package datastructure;

public class BSTT {
	
	private TreeNode root;
	
	public BSTT() {
	}
	
	public void insert(int val) {
		TreeNode node = root;
		TreeNode prev = node;
		boolean isLeftNode = false;
		while(node != null) {
			if (val == node.val) {
				// existing value
				return ;
			} else if (val > node.val) {
				prev = node;
				isLeftNode = false;
				node = node.right;
			} else {
				prev = node;
				isLeftNode = true;
				node = node.left;
			}
		}
		// found the place
		node = new TreeNode(val);
		// make links
		if (isLeftNode) {
			prev.left = node; 
		} else {
			prev.right = node;
		}
	}
	
	public void delete(int val) {
		
	}
	
	public boolean isExisting(int val) {
		return false;
	}
	
	public static void main(String[] args) {
		BSTT t = new BSTT();
		t.entrypoint();
	}
	
	private void entrypoint() {
		root = new TreeNode(10);
		insert(5);
		insert(15);
		insert(1);
		insert(2);
		insert(30);
		printNode(root);
//		root.left = new TreeNode(5);
//		root.right = new TreeNode(15);
	}
	
	private void printNode(TreeNode node) {
		
		if (node.left != null) {
			printNode(node.left);
		}
		
		if (node.right != null) {
			printNode(node.right);
		}
		
		System.out.print(node.val + " \n");
		return ;
	}
	
	private class TreeNode {
		private int val;
		private TreeNode left, right;
		public TreeNode(int val) {
			this.val = val;
		}
		public void setLeft(TreeNode left) {
			this.left = left;
		}
		public void setRight(TreeNode right) {
			this.right = right;
		}
	}
}
