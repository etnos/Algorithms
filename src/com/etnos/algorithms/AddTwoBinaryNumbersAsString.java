package com.etnos.algorithms;

/**
 * This java program calculates a sum of a two binary numbers represented as strings.
 * <p>
 * String first = "1110";
 * String second = "1011";
 * first + second = "1110" + "1011" = "11001"
 */
public class AddTwoBinaryNumbersAsString {
    public static void main(String[] args) {
        AddTwoBinaryNumbersAsString instance = new AddTwoBinaryNumbersAsString();
        String first = "1110";
        String second = "1011";
        String result;

        result = instance.addTwoBinaries(first, second);
        System.out.println(result);
    }

    /**
     * Adds two binary numbers represented as strings
     *
     * @param first  the first number. Can not be null
     * @param second the second number. Can not be null
     * @return a sum of a two binary numbers
     * @throws IllegalArgumentException if one of the arguments is null
     */
    protected String addTwoBinaries(String first, String second) {
        if (first == null || second == null) {
            throw new IllegalArgumentException("arguments can not be null");
        }

        if (first.length() == 0) {
            return second;
        } else if (second.length() == 0) {
            return first;
        }

        String result = "";
        int length = first.length();
        if (second.length() > length) {
            length = second.length();
        }

        int bitOne, bitTwo, temp, carry = 0;
        for (int i = 0; i < length; i++) {
            bitOne = getBit(first, first.length() - 1 - i);
            bitTwo = getBit(second, second.length() - 1 - i);

            temp = bitOne + bitTwo + carry;

            if (temp == 0 || temp == 1) {
                carry = 0;
                result = temp + result;
            } else if (temp == 2) {
                carry = 1;
                result = '0' + result;
            } else {
                carry = 1;
                result = '1' + result;
            }
        }

        if (carry == 1) {
            result = '1' + result;
        }

        return result;
    }

    /**
     * Tries to get bit from a binary number represented as string.
     *
     * @param holder   a binary number represented as string
     * @param position position of a bit that should be returned
     * @return int value of a bit from a binary number represented as string. Returns 0 if position not fits into binary number length
     */
    private int getBit(String holder, int position) {
        if (position < 0 || position >= holder.length()) {
            return 0;
        }
        char c = holder.charAt(position);
        return c - '0';

    }
}
