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

        String str = "abccba";
        result = instance.isPalindrome(str);
        System.out.println("String " + str + " is palindrome " + result);
    }


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

    protected boolean isPalindrome(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        if (str.length() == 1) {
            return true;
        }

        char[] chars = str.toCharArray();
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char first = chars[i];
            char last = chars[length - 1 - i];

            if (i >= length - 1 - i) {
                break;
            }

            if (first != last) {
                return false;
            }
        }

        return true;
    }

    protected String findLongestPalindrome(String str) {
        if (str == null || str.length() <= 1) {
            return str;
        }

        boolean isEven = str.length() % 2 == 0;

        for (int i = 1; i < str.length() - 1; i++) {

        }


    }
}
