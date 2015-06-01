package com.etnos.algorithms;

/**
 * An Armstrong number of three digits is an integer such that the sum of the cubes of its digits is equal to the number itself.
 * <br>
 * For example, 371 is an Armstrong number since 3**3 + 7**3 + 1**3 = 371
 */
public class ArmStrongNumber {
    public static void main(String[] args) {
        ArmStrongNumber armStrongNumber = new ArmStrongNumber();
        int number = 371;
        boolean result = armStrongNumber.isArmStrong(number);

        System.out.println("Number " + number + " is Arm Strong " + result);

    }

    protected boolean isArmStrong(int number) {
        if (number < 100 && number > 999) {
            return false;
        }
        int origin = number;
        int result = 0;
        int reminder;
        while (number != 0) {
            reminder = number % 10;
            result = result + reminder * reminder * reminder;
            number = number / 10;
        }


        return result == origin;
    }
}
