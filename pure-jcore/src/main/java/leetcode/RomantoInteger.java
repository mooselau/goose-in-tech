package leetcode;

/**
 * 13. Roman to Integer
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * <p>
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
 * which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII.
 * Instead, the number four is written as IV. Because the one is before the five we subtract it making four.
 * The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is
 * used:
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * Input: "III"
 * Output: 3
 * <p>
 * Example 2:
 * Input: "IV"
 * Output: 4
 * <p>
 * Example 3:
 * Input: "IX"
 * Output: 9
 * <p>
 * Example 4:
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * <p>
 * Example 5:
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.
 */
public class RomantoInteger {

    public static void main(String[] args) {
        RomantoInteger tim = new RomantoInteger();
        int ret = tim.romanToInt();
        tim.p(ret + "");
    }

    public int romanToInt() {
//        String s = "XIV";
        String s = "MCMLXXXIV";
        return way0(s);
    }

    /*
     * For you to write
     */
    public int way0(String s) {
        int value = 0;
        String[] specials = {"IV", "IX", "XL", "XC", "CD", "CM"};

        for (String special : specials) {
            int index = 0;
            if (s.indexOf(special, index + 1) != -1) {
                value += convert(special);
            }
        }

        for (int i = 0; i < s.length(); i++) {
            String c = String.valueOf(s.charAt(i));
            value += convert(c);
        }

        return value;
    }

    private int convert(String s) {
        int value = 0;
        switch (s) {
            case "I":
                value = 1;
                break;
            case "V":
                value = 5;
                break;
            case "X":
                value = 10;
                break;
            case "L":
                value = 50;
                break;
            case "C":
                value = 100;
                break;
            case "D":
                value = 500;
                break;
            case "M":
                value = 1000;
                break;
            case "IV":
            case "IX":
                value = -2;
                break;
            case "XL":
            case "XC":
                value = -20;
                break;
            case "CD":
            case "CM":
                value = -200;
                break;
            default:
                throw new IllegalArgumentException("No letters found.");
        }
        return value;
    }

    /*
     * This is standard solution to this problem
     */
    public int standardWay(String s) {
        return Answers.romanToInt(s);
    }

    /*
     * This is smart solution to this problem
     */
    public int smartWay(String s) {
        return SmartAnswers.romanToInt(s);
    }

    public void p(String msg) {
        System.out.println(msg);
    }

}
