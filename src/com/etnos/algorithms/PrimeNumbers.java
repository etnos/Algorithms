package com.etnos.algorithms;

/**
 * This java program calculates a prime numbers.
 * <p>
 * 2, 3, 5, 7, 11, 13, 17 ...
 */
public class PrimeNumbers {
    public static void main(String[] args) {
        PrimeNumbers instance = new PrimeNumbers();
        int amount = 10000;

        long l = System.currentTimeMillis();
        instance.printFirstXNumbers(amount);
        l = System.currentTimeMillis() - l;
        System.out.println("calculate first " + amount + " prime numbers takes time: " + l);

        l = System.currentTimeMillis();
        instance.printFirstXNumbersEnhanced(amount);
        l = System.currentTimeMillis() - l;
        System.out.println("calculate enhanced first " + amount + " prime numbers takes time: " + l);
    }

    /**
     * Search for a given amount of a prime numbers using {@link PrimeNumbers#isPrime(int)} method with O(n) complexity
     * <p>
     * Complexity: O(n^2)
     *
     * @param amount amount of a prime numbers for search
     */
    protected void printFirstXNumbers(int amount) {
        int count = 1;
        for (int i = 1; ; i++) {
            if (isPrime(i)) {
                count++;
                if (count == amount) {
                    break;
                }
            }
        }
    }

    /**
     * Search for a given amount of a prime numbers using {@link PrimeNumbers#isPrimeEnhanced(int)} method with O(log(n)) complexity
     * <p>
     * Complexity: O(n*log(n))
     *
     * @param amount amount of a prime numbers for search
     */
    protected void printFirstXNumbersEnhanced(int amount) {
        int count = 1;
        for (int i = 1; ; i++) {
            if (isPrimeEnhanced(i)) {
                count++;
                if (count == amount) {
                    break;
                }
            }
        }
    }

    /**
     * check if number is a prime
     * <p>
     * Complexity: O(n)
     *
     * @param number given value
     * @return true if a prime number, false otherwise
     */
    protected boolean isPrime(int number) {
        for (int i = 2; i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * check if number is a prime
     * <p>
     * Complexity: O(log(n))
     * <p>
     * Lets take some number 'X'. it has two potential dividers 'a' and 'b'.
     * <p>
     * So 'a' * 'b' = 'X'. There are only 3 possible types of 'a' and 'b':<br>
     * a > sqrt(X) > b ('a' bigger sqrt(X), 'b' less sqrt(X))<br> a < sqrt(X) < b ('a' less sqrt(X), 'b' bigger sqrt(X))<br> a = sqrt(X) = b ('a' equals sqrt(X), 'b' equals sqrt(X))
     * <p>
     * According this it is enough to check all numbers below or equal sqrt(X). <br>
     * Because it is not possible that 'a' and 'b' bigger than sqrt(X)<br>
     * If logic does not find 'a' or 'b' in the first half of set they are not exist in the second half
     *
     * @param number given value
     * @return true if a prime number, false otherwise
     */
    protected boolean isPrimeEnhanced(int number) {
        for (int i = 2; i * i < number; i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}
