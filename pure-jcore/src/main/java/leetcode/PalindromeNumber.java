package leetcode;

/**
 * Determine whether an integer is a palindrome.
 * An integer is a palindrome when it reads the same backward as forward.
 * <p>
 * Example 1:
 * Input: 121
 * Output: true
 * <p>
 * Example 2:
 * Input: -121
 * Output: false
 * Explanation: From left to right, it reads -121.
 * From right to left, it becomes 121-. Therefore it is not a palindrome.
 * <p>
 * Example 3:
 * Input: 10
 * Output: false
 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
 * <p>
 * Follow up:
 * Could you solve it without converting the integer to a string?
 */
public class PalindromeNumber {

    public static void main(String[] args) {
        PalindromeNumber tim = new PalindromeNumber();
        boolean ret = tim.isPalindrome();
        tim.p(ret + "");
    }

    public boolean isPalindrome() {
        int x = 1;
        return way0(x);
    }

    /*
     * For you to write
     */
    public boolean way0(int x) {
        return false;
    }

    /*
     * This is standard solution to this problem.
     */
    public boolean standardWay(int x) {
        return Answers.isPalindrome(x);
    }

    /**
     * This is smart solution to this problem.
     */
    public boolean smartWay(int x) {
        return SmartAnswers.PalindromeNumber(x);
    }

    public void p(String msg) {
        System.out.println(msg);
    }

}
