package com.algorithmpractice.helper.leetcode;

import org.junit.Assert;
import org.junit.Test;

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
}
