package com.etnos.algorithms;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * This java program makes a string permutation.
 * <p>
 * String "abc" -> [abc, acb, bac, bca, cab, cba]
 */
public class PermutationString {
    public static void main(String[] args) {
        PermutationString permutationString = new PermutationString();
        String string = "abc";

        System.out.println("Current string: " + string);

        ArrayList<String> permutationHolder = permutationString.recursivePermutation(string);

        System.out.println("Permutation size: " + permutationHolder.size());

        System.out.println("recursivePermutation: " + Arrays.toString(permutationHolder.toArray()));
    }

    /**
     * Check a given string and call {@link #doPermutationRec(String, String, ArrayList)} to calculate permutation
     *
     * @param str a given sting for a permutation. can be null or empty
     * @return list of permuted strings or empty list
     */
    protected ArrayList<String> recursivePermutation(String str) {
        ArrayList<String> permList = new ArrayList<>();
        if (str != null && str.length() > 0) {
            doPermutationRec(str, "", permList);
        }
        return permList;
    }

    /**
     * Process all permutation of a given string. Uses recursion to calculate all permutations
     *
     * @param defaultString     string with a given value
     * @param permutationPrefix substring with prefix value for a permutation
     * @param permList          placeholder for saving permutation results
     */
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
