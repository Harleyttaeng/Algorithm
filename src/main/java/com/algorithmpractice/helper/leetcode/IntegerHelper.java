package com.algorithmpractice.helper.leetcode;

import java.util.*;
import java.util.stream.Collectors;

public class IntegerHelper {
    /**
     * 7. Reverse Integer
     * Given a signed 32-bit integer x, return x with its digits reversed.
     * If reversing x causes the value to go outside the signed 32-bit integer range [-231, 231 - 1], then return 0.
     * Assume the environment does not allow you to store 64-bit integers (signed or unsigned).
     *
     * @return reversed integer
     */
    public static int reverse(int x) {
        long result = 0;
        int sign = x < 0 ? -1 : 1;
        long xPositive = x < 0 ? -1 * x : x;
        int xAux = (int) xPositive;
        int length = (int) (Math.log10(xPositive) + 1);

        for (int i = 1; i <= length; i++) {
            result = (long) (result + xAux % 10 * Math.pow(10, length - i));
            xAux = xAux / 10;
        }
        result = result * sign;

        if (result > Integer.MAX_VALUE || result < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) result;
    }

    /**
     * 9. Palindrome Number
     * Given an integer x, return true if x is palindrome integer.
     * An integer is a palindrome when it reads the same backward as forward. For example, 121 is palindrome while 123 is not.
     *
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

        for (int i = length - 1; i >= 0; i--) {
            result = (long) (result + xAux % 10 * Math.pow(10, i));
            xAux = xAux / 10;
        }
        return x == result;
    }

    /**
     * 15. 3Sum
     * -
     * Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * <p>
     * Notice that the solution set must not contain duplicate triplets.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        int pA;

        int lo;
        int hi;
        int sumAux;

        List<List<Integer>> output = new ArrayList<>();

        Arrays.sort(nums);
        int inputLength = nums.length;

        for (int i = 0; i < inputLength - 2; i++) {
            pA = nums[i];
            if (i > 0 && pA == nums[i - 1]) {
                continue;
            }
            int target = -pA;
            lo = i + 1;
            hi = inputLength - 1;
            while (lo < hi) {
                sumAux = nums[lo] + nums[hi];
                if (sumAux > target) {
                    hi--;
                } else if (sumAux < target) {
                    lo++;
                } else {
                    if (nums[lo] == nums[lo - 1] && hi < inputLength - 1 && nums[hi] == nums[hi + 1]) {
                        lo++;
                        hi--;
                        continue;
                    }
                    output.add(Arrays.asList(pA, nums[lo], nums[hi]));
                    lo++;
                    hi--;
                }
            }

        }
        return output;
    }

    public static int[] convertHexToBinary(int n) {
        Stack<Integer> bitsCollection = new Stack<Integer>();
        int dividend = n;
        int bit;
        while (dividend != 0) {
            bit = dividend % 2 == 0 ? 0 : 1;
            bitsCollection.push(bit);
            dividend = dividend / 2;
        }
        int bitsCollectionLength = bitsCollection.size();

        int[] result = new int[bitsCollectionLength];
        for (int i=0;i<bitsCollectionLength;i++){
            result[i] = bitsCollection.pop();
        }
        return result;
    }

    public static int convertHexToBinary1Counter(int n) {
        int dividend = n;
        int result = 0;

        while (dividend != 0) {
            result = dividend % 2 == 0 ? result : result+1;
            dividend = dividend / 2;
        }
        return result;
    }

    /**
     * 338. Counting bits
     * Given an integer n, return an array ans of length n + 1 such that for each i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
     */
    public static int[] countBits(int n) {
        int[] result = new int[n+1];
        for (int j = 0; j <= n; j++) {
            result[j] = convertHexToBinary1Counter(j);
        }
        return result;
    }
}
