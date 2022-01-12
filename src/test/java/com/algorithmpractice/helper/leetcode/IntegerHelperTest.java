package com.algorithmpractice.helper.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class IntegerHelperTest {
    @Test
    public void testReverseInteger1() {
        int testInput = 120;
        Assert.assertEquals("Reversed integer is incorrect", 21, IntegerHelper.reverse(testInput));
    }

    @Test
    public void testReverseInteger2() {
        int testInput = -1234;
        Assert.assertEquals("Reversed integer is incorrect", -4321, IntegerHelper.reverse(testInput));
    }

    @Test
    public void testReverseInteger3() {
        int testInput = 0;
        Assert.assertEquals("Reversed integer is incorrect", 0, IntegerHelper.reverse(testInput));
    }

    @Test
    public void testReverseInteger4() {
        int testInput = 1534236469;
        Assert.assertEquals("Reversed integer is incorrect", 0, IntegerHelper.reverse(testInput));
    }

    @Test
    public void testReverseInteger5() {
        int testInput = -2147483648;
        Assert.assertEquals("Reversed integer is incorrect", 0, IntegerHelper.reverse(testInput));
    }

    @Test
    public void testReverseInteger6() {
        int testInput = -465789;
        Assert.assertEquals("Reversed integer is incorrect", -987564, IntegerHelper.reverse(testInput));
    }
    
    @Test
    public void testIsPalindrome1() {
        Assert.assertTrue("Failed to determine if palindrome", IntegerHelper.isPalindrome(121));
    }

    @Test
    public void testIsPalindrome2() {
        Assert.assertFalse("Failed to determine if palindrome", IntegerHelper.isPalindrome(123));
    }

    @Test
    public void testIsPalindrome3() {
        Assert.assertFalse("Failed to determine if palindrome", IntegerHelper.isPalindrome(-121));
    }
    
    @Test
    public void testIsPalindrome4() {
        Assert.assertTrue("Failed to determine if palindrome", IntegerHelper.isPalindrome(0));
    }

    @Test
    public void testIsPalindrome5() {
        Assert.assertTrue("Failed to determine if palindrome", IntegerHelper.isPalindrome(1));
    }
    
    @Test
    public void test3Sum1() {
        int[] testInput = {-1,0,1,2,-1,-4};
        int[] expectedOutputEle1 = {-1,-1,2};
        int[] expectedOutputEle2 = {-1,0,1};
        
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(Arrays.stream(expectedOutputEle1).boxed().collect(Collectors.toList()));
        expectedOutput.add(Arrays.stream(expectedOutputEle2).boxed().collect(Collectors.toList()));
        Assert.assertEquals("Failed to generate 3 Sum", expectedOutput, IntegerHelper.threeSum(testInput));
    }

    @Test
    public void test3Sum2() {
        int[] testInput = {0,0,0};
        int[] expectedOutputEle1 = {0,0,0};
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(Arrays.stream(expectedOutputEle1).boxed().collect(Collectors.toList()));
        Assert.assertEquals("Failed to generate 3 Sum", expectedOutput, IntegerHelper.threeSum(testInput));
    }

    @Test
    public void test3Sum3() {
        int[] testInput = {0,0,0,0};
        int[] expectedOutputEle1 = {0,0,0};
        List<List<Integer>> expectedOutput = new ArrayList<>();
        expectedOutput.add(Arrays.stream(expectedOutputEle1).boxed().collect(Collectors.toList()));
        Assert.assertEquals("Failed to generate 3 Sum", expectedOutput, IntegerHelper.threeSum(testInput));
    }

    @Test
    public void testUniquePaths1() {
        Assert.assertEquals("Failed to calculate total number of unique paths", 28, IntegerHelper.uniquePaths(3,7));
    }

    @Test
    public void testUniquePaths2() {
        Assert.assertEquals("Failed to calculate total number of unique paths", 1, IntegerHelper.uniquePaths(1,1));
    }
}
