package com.etnos.algorithms;

/**
 * This class keeps a few of Math formulas
 */
public class Math {

    public static void main(String[] args) {
        Math math = new Math();
        int a = 159;
        int b = 45;
        int result = math.findGreatCommonDivisor(a, b);

        System.out.println("The greatest common divisor for " + a + " and " + b + " is " + result);

        result = math.findLeastCommonMultiple(a, b);

        System.out.println("The least common multiple for " + a + " and " + b + " is " + result);
    }

    /**
     * In mathematics, the greatest common divisor (gcd) of two or more integers,
     * when at least one of them is not zero, is the largest positive integer that
     * divides the numbers without a remainder. For example, the GCD of 8 and 12 is 4.
     *
     * @param a
     * @param b
     * @return
     */
    protected int findGreatCommonDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return findGreatCommonDivisor(b, a % b);
    }

    /**
     * The least common multiple (LCM) of two numbers is the smallest number (not zero) that is a multiple of both.
     */
    protected int findLeastCommonMultiple(int a, int b) {
        return a * (b / findGreatCommonDivisor(a, b));
    }


}
