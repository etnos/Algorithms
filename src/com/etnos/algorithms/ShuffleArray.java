package com.etnos.algorithms;

import java.util.Arrays;
import java.util.Random;

/**
 * Created by Illia on 5/30/2015.
 */
public class ShuffleArray {
    public static void main(String[] args){
        ShuffleArray shuffleArray = new ShuffleArray();
        int[] array = new int[]{1,2,3,4,5};

        array = shuffleArray.shuffleArray(array);

        System.out.println(Arrays.toString(array));
    }

    protected int[] shuffleArray(int[] defaultArray) {
        Random random = new Random();

        for (int i = 0; i < defaultArray.length; i++) {
            int position = random.nextInt(defaultArray.length);
            int temp = defaultArray[position];
            defaultArray[position] = defaultArray[i];
            defaultArray[i] = temp;
        }

        return defaultArray;
    }
}
