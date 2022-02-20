package leetcode;

import utils.StringUtilities;


/**
 * This class is related to a classic problem : LCS problem.
 * Given two strings, find the longest common substring in them.
 * For example,
 * s1 : abcdefg, s2 : bcdefgh, the longest common string is : bcdefg
 *
 * @author MooseLiu
 */
public class LongestCommonSubstring {

    private static StringUtilities tools;

    static {
        tools = StringUtilities.getInstance();
    }

    public static void main(String[] args) {
        // running junit test cases
        //Result result = JUnitCore.runClasses(LongestCommonSubstringTests.class);
        //for (Failure failure : result.getFailures()) {
        //System.out.println(failure.toString());
        //}
        LongestCommonSubstring lcs = new LongestCommonSubstring();
        String s1 = "abcdfgdcba";
        String s2 = "abcdgfdcba";
        tools.println("LCS is: " + lcs.findCommonSubstring(s1, s2));
    }

    /**
     * Using brute force approach to find the longest common substring (not includes the original string) in two strings.
     *
     * @param s1 the first string
     * @param s2 the second string
     * @return the longest common substring, or an empty string if no common substring was found
     */
    public String findCommonSubstring(String s1, String s2) {
        // return way2(s1, s2);
        return way1(s1, s2);
    }

    /**
     * Find the longest common substring (not includes the original string) in two strings.
     *
     * @param s1           the first string
     * @param s2           the second string
     * @param methodNumber 1 means way1 (brute force), otherwise means way2 (improved brute force);
     * @return the longest common substring, or an empty string if no common substring was found
     */
    public String findCommonSubstring(String s1, String s2, int methodNumber) {
        int methodNum = (methodNumber != 1) ? 2 : 1;
        return (methodNum == 1) ? way1(s1, s2) : way2(s1, s2);
    }

    /**
     * This is way 1 of using brute force approach to solve the problem.
     * Time complexity: O(n^3).
     * Space complexity: O(n).
     */
    private String way1(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int commonStrStart = -1, commonStrEnd = -1, commonStrLen = -1;
        String commonStr = "";

        // nested loops to find the subject
        for (int i = 0; i < len1; i++) {

            for (int j = 0; j < len2; j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                if (c1 == c2) {
                    // if chars are equal, then go to find the substring
                    int ind1 = i, ind2 = j; // comparison starts from next chars
                    while (c1 == c2) {
                        if (ind1 == i) {
                            commonStrStart = commonStrEnd = i;
                        } else {
                            commonStrEnd += 1; // key
                        }

                        if (++ind1 >= len1 || ++ind2 >= len2) {
                            break;
                        }

                        c1 = s1.charAt(ind1);
                        c2 = s2.charAt(ind2);
                    }

                    // when ind1 >= len1 or ind2 >= len2 or c1 != c2
                    // save the longer substring and reset indicators
                    if (commonStrEnd - commonStrStart + 1 > commonStr.length()) {
                        commonStr = s1.substring(commonStrStart, commonStrEnd + 1);
                    }
                    commonStrStart = commonStrEnd = -1;
                }
            }
        }
        return commonStr;
    }

    /**
     * Key equation:
     * K[i+1,j+1] = (A[i+1] == B[j+1]) ? K[i,j] : 0;
     * <p>
     * Draw a 2D array to save equal pairs and then find the sequential substring using the 2D array.
     * <p>
     * Time complexity: O(n^2).
     * Space complexity: O(n^2).
     */
    private String way2(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        int commonStrStart = -1, commonStrEnd = -1, commonStrLen = -1;
        String commonStr = "";
        int[][] ret = new int[len1][len2]; // 2D arrays to store K[i, j]

        // nested loops to find the subject
        for (int i = 0; i < len1; i++) {

            for (int j = 0; j < len2; j++) {
                char c1 = s1.charAt(i);
                char c2 = s2.charAt(j);

                // maintenance the table
                if (i > 0 && j > 0) {
                    ret[i][j] = (c1 == c2) ? ret[i - 1][j - 1] + 1 : 0;
                } else {
                    // either i or j is 0
                    ret[i][j] = (c1 == c2) ? 1 : 0;
                }

                // return the letter in case if just one letter same
                if (ret[i][j] == 1 && commonStr.length() == 0) {
                    commonStr = String.valueOf(c1);
                }

                // find the substring according to current value
                if (ret[i][j] > 1) {
                    commonStrEnd = i; // !!Note this is the end position
                    commonStrStart = i - (ret[i][j] - 1); // !!Note this is the start position
                    commonStrLen = ret[i][j];
                    if (commonStrLen > commonStr.length()) {
                        commonStr = s1.substring(commonStrStart, commonStrEnd + 1);
                    }
                }
            }
        }
        return commonStr;
    }

}
