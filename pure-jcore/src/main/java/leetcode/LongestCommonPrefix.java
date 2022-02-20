package leetcode;

/**
 * 14. Longest Common Prefix
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * <p>
 * Example 2:
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * <p>
 * Note:
 * All given inputs are in lowercase letters a-z.
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        LongestCommonPrefix tim = new LongestCommonPrefix();
        String ret = tim.longestCommonPrefix();
        tim.p("longest common prefix: " + ret);
    }

    public String longestCommonPrefix() {
//        String[] strArray = {"abc", "abd"};
//        String[] strArray = {"flower","flow","flight"};
//        String[] strArray = {"dog","racecar","car"};
		String[] strArray = {"aa","a"};
        return way1(strArray);
    }

    /*
     * For you to write
     */
    public String way1(String[] strs) {
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].contains(prefix) == false) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.length() == 0) return "";
            }
        }
        return prefix;
    }

    /*
     * This is standard solution to this problem
     */
    public String standardWay(String[] s) {
        return Answers.longestCommonPrefix(s);
    }

    /*
     * This is standard solution to this problem
     */
    public String smartWay(String[] s) {
        return null;
    }

    public void p(String msg) {
        System.out.println(msg);
    }
}
