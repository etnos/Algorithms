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
     * <p>
     * Complexity: O(n!)
     *
     * @param defaultString     string with a given value
     * @param permutationPrefix substring with prefix value for a permutation
     * @param permList          placeholder for saving permutation results
     */
    protected void doPermutationRec(String defaultString, String permutationPrefix, ArrayList<String> permList) {
        if (defaultString.length() > 0) {
            for (int i = 0; i < defaultString.length(); i++) {
                String newDefaultString = removeCharByPosition(defaultString, i);
                String newPermutationPrefix = permutationPrefix + defaultString.charAt(i);
                doPermutationRec(newDefaultString, newPermutationPrefix, permList);
            }
        } else {
            // default string is empty, no more changes possible
            permList.add(permutationPrefix);
        }
    }

    /**
     * remove character by position in given string
     *
     * @param defaultString a given string
     * @param position      position of a character for removing
     * @return a string without removed character
     */
    private String removeCharByPosition(String defaultString, int position) {
        return defaultString.substring(0, position) + defaultString.substring(position + 1, defaultString.length());
    }
}
