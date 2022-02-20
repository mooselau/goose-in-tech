package leetcode;

import utils.StringUtilities;


/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 * Example:
 * Input: "babad"
 * Output: "bab"
 * 
 * Note: "aba" is also a valid answer.
 * 
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 * 
 * @author MooseLiu
 *
 */
public class LongestPalindromicSubstring {
	
	private static StringUtilities tools = StringUtilities.getInstance();
	
	public static void main(String[] args) {
		LongestPalindromicSubstring lps = new LongestPalindromicSubstring();
		String str1 = "gabacabah";
		String str2 = "abcda";
		String str3 = "aaabaaaa";
		String str4 = "ccc";
		String str5 = "aaaa";
		String str6 = "abcdfgdcba";
		String ret = lps.longestPalindrome(str6);
		tools.println(ret);
//		tools.println(lps.isStringPalindromic("abcb")+"");
	}
	
    public String longestPalindrome(String s) {
    		return way1(s);
    }
    
    /*
     * Way1 is comparing string with its reversed string and finding the longest common substring,
     * then, it is the longest palindromic substring.
     * e.g. "gabacabah" vs its reversed string "habacabag", the longest common string is "abacaba",
     * which is also the longest palindromic substring.
     * Time Complexity: 
     * 
     */
    private String way1(String s) {
    		String rs = reverseString(s);
    		LongestCommonSubstring lcs = new LongestCommonSubstring();
    		String commonStr = lcs.findCommonSubstring(s, rs, 2);
    		// for some coner case, the common substring is not palindromic string,
    		// e.g. abcdfgdcba vs abcdgfdcba -> LCS: abcd.
    		if (!isStringPalindromic(commonStr)) {
    			return commonStr.substring(0, 1); // return the first letter
    		}
    		return commonStr;
    }
    
    private boolean isStringPalindromic(String s) {
    		if (s.length() == 0) {
    			return true;
    		}
    		
    		int len = s.length();
    		boolean isEven = (len % 2 == 0) ? true : false;
    		
    		int i = 0, j = 0;
    		if (isEven) {
    			i = len / 2;
    			j = len / 2 - 1;
    		} else {
    			j = len /2;
    			i = len /2;
    		}
    		while(j >= 0 && i <= len - 1) {
    			if (s.charAt(i) != s.charAt(j)) {
    				return false;
    			}
    			i ++;
    			j --;
    		}
    		return true;
    }
    
    
    /**
     * Reverse all characters in a string.
     * @param s
     * @return
     */
    private String reverseString(String s) {
    		StringBuilder sb = new StringBuilder();
    		for(int i = s.length() - 1;i >= 0;i--) {
    			sb.append(String.valueOf(s.charAt(i)));
    		}
    		return sb.toString();
    }
    	
}
