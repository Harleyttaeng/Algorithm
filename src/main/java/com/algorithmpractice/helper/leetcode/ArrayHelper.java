package com.algorithmpractice.helper.leetcode;

import java.util.Arrays;

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
}
