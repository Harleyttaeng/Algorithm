package com.algorithmpractice.helper.leetcode;

import java.util.*;

public class ArrayHelper {

    public static<T> int[] subArray(int[] array, int beg, int end) {
        return Arrays.copyOfRange(array, beg, end + 1);
    }

    //Merge sort
    public static int[] MergeSort(int[] array) {
        if (array.length == 1) {
            return array;
        } else if (array.length == 2) {
            if (array[1] < array[0]) {
                int tmp = array[1];
                array[1] = array[0];
                array[0] = tmp;   
            }
            return array;
        } else {
            int mid = array.length / 2;
            int[] leftHalf = subArray(array, 0 , mid);
            int[] rightHalf = subArray(array, mid + 1, array.length - 1);
            return combineTwoSortedArray(MergeSort(leftHalf), MergeSort(rightHalf));
        }
    }
    
    
    public static int[] combineTwoSortedArray(int[] nums1, int[] nums2) {
        int[] result = new int[nums1.length + nums2.length];
        int resultIndexPointer = 0;
        
        int i = 0;
        int j = 0;
        
        while (i <= nums1.length - 1 && j <= nums2.length - 1){
            if (nums1[i]<nums2[j]) {
                result[resultIndexPointer] = nums1[i];
                resultIndexPointer++;
                i++;
            } else if (nums1[i] > nums2[j]) {
                result[resultIndexPointer] = nums2[j];
                resultIndexPointer++;
                j++;
            } else {
                result[resultIndexPointer] = nums1[i];
                resultIndexPointer++;
                i++;
                result[resultIndexPointer] = nums2[j];
                resultIndexPointer++;
                j++;
            }
        }
        if (i == nums1.length && j == nums2.length){
            return result;
        } else if (i == nums1.length && j <= nums2.length - 1) {
            for (int index = j; index <= nums2.length - 1; index++) {
                result[resultIndexPointer] = nums2[index];
                resultIndexPointer++;
            }
        } else {
            for (int index = i; index <= nums1.length - 1; index++) {
                result[resultIndexPointer] = nums1[index];
                resultIndexPointer++;
            }
        }
        return result;
    }

    /**
     * 4. Median of Two Sorted Arrays
     * Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
     *
     * The overall run time complexity should be O(log (m+n)).
     * @return median of 2 sorted arrays
     */
    public static double findMediumOfTwoSortedArray(int[] nums1, int[] nums2) {
        if (nums1.length > nums2.length) {
            return findMediumOfTwoSortedArray(nums2, nums1);
        }
        
        int totalLength = nums1.length + nums2.length;
        boolean isTotalLengthEven = totalLength % 2 == 0;

        if (nums1.length == 0 && nums2.length != 0) {
            return isTotalLengthEven ? (double) (nums2[nums2.length / 2 - 1] + nums2[nums2.length / 2]) / 2 : nums2[nums2.length / 2];         
        }

        int partitionX = nums1.length == 1 ? 1 : nums1.length / 2;
        int partitionY = isTotalLengthEven ? totalLength / 2 - partitionX : (totalLength + 1) / 2 - partitionX;
        int highP1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
        int highP2 = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
        int lowP1 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
        int lowP2 = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];

        while (partitionX >=0 && partitionX <= nums1.length) {
            highP1 = partitionX == 0 ? Integer.MIN_VALUE : nums1[partitionX-1];
            highP2 = partitionX == nums1.length ? Integer.MAX_VALUE : nums1[partitionX];
            lowP1 = partitionY == 0 ? Integer.MIN_VALUE : nums2[partitionY-1];
            lowP2 = partitionY == nums2.length ? Integer.MAX_VALUE : nums2[partitionY];
            if (highP1 <= lowP2 && lowP1 <= highP2) {
                break;
            } else if (highP1 > lowP2) {
                partitionX--;
                partitionY = isTotalLengthEven ? totalLength / 2 - partitionX : (totalLength + 1) / 2 - partitionX;
            } else {
                partitionY--;
                partitionX = isTotalLengthEven ? totalLength / 2 - partitionY : (totalLength + 1) / 2 - partitionY;
            }
        }
        if (isTotalLengthEven) {
            return (double) (Math.max(highP1, lowP1) + Math.min(highP2, lowP2)) / 2;
        } else {
            return Math.max(highP1, lowP1);
        }
    }

    /**
     * 11. Container With Most Water
     * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of the line i is at (i, ai) and (i, 0). Find two lines, which, together with the x-axis forms a container, such that the container contains the most water.
     *
     * Notice that you may not slant the container.
     */
    public static int maxAreaWaterContainer(int[] height) {
        int length = height.length;
        int pA = 0, pB = length - 1;
        int borderLeft = height[0], borderRight = height[length-1];
        int maxArea = Math.min(height[pA],height[pB]) * (pB-pA), maxAreaAux;

        while (pA < pB) {
            if (borderLeft < borderRight) {
                pA++;
                if (height[pA] > borderLeft) {
                    borderLeft=height[pA];
                    maxAreaAux = Math.min(height[pA],height[pB]) * (pB-pA);
                    maxArea = Math.max(maxArea, maxAreaAux);
                }
            } else {
                pB--;
                if (height[pB] > borderRight) {
                    borderRight=height[pB];
                    maxAreaAux = Math.min(height[pA],height[pB]) * (pB-pA);
                    maxArea = Math.max(maxArea, maxAreaAux);
                }
            }
        }
        return maxArea;
    }

    /**
     * 152. Maximum Product Subarray
     * Given an integer array nums, find a contiguous non-empty subarray within the array that has the largest product, and return the product.
     *
     * It is guaranteed that the answer will fit in a 32-bit integer.
     *
     * A subarray is a contiguous subsequence of the array.
     */
    public static int maxProduct(int[] nums) {
        int maxValue = nums[0];
        int auxMin = 1, auxMax = 1;
        int tmp;

        for (int num: nums) {
            if (num == 0) {
                auxMin = 1;
                auxMax = 1;
            }
            tmp = num * auxMax;
            auxMax = Math.max(num * auxMax, Math.max(num * auxMin, num));
            auxMin = Math.min(tmp, Math.min(num * auxMin, num));
            maxValue = Math.max(maxValue, auxMax);
        }
        return maxValue;
    }

    /**
     * 238. Product of Array Except Self
     * Given an integer array nums, return an array answer such that answer[i] is equal to the product of all the elements of nums except nums[i].
     * The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
     *
     * You must write an algorithm that runs in O(n) time and without using the division operation.
     * @return product of input array except self
     */
    public static int[] productExceptSelf(int[] nums) {
        int length = nums.length;
        int[] numAuxLeft = new int[length];
        int[] numAuxRight = new int[length];
        int[] result = new int[length];
        
        for (int i = 0; i <= length - 1; i++) {
            numAuxLeft[i] = i == 0 ? 1 : nums[i-1] * numAuxLeft[i-1]; 
        }
        for (int k = length - 1; k >= 0; k--) {
            numAuxRight[k] = k == length - 1 ? 1 : nums[k+1] * numAuxRight[k+1];
        }
        
        for (int j = 0; j <= length - 1; j++) {
            result[j] = numAuxLeft[j] * numAuxRight[j];
        }
        return result;
    }

    /**
     * 322. Coin Change
     * You are given an integer array coins representing coins of different denominations and an integer amount representing a total amount of money.
     *
     * Return the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.
     * You may assume that you have an infinite number of each kind of coin.
     * @param coins
     * @param amount
     * @return the fewest number of coins that you need to make up that amount
     */
    public static int coinChange(int[] coins, int amount) {
        if (amount==0) return 0;
        Map<Integer, Integer> recordedResults = new HashMap<>();
        int minNumCoinsAux;

        for (int val = 0;val <= amount; val++) {
            minNumCoinsAux = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (val == coin) {
                    recordedResults.put(val,1);
                    break;
                } else if (val > coin) {
                    if (recordedResults.containsKey(val - coin)) {
                        minNumCoinsAux = Math.min(1 + recordedResults.get(val - coin), minNumCoinsAux);
                        recordedResults.put(val,minNumCoinsAux);
                    }
                }
            }
        }
        return recordedResults.getOrDefault(amount, -1);
    }
}
