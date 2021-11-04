package com.algorithmpractice.helper.leetcode;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.*;


public class ArrayHelperTest {

    private final Logger LOG = LoggerFactory.getLogger(ArrayHelper.class.getCanonicalName());
    
    private final static String COMBINED_SORTED_ARRAY_MSG = "Sorted array is incorrect";
    private final static String MEDIAN_TWO_SORTED_ARRAY_MSG = "Median calculated is incorrect";
    
    @Test
    public void testCombinedTwoSortedArray1() {
        int[] arr1 = {1,3,8,9,15};
        int[] arr2 = {7,11,18,19,21,25};
        int[] expectedResult = {1, 3, 7, 8, 9, 11, 15, 18, 19, 21, 25};
        assertArrayEquals(expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }

    @Test
    public void testCombinedTwoSortedArray2() {
        int[] arr1 = {1,2,7,8,9,15};
        int[] arr2 = {7,11,18,19,21,25};
        int[] expectedResult = {1, 2, 7, 7, 8, 9, 11, 15, 18, 19, 21, 25};
        assertArrayEquals(COMBINED_SORTED_ARRAY_MSG, expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }

    @Test
    public void testCombinedTwoSortedArray3() {
        int[] arr1 = {2,4,6,8,12,35,50,90};
        int[] arr2 = {1,7,9,9};
        int[] expectedResult = {1,2,4,6,7,8,9,9,12,35,50,90};
        assertArrayEquals(COMBINED_SORTED_ARRAY_MSG, expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }

    @Test
    public void testCombinedTwoSortedArray4() {
        int[] arr1 = {2};
        int[] arr2 = {2};
        int[] expectedResult = {2,2};
        assertArrayEquals(COMBINED_SORTED_ARRAY_MSG, expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }

    @Test
    public void testCombinedTwoSortedArray5() {
        int[] arr1 = {1,2};
        int[] arr2 = {3};
        int[] expectedResult = {1,2,3};
        assertArrayEquals(COMBINED_SORTED_ARRAY_MSG, expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }

    @Test
    public void testCombinedTwoSortedArray6() {
        int[] arr1 = {11,20};
        int[] arr2 = {9};
        int[] expectedResult = {9,11,20};
        assertArrayEquals(COMBINED_SORTED_ARRAY_MSG, expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }
    
    @Test
    public void testMergeSort() {
        int[] inputArray = {38,27,43,3,9,82,10};
        int[] expectedSortedArray = {3,9,10,27,38,43,82};
        int[] actualResult = ArrayHelper.MergeSort(inputArray);
        LOG.info("sorted array is {}", actualResult);
        assertArrayEquals(COMBINED_SORTED_ARRAY_MSG, expectedSortedArray, actualResult);
    }
    
    @Test
    public void testFindMedianOfTwoSortedArray1() {
        int[] inputArray1 = {23,26,31,35};
        int[] inputArray2 = {3,5,7,9,11,16};
        double medianOutput = ArrayHelper.findMediumOfTwoSortedArray(inputArray1, inputArray2);
        LOG.info("Median calculated is {}", medianOutput);
        assertEquals(MEDIAN_TWO_SORTED_ARRAY_MSG, 13.5, medianOutput, 0.0);
    }

    @Test
    public void testFindMedianOfTwoSortedArray2() {
        int[] inputArray1 = {1,3,8,9,15};
        int[] inputArray2 = {7,11,18,19,21,25};
        double medianOutput = ArrayHelper.findMediumOfTwoSortedArray(inputArray1, inputArray2);
        LOG.info("Median calculated is {}", medianOutput);
        assertEquals(MEDIAN_TWO_SORTED_ARRAY_MSG, 11, medianOutput, 0.0);
    }

    @Test
    public void testFindMedianOfTwoSortedArray3() {
        int[] inputArray1 = {};
        int[] inputArray2 = {1};
        double medianOutput = ArrayHelper.findMediumOfTwoSortedArray(inputArray1, inputArray2);
        LOG.info("Median calculated is {}", medianOutput);
        assertEquals(MEDIAN_TWO_SORTED_ARRAY_MSG, 1, medianOutput, 0.0);
    }

    @Test
    public void testFindMedianOfTwoSortedArray4() {
        int[] inputArray1 = {1,2};
        int[] inputArray2 = {3,4};
        double medianOutput = ArrayHelper.findMediumOfTwoSortedArray(inputArray1, inputArray2);
        LOG.info("Median calculated is {}", medianOutput);
        assertEquals(MEDIAN_TWO_SORTED_ARRAY_MSG, 2.5, medianOutput, 0.0);
    }

    @Test
    public void testFindMedianOfTwoSortedArray5() {
        int[] inputArray1 = {0,0};
        int[] inputArray2 = {0,0};
        double medianOutput = ArrayHelper.findMediumOfTwoSortedArray(inputArray1, inputArray2);
        LOG.info("Median calculated is {}", medianOutput);
        assertEquals(MEDIAN_TWO_SORTED_ARRAY_MSG, 0, medianOutput, 0.0);
    }

    @Test
    public void testFindMedianOfTwoSortedArray6() {
        int[] inputArray1 = {1,3};
        int[] inputArray2 = {2};
        double medianOutput = ArrayHelper.findMediumOfTwoSortedArray(inputArray1, inputArray2);
        LOG.info("Median calculated is {}", medianOutput);
        assertEquals(MEDIAN_TWO_SORTED_ARRAY_MSG, 2, medianOutput, 0.0);
    }

    @Test
    public void testFindMedianOfTwoSortedArray7() {
        int[] inputArray1 = {};
        int[] inputArray2 = {2,3};
        double medianOutput = ArrayHelper.findMediumOfTwoSortedArray(inputArray1, inputArray2);
        LOG.info("Median calculated is {}", medianOutput);
        assertEquals(MEDIAN_TWO_SORTED_ARRAY_MSG, 2.5, medianOutput, 0.0);
    }

    @Test
    public void testFindMedianOfTwoSortedArray8() {
        int[] inputArray1 = {3};
        int[] inputArray2 = {-2,-1};
        double medianOutput = ArrayHelper.findMediumOfTwoSortedArray(inputArray1, inputArray2);
        LOG.info("Median calculated is {}", medianOutput);
        assertEquals(MEDIAN_TWO_SORTED_ARRAY_MSG, -1, medianOutput, 0.0);
    }
    
    @Test
    public void testProductExceptSelf1() {
        int[] inputArray = {1,2,3,4};
        int[] expectedOutput = {24,12,8,6};
        assertArrayEquals("Expected output is incorrect", expectedOutput, ArrayHelper.productExceptSelf(inputArray));
    }
    
}
