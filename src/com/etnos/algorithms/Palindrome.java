package com.etnos.algorithms;

/**
 * A palindrome is a word, phrase, number, or other sequence of characters which reads the same backward or forward.
 * <br>Allowances may be made for adjustments to capital letters, punctuation, and word dividers.
 */
public class Palindrome {

    public static void main(String[] args) {
        Palindrome instance = new Palindrome();
        int value = 12344321;
        boolean result = instance.isPalindrome(value);
        System.out.println("Value " + value + " is palindrome " + result);

        String str = "abcccba";
        result = instance.isPalindrome(str);
        System.out.println("String " + str + " is palindrome " + result);

        str = "qweabcddcbaqrw";
        String longestPalindrome = instance.findLongestPalindrome(str);
        System.out.println("String " + str + " contains longest palindrome " + longestPalindrome);
    }


    /**
     * this method check is number a palindrome
     * <p>
     * 131 is a palindrome,
     * 123 is not
     *
     * @param number a value for checking
     * @return true if palindrome, false otherwise
     */
    protected boolean isPalindrome(int number) {
        int result = 0;
        int origin = number;
        int step;
        while (number != 0) {
            result = result * 10;
            step = number % 10;
            number = number / 10;
            result = result + step;
        }

        return origin == result;
    }

    /**
     * this method check is string a palindrome
     * "aba" is a palindrome,
     * "abc" is not
     *
     * @param str a value for checking
     * @return true if palindrome, false otherwise
     */
    protected boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }

        char[] chars = str.toCharArray();
        int length = str.length();
        for (int i = 0; i < length / 2; i++) {
            char right = chars[i];
            char left = chars[length - 1 - i];

            if (right != left) {
                return false;
            }
        }

        return true;
    }

    /**
     * this method checks for the longest palindrome in a given string
     * <p>
     * "acaabcba" a given string, longest palindrome is "abcba"
     *
     * @param str value for check
     * @return the longest palindrome
     */
    protected String findLongestPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        String result = "";
        for (int i = 1; i < str.length() - 1; i++) {
            String palindrome = findPalindrome(str, i, i);
            if (result.length() < palindrome.length()) {
                result = palindrome;
            }

            palindrome = findPalindrome(str, i, i + 1);
            if (result.length() < palindrome.length()) {
                result = palindrome;
            }
        }

        return result;
    }

    /**
     * find a palindrome in a given string starting with custom middle point
     *
     * @param str   a given string
     * @param left  position of a middle character for a left side of a palindrome
     * @param right position of a middle character for a right side of a palindrome
     * @return the longest palindrome starting with a custom middle point or empty string
     */
    private String findPalindrome(String str, int left, int right) {
        if (str == null || left < 0 || right >= str.length()) {
            return "";
        }

        if (str.length() == 1) {
            return str;
        }

        while (left >= 0 && right < str.length()) {
            char cLeft = str.charAt(left);
            char cRight = str.charAt(right);
            if (cRight == cLeft) {
                left--;
                right++;
            } else {
                return str.substring(left + 1, right);
            }
        }

        return "";
    }

}
