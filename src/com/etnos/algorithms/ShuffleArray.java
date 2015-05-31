package com.etnos.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * This java program shuffle an array.
 * <p>
 * Array [1,2,3,4,5] -> [3,5,2,1,4]
 */
public class ShuffleArray {
    public static void main(String[] args) {
        ShuffleArray shuffleArray = new ShuffleArray();
        int[] array = new int[]{1, 2, 3, 4, 5};

        System.out.println("Current array: " + Arrays.toString(array));

        array = shuffleArray.shuffleArray(array);

        System.out.println("Shuffled array: " + Arrays.toString(array));
    }


    /**
     * Shuffle an array using "for" loop and Random. See {@link Random#nextInt(int)}
     * <p>
     * Complexity: O(n)
     *
     * @param defaultArray array of integers, can be null or empty.
     * @return shuffled array or default array
     */
    protected int[] shuffleArray(int[] defaultArray) {
        if (defaultArray != null && defaultArray.length > 0) {
            Random random = new Random();

            for (int i = 0; i < defaultArray.length; i++) {
                int position = random.nextInt(defaultArray.length);
                int temp = defaultArray[position];
                defaultArray[position] = defaultArray[i];
                defaultArray[i] = temp;
            }
        }

        return defaultArray;
    }
}
