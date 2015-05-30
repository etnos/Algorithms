package com.etnos.algorithms;

import java.util.ArrayList;
import java.util.Arrays;


public class PermutationString {
    public static void main(String[] args) {
        PermutationString permutationString = new PermutationString();
        String string = "abcd";

        System.out.println("Current string: " + string);

        ArrayList<String> permutationHolder = permutationString.recursivePermutation(string);

        System.out.println("recursivePermutation: " + Arrays.toString(permutationHolder.toArray()));
    }

    protected ArrayList<String> recursivePermutation(String str) {
        ArrayList<String> permList = new ArrayList<>();
        if (str != null && str.length() > 0) {
            doPermutationRec(str, "", permList);
        }
        return permList;
    }

    protected void doPermutationRec(String defaultString, String permutationPrefix, ArrayList<String> permList) {
        if (defaultString.length() > 0) {
            for (int i = 0; i < defaultString.length(); i++) {
                String newDefaultString = defaultString.substring(0, i) + defaultString.substring(i + 1, defaultString.length());
                String newPermutationPrefix = permutationPrefix + defaultString.charAt(i);
                doPermutationRec(newDefaultString, newPermutationPrefix, permList);
            }
        } else {
            permList.add(permutationPrefix);
        }
    }
}
