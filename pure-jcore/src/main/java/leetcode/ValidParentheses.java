package leetcode;

/**
 * 20. Valid Parentheses
 * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
 *
 * An input string is valid if:
 *
 * Open brackets must be closed by the same type of brackets.
 * Open brackets must be closed in the correct order.
 * Note that an empty string is also considered valid.
 *
 * Example 1:
 * Input: "()"
 * Output: true
 *
 * Example 2:
 * Input: "()[]{}"
 * Output: true
 *
 * Example 3:
 * Input: "(]"
 * Output: false
 *
 * Example 4:
 * Input: "([)]"
 * Output: false
 *
 * Example 5:
 * Input: "{[]}"
 * Output: true
 */
public class ValidParentheses {
	public static void main(String[] args) throws Exception {
		ValidParentheses tim = new ValidParentheses();
		boolean ret = tim.isValid();
		tim.p("isValid: " + ret);
	}

	/*
	 * Function entry in Leet Code
	 */
    public boolean isValid() {
//    	String s = "([)]";
//		String s = "[({})]";
		String s = "]";
		return way1(s);
	}
	
	public boolean way1(String s) {
    	return false;
	}

	/*
	 * This is standard solution to this problem
	 */
	 public boolean standardWay(String s) {
	 	 return Answers.validParentheses(s);
	 }
	 
    public void p(String msg) {
    	System.out.println(msg);
    }
}
