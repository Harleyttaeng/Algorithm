package com.algorithmpractice.helper;

import static org.junit.Assert.assertArrayEquals;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ArrayHelperTest {

    private final Logger LOG = LoggerFactory.getLogger(ArrayHelper.class.getCanonicalName());
    
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
        assertArrayEquals("Sorted array is incorrect", expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }

    @Test
    public void testCombinedTwoSortedArray3() {
        int[] arr1 = {2,4,6,8,12,35,50,90};
        int[] arr2 = {1,7,9,9};
        int[] expectedResult = {1,2,4,6,7,8,9,9,12,35,50,90};
        assertArrayEquals("Sorted array is incorrect", expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }

    @Test
    public void testCombinedTwoSortedArray4() {
        int[] arr1 = {2};
        int[] arr2 = {2};
        int[] expectedResult = {2,2};
        assertArrayEquals("Sorted array is incorrect", expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }

    @Test
    public void testCombinedTwoSortedArray5() {
        int[] arr1 = {1,2};
        int[] arr2 = {3};
        int[] expectedResult = {1,2,3};
        assertArrayEquals("Sorted array is incorrect", expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }

    @Test
    public void testCombinedTwoSortedArray6() {
        int[] arr1 = {11,20};
        int[] arr2 = {9};
        int[] expectedResult = {9,11,20};
        assertArrayEquals("Sorted array is incorrect", expectedResult, ArrayHelper.combineTwoSortedArray(arr1,arr2));
    }
    
    
    @Test
    public void testMergeSort() {
        int[] inputArray = {38,27,43,3,9,82,10};
        int[] expectedSortedArray = {3,9,10,27,38,43,82};
        int[] actualResult = ArrayHelper.MergeSort(inputArray);
        LOG.info("sorted array is {}", actualResult);
        assertArrayEquals("Sorted array is incorrect", expectedSortedArray, actualResult);
    }
}
