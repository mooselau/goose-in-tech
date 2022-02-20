package leetcode;

public class SmartAnswers {

    /*
     * This solution is clear and clever. It calculates the subtractions and
     * then simply adding ALL numbers.
     */
    public static int romanToInt(String s) {
        int sum = 0;
        if (s.indexOf("IV") != -1) {
            sum -= 2;
        }
        if (s.indexOf("IX") != -1) {
            sum -= 2;
        }
        if (s.indexOf("XL") != -1) {
            sum -= 20;
        }
        if (s.indexOf("XC") != -1) {
            sum -= 20;
        }
        if (s.indexOf("CD") != -1) {
            sum -= 200;
        }
        if (s.indexOf("CM") != -1) {
            sum -= 200;
        }

        char c[] = s.toCharArray();
        int count = 0;

        for (; count <= s.length() - 1; count++) {
            if (c[count] == 'M')
                sum += 1000;
            if (c[count] == 'D')
                sum += 500;
            if (c[count] == 'C')
                sum += 100;
            if (c[count] == 'L')
                sum += 50;
            if (c[count] == 'X')
                sum += 10;
            if (c[count] == 'V')
                sum += 5;
            if (c[count] == 'I')
                sum += 1;

        }
        return sum;
    }

    public static boolean PalindromeNumber(int x) {
        // Special cases:
        // As discussed above, when x < 0, x is not a palindrome.
        // Also if the last digit of the number is 0, in order to be a palindrome,
        // the first digit of the number also needs to be 0.
        // Only 0 satisfy this property.
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int revertedNumber = 0;
        while (x > revertedNumber) {
            revertedNumber = revertedNumber * 10 + x % 10;
            x /= 10;
        }

        // When the length is an odd number, we can get rid of the middle digit by revertedNumber/10
        // For example when the input is 12321, at the end of the while loop we get x = 12, revertedNumber = 123,
        // since the middle digit doesn't matter in palidrome(it will always equal to itself), we can simply get rid of
        // it.
        return x == revertedNumber || x == revertedNumber / 10;
    }
}
