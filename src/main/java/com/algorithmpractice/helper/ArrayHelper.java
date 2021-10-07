package com.algorithmpractice.helper;

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
}
