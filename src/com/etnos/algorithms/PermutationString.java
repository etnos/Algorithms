package com.etnos.algorithms;

import java.util.ArrayList;
import java.util.Arrays;


public class PermutationString {
    public static void main(String[] args) {
        PermutationString permutationString = new PermutationString();
        String string = "abc";

        ArrayList<String> permutationHolder = new ArrayList<>();

        System.out.println("Current string: " + string);

        System.out.println("loopPermutation: " + permutationString.loopPermutation(string));

        permutationHolder = permutationString.recursivePermutation(string);

        System.out.println("recursivePermutation: " + Arrays.toString(permutationHolder.toArray()));
    }

    protected String loopPermutation(String str) {
        String result = "";
        return result;
    }

    protected ArrayList<String> recursivePermutation(String str) {
        ArrayList<String> permList = new ArrayList<>();
        if (str != null && str.length() > 0) {
            doPermutationRec(str, permList);
        }
        return permList;
    }

    protected void doPermutationRec(String str, ArrayList<String> permList) {
        if (str.length() > 0) {

        }
    }
}
