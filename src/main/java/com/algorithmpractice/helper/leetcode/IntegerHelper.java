package com.algorithmpractice.helper.leetcode;

public class IntegerHelper {
    /**
     * 7. Reverse Integer
     * Given a signed 32-bit integer x, return x with its digits reversed. 
     * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     * @return reversed integer
     */
    public static int reverse(int x) {
        long result = 0;
        int sign = x < 0 ? -1 : 1;
        long xPositive = x < 0 ? -1 * x : x;
        int xAux = (int) xPositive;
        int length = (int)(Math.log10(xPositive)+1);
        
        for (int i = 1; i<=length; i++) {
            result = (long) (result + xAux % 10 * Math.pow(10, length - i));
            xAux = xAux / 10;
        }
        result = result * sign;
        
        if (result>Integer.MAX_VALUE || result<Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    /**
     * 9. Palindrome Number
     * Given an integer x, return true if x is palindrome integer.
     * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
     * @param x input integer
     * @return if input is a palindrome number
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        } else if (x == 0) {
            return true;
        }
        
        long result = 0;
        int xAux = x;
        int length = (int) (Math.log10(x) + 1);
        
        for (int i = length-1; i>=0; i--) {
            result = (long) (result + xAux % 10 * Math.pow(10, i));
            xAux = xAux / 10;
        }
        return x == result;
    }
    
}
