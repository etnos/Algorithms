package com.etnos.algorithms;

import java.util.HashMap;

/**
 * This java program calculates a fibonacci sequence.
 * <p>
 * n =	1	2	3	4	5	6	7	8	9	10	11	12	13	14	...
 * <p>
 * x =	1	1	2	3	5	8	13	21	34	55	89	144	233	377	...
 * <p>
 * <p>
 * Fibonacci for 4 equals 3, for 7 equals 13
 */
public class Fibonacci {
    HashMap<Integer, Integer> fibonacciSequenceHashMap = new HashMap<>();

    public static void main(String[] args) {
        Fibonacci fibonacci = new Fibonacci();
        int position = 45;

        System.out.println("Fibonacci position: " + position);

        long l = System.currentTimeMillis();
        int result = fibonacci.fibonacciIterate(position);
        l = System.currentTimeMillis() - l;

        System.out.println("Fibonacci iterate result: " + result + " time(ms): " + l);

        l = System.currentTimeMillis();
        result = fibonacci.fibonacciRecursive(position);
        l = System.currentTimeMillis() - l;

        System.out.println("Fibonacci recursive result: " + result + " time(ms): " + l);

        l = System.currentTimeMillis();
        result = fibonacci.fibonacciRecursiveEnhanced(position);
        l = System.currentTimeMillis() - l;

        System.out.println("Fibonacci recursive enhanced result: " + result + " time(ms): " + l);
    }

    /**
     * Iterative logic for calculating Fibonacci sequence
     * <p>
     * Complexity: O(n)
     *
     * @param sequencePosition position is a Fibonacci sequence
     * @return number from the Fibonacci sequence with a given position
     */
    protected int fibonacciIterate(int sequencePosition) {
        if (sequencePosition == 1 || sequencePosition == 2) {
            return 1;
        }
        int result = 1;
        int first = 1;
        int second = 1;
        for (int i = 3; i <= sequencePosition; i++) {
            result = first + second;
            first = second;
            second = result;
        }

        return result;
    }

    /**
     * Recursive logic for calculating Fibonacci sequence
     * <p>
     * Complexity: O(2^n)
     *
     * @param sequencePosition position in a Fibonacci sequence
     * @return number from the Fibonacci sequence with a given position
     */
    protected int fibonacciRecursive(int sequencePosition) {
        if (sequencePosition == 1 || sequencePosition == 2) {
            return 1;
        }

        return fibonacciRecursive(sequencePosition - 1) + fibonacciRecursive(sequencePosition - 2);
    }

    /**
     * Recursive logic for calculating Fibonacci sequence. Enhanced by using HashMap
     * <p>
     * Complexity: O(n)
     *
     * @param sequencePosition position in a Fibonacci sequence
     * @return number from the Fibonacci sequence with a given position
     */
    protected int fibonacciRecursiveEnhanced(int sequencePosition) {
        if (sequencePosition == 1 || sequencePosition == 2) {
            return 1;
        }

        int fibonacciResult = getFibonacciByPosition(sequencePosition);
        if (fibonacciResult == 0) {
            fibonacciResult = fibonacciRecursiveEnhanced(sequencePosition - 1) + fibonacciRecursiveEnhanced(sequencePosition - 2);
            fibonacciSequenceHashMap.put(sequencePosition, fibonacciResult);
        }

        return fibonacciResult;
    }

    /**
     * Check {@link Fibonacci#fibonacciSequenceHashMap} for a given position
     * <p>
     * Complexity: O(1)
     *
     * @param position given position
     * @return value for a given position or 0
     */
    private int getFibonacciByPosition(int position) {
        Integer fibonacciResult = fibonacciSequenceHashMap.get(position);
        if (fibonacciResult != null) {
            return fibonacciResult;
        }
        return 0;
    }


}
