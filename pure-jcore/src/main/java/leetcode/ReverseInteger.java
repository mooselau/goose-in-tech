package leetcode;

/**
 * Given a 32-bit signed integer, reverse digits of an integer.
 * Example 1:
 * Input: 123
 * Output: 321
 *
 * Example 2:
 * Input: -123
 * Output: -321
 *
 * Example 3:
 * Input: 120
 * Output: 21
 * Note:
 * Assume we are dealing with an environment which could only store integers within the 32-bit
 * signed integer range: [−2^31,  2^31 − 1]. For the purpose of this problem, assume that your function returns 0
 * when the reversed integer overflows.
 */
public class ReverseInteger {

    public static void main(String[] args) {
        ReverseInteger tim = new ReverseInteger();
        int ret = tim.reverse();
        p("Answer: " + ret);
        p("Max: " + Integer.MAX_VALUE + ", MIN: " + Integer.MIN_VALUE);
    }

    public int reverse() {
//        int x = 2147483647;
//		int x = -2147483648;
//        int x = -120;
        int x = 321;
        return way0(x);
    }

    /*
     * For you to write
     */
    public int way0(int x) {
        return 0;
    }

    /*
     * This is standard solution to this problem
     */
    public int standardWay(int x) {
        return Answers.reverseInteger(x);
    }

    public static void p(String msg) {
        System.out.println(msg);
    }

}
