package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;
import leetcode.AddTwoNumbers.ListNode;

public class Answers {
	
	public static int RemoveDuplicatesfromSortedArray(int[] nums) {
		int i = 0;
		int len = nums.length;
		// only copy the different in the next index of i
		for (int j=1; j<len; j++) {
			if (nums[j] != nums[i]) {
				i ++;
				nums[i] = nums[j];
			}
		}
		return i + 1;		
	}
	
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		AddTwoNumbers tim = new AddTwoNumbers();
		
	    // init node
	    ListNode dummyHead = tim.new ListNode(0);
	    ListNode p = l1, q = l2, currNode = dummyHead;
	    boolean carry = false;
	    
	    // loop to add every digit
	    while(p != null || q != null) {
	        
	        // get values and do addition
	        int x = (p != null) ? p.val : 0;
	        int y = (q != null) ? q.val : 0;
	        int sum = (carry == true) ? (1 + x + y) : (x + y);
	        
	        // save carry and this node
	        carry = (sum / 10 > 0) ? true : false;
	        
	        // move node
	        currNode.next = tim.new ListNode(sum % 10);
	        currNode = currNode.next;
	        p = (p != null) ? p.next : null;
	        q = (q != null) ? q.next : null;
	    }
	    
	    if (carry) {
	        currNode.next = tim.new ListNode(1);
	    }
	    
	    return dummyHead.next;
	}
	
	public static int romanToInt(String s) {
		char[] chars = s.toCharArray();
		
		int trueNumber = 0;
		for (int i=0;i<chars.length;) {
			int digit = romanToIntConvert(chars[i]);
			
			// if this is last digit, no [i+1] for the next
			if (i == chars.length - 1) {
				return trueNumber += digit;
			}
			
			int nextDigit = romanToIntConvert(chars[i + 1]);
			if (nextDigit > digit) {
				trueNumber += (nextDigit - digit);
				i += 2;
			} else {
				trueNumber += digit;
				i ++;
			}
		}
		
		return trueNumber;
	}
	
	private static int romanToIntConvert(char c) {
		switch(c) {
		case 'I':
			return 1;
		case 'V':
			return 5;
		case 'X':
			return 10;
		case 'L':
			return 50;
		case 'C':
			return 100;
		case 'D':
			return 500;
		case 'M':
			return 1000;
		default:
			throw new RuntimeException("Illegal char");
		}
	}
	
    public static boolean isPalindrome(int x) {
		int target = x;
		int temp = 0;
		if (x < 0) {
			return false;
		}
		while (target != 0) {
			temp = temp * 10 + target % 10;
			target = target / 10;
		}
		return temp == x;
    }

	/**
	 * Time: O(n), Space: more memory is needed for HashMap.
	 */
	public static int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.get(complement) != null) {
				int index = map.get(complement);
				return new int[] {i, index};
			} else {
				map.put(nums[i], i);
			}
		}
		throw new IllegalArgumentException("No indexes were found.");
	}
	
	public static int reverseInteger(int x) {

		int rev = 0;
		
		/* rest and pop might be negative during the processing.
		 * It is not recommended convert rest to "positive",
		 * as ANY manipulation might cause overflow;
		 * e.g. if x = MIN_Value; rest = x * -1; then rest is still Min_Value, as it overflows. 
		 * */
		int rest = x;

		int pop = rest % 10;

		// check the rest number, it is 0 when reaches the end.
		while (rest != 0) {

			pop = rest % 10; // + or -

			rest /= 10;

			// overflow check.
			if ((rev > Integer.MAX_VALUE / 10) || (rev < Integer.MIN_VALUE / 10) ) {
				return 0;
			}

			// overflow check. when reversed num equals the Max_value mod 10,
			// then the pop number has to be smaller than "7" to not be
			// overflowed.
			if ((rev == Integer.MAX_VALUE / 10 && pop > 7) || (rev == Integer.MIN_VALUE / 10 && pop < -8)) {
				return 0;
			}
			
			/*
			 * there is another case that, when reversed num is less than
			 * MAX_VALUE. Be noted that, integer is not having decimals, hence
			 * reversed number will never greater than the MAX_VALUE, even if
			 * multiplied 10. 
			 * 
			 * if rev < Integer.Max_Value / 10; => rev * 10 < Max_Value; 
			 * cuz they are integers => rev < or = Max_Value / 10 - 1;
			 * so (rev + 1) * 10 < or = Max_Value; => rev * 10 + 10 < or = Max_Value; 
			 * because the pop number only less than or equals "9",
			 * so in this case, rev will never greater than Max_Value;
			 * 
			 */
			
			rev = rev * 10 + pop;
		}
		
		return rev;
	}

	public static String longestCommonPrefix(String[] strs) {
		if (strs.length == 0) return "";
		String prefix = strs[0];
		for (int i = 1; i < strs.length; i++)
			while (strs[i].indexOf(prefix) != 0) {
				prefix = prefix.substring(0, prefix.length() - 1);
				if (prefix.isEmpty()) return "";
			}
		return prefix;
	}

	public static boolean validParentheses(String s) {
		if (s.isEmpty()) {
			return true;
		}
		Stack<Character> stack = new Stack<>();
		for (int i = 0; i < s.length(); i++) {
			char c = s.charAt(i);
			if (isOpposite(c)) {
				char op = opposite(c);
				if (stack.isEmpty()) return false;
				if (stack.peek() != op) {
					return false;
				} else {
					stack.pop();
					continue;
				}
			} else {
				stack.push(c);
			}
		}
		return stack.isEmpty() ? true : false;
	}

	private static boolean isOpposite(char c) {
		char[] cs= {')', ']', '}'};
		return String.valueOf(cs).contains(String.valueOf(c));
	}

	private static char opposite(char c) {
		char ret = ' ';
		switch(c) {
			case ')':
				ret = '(';
				break;
			case ']':
				ret = '[';
				break;
			case '}':
				ret = '{';
				break;
			default:
				throw new IllegalArgumentException("Character not found.");
		}
		return ret;
	}
	
}
