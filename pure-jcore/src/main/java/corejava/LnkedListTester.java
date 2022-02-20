package corejava;

public class LnkedListTester {
	
	static LnkedListTester llt = new LnkedListTester();
	static Node head = llt.new Node(0);
	static Node tail = head;
	
	public static void main(String[] args) {
		llt.buildList();
		llt.printList();
		llt.removeNode(2);
		llt.printList();
	}
	
	public void removeNode(int val) {
		Node target = searchNode(val);
		Node next = target.next;
		target.value = next.value;
		target.next = next.next;
	}
	
	public void buildList() {
		for (int i=1;i<=4;i++) {
			Node n = new Node(i);
			insertNode(n);
		}
	}
	
	public void insertNode(Node n) {
		tail.next = n;
		tail = n;
	}
	
	public Node searchNode(int num) {
		Node c = head.next;
		while(c != null) {
			if (c.value == num) {
				return c;
			}
			c = c.next;
		}
		return null;
	}
	
	public void printList() {
		Node n = head.next;
		System.out.println();
		while(n != null) {
			System.out.print(n.value + " ");
			n = n.next;
		}
	}
	
	class Node {
		int value;
		Node next;
		Node(int value) {
			this.value = value;
		}
	}
	
}
