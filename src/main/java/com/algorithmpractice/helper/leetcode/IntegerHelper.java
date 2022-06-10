package com.algorithmpractice.helper.leetcode;

import java.util.*;

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
     * 13. Roman to Integer
     * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
     *
     * Symbol       Value
     * I             1
     * V             5
     * X             10
     * L             50
     * C             100
     * D             500
     * M             1000
     * For example, 2 is written as II in Roman numeral, just two ones added together. 12 is written as XII, which is simply X + II. The number 27 is written as XXVII, which is XX + V + II.
     *
     * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:
     *
     * I can be placed before V (5) and X (10) to make 4 and 9.
     * X can be placed before L (50) and C (100) to make 40 and 90.
     * C can be placed before D (500) and M (1000) to make 400 and 900.
     * Given a roman numeral, convert it to an integer.
     *
     * @param s
     * @return Output integer
     */
    public static int romanToInt(String s) {
        int result = 0;
        Set<String> specialLetters = new HashSet<>(Arrays.asList("I", "X", "C"));
        Map<String, Integer> symbolToValMap = new HashMap<>();
        symbolToValMap.put("I", 1);
        symbolToValMap.put("V", 5);
        symbolToValMap.put("X", 10);
        symbolToValMap.put("L", 50);
        symbolToValMap.put("C", 100);
        symbolToValMap.put("D", 500);
        symbolToValMap.put("M", 1000);
        symbolToValMap.put("IV", 4);
        symbolToValMap.put("IX", 9);
        symbolToValMap.put("XL", 40);
        symbolToValMap.put("XC", 90);
        symbolToValMap.put("CD", 400);
        symbolToValMap.put("CM", 900);

        for (int i = 0; i <= s.length() - 1; i++) {
            String letter = String.valueOf(s.charAt(i));
            if (specialLetters.contains(letter)
                    && i < s.length() - 1
                    && symbolToValMap.containsKey(letter + s.charAt(i+1))) {
                result = result + symbolToValMap.get(letter + s.charAt(i+1));
                i++;
            } else {
                result = result + symbolToValMap.get(letter);
            }
        }
        return result;
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

    /**
     * 62. Unique Paths
     * There is a robot on an m x n grid. The robot is initially located at the top-left corner (i.e., grid[0][0]). The robot tries to move to the bottom-right corner (i.e., grid[m - 1][n - 1]). The robot can only move either down or right at any point in time.
     *
     * Given the two integers m and n, return the number of possible unique paths that the robot can take to reach the bottom-right corner.
     *
     * The test cases are generated so that the answer will be less than or equal to 2 * 109.
     * @param m
     * @param n
     * @return number of path the bot can take to go from start to finish
     */
    public static int uniquePaths(int m, int n) {
        int[][] dpMatrix = new int[m][n];
        for (int i = 0; i <= n-1; i++) {
            dpMatrix[0][i] = 1;
        }
        for (int i = 0; i <= m - 1; i++) {
            dpMatrix[i][0] = 1;
        }

        for (int i = 1; i <= m - 1; i++) {
            for (int j = 1; j<= n -1; j++) {
                dpMatrix[i][j] = dpMatrix[i][j-1] + dpMatrix[i-1][j];
            }
        }
        return dpMatrix[m-1][n-1];
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
