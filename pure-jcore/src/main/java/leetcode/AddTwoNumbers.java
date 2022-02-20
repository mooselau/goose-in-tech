package leetcode;

public class AddTwoNumbers {
	
	public static void main(String[] args) {
		AddTwoNumbers tim = new AddTwoNumbers();
		ListNode ret = tim.addTwoNumbers();

		tim.p("output: ");
		while(ret != null) {
			tim.p(" -> " + ret.val);
			ret = ret.next;
		}
		
	}
	
    public ListNode addTwoNumbers() {
    	
    	// test case 342 + 465 = 807
    	ListNode m1 = new ListNode(2);
    	ListNode m2 = new ListNode(4);
    	ListNode m3 = new ListNode(3);
    	m1.next = m2;
    	m2.next = m3;
    	
    	ListNode n1 = new ListNode(5);
    	ListNode n2 = new ListNode(6);
    	ListNode n3 = new ListNode(4);
    	n1.next = n2;
    	n2.next = n3;
    	
    	// test case 1 + 99 = 100
//    	ListNode m1 = new ListNode(1);
//    	
//    	ListNode n1 = new ListNode(9);
//    	ListNode n2 = new ListNode(9);
//    	n1.next = n2;
    	
    	// test case 73 + 29 = 102
//    	ListNode m1 = new ListNode(3);
//    	ListNode m2 = new ListNode(7);
//    	m1.next = m2;
//    	
//    	ListNode n1 = new ListNode(9);
//    	ListNode n2 = new ListNode(2);
//    	n1.next = n2;
    	
    	return way1(m1,n1);
    } 
	
	/*
	 * For you to write
	 */
	public ListNode way1(ListNode l1, ListNode l2) {
		return null;
	}

	/*
	 * This is standard solution to this problem
	 */
	 public ListNode standardWay(ListNode l1, ListNode l2) {
		 return Answers.addTwoNumbers(l1, l2);
	 }
    
    public void p(String msg) {
    	System.out.print(msg);
    }

    public class ListNode {
    	int val;
    	ListNode next;
    	ListNode(int x) { val = x; }
	}
    
}
