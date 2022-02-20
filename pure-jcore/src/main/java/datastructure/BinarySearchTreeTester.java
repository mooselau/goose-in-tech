package datastructure;

/**
 * This is for testing BST data structure
 * 
 * @author MooseLiu
 *
 */
public class BinarySearchTreeTester {
	
	private BST<Item> bsTree = new BST<Item>();

	public static void main(String[] args) {
		BinarySearchTreeTester tester = new BinarySearchTreeTester();
//		tester.testItem();
		tester.insert();
		tester.print();
	}
	
	public void testItem() {
		Item a = new Item("a", 10);
		Item b = new Item("b", 12);
		p("a hashcode: " + a.hashCode());
		p("b hashcode: " + b.hashCode());
		p(a.equals(b) +"");
		System.out.println(a.compareTo(b));
	}
	
	public void insert() {
		Item item = new Item("a", 10);
		Item item1 = new Item("b", 12);
		Item item2 = new Item("c", 14);
		Item item3 = new Item("d", 16);
		Item item4 = new Item("e", 18);
		Item item5 = new Item("f", 20);
		// bsTree.insert(item).insert(item3).insert(item5).insert(item4).insert(item2).insert(item1);
		bsTree.insert(item).insert(item1);
	}
	
	public void delete() {
		
	}
	
	public void print() {
		bsTree.printAsGraph();
	}

	public void p (String msg) {
		System.out.println(msg);
	}
	
}
