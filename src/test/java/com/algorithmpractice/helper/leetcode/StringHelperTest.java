package com.algorithmpractice.helper.leetcode;

import org.junit.Assert;
import org.junit.Test;

public class StringHelperTest {
    @Test
    public void testRegexPatternMatching1() {
        String inputString = "aaacba";
        String regexPattern = "a*cb*a*";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching2() {
        String inputString = "aaacba";
        String regexPattern = "a*cb*a*c";
        Assert.assertFalse("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching3() {
        String inputString = "aaacbbba";
        String regexPattern = "a*" +
                "cb*a*";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching4() {
        String inputString = "aaacbbba";
        String regexPattern = ".*";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }
    
    @Test
    public void testRegexPatternMatching5() {
        String inputString = "aaacbbbaccde";
        String regexPattern = ".*baccde";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching6() {
        String inputString = "h//a";
        String regexPattern = "h/*.*";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching7() {
        String inputString = "aa";
        String regexPattern = "a";
        Assert.assertFalse("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching8() {
        String inputString = "aa";
        String regexPattern = "aa";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching9() {
        String inputString = "aa";
        String regexPattern = "a*";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }
    
    @Test
    public void testRegexPatternMatching10() {
        String inputString = "aab";
        String regexPattern = "c*a*b";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching11() {
        String inputString = "aaa";
        String regexPattern = "ab*ac*a";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching12() {
        String inputString = "aaa";
        String regexPattern = "a.*a.*a";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching13() {
        String inputString = "a";
        String regexPattern = "ab*";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching14() {
        String inputString = "a";
        String regexPattern = ".*.";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching15() {
        String inputString = "aasdfasdfasdfasdfas";
        String regexPattern = "aasdf.*asdf.*asdf.*asdf.*s";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching16() {
        String inputString = "aaa";
        String regexPattern = "ab*a";
        Assert.assertFalse("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching17() {
        String inputString = "aaa";
        String regexPattern = "ab*a*c*a";
        Assert.assertTrue("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testRegexPatternMatching18() {
        String inputString = "a";
        String regexPattern = ".*..a*";
        Assert.assertFalse("Failed to judge if string matches regex", StringHelper.isMatch(inputString, regexPattern));
    }

    @Test
    public void testLongestCommonSubsequence1() {
        String text1 = "ace";
        String text2 = "abcde";
        Assert.assertEquals("Failed to calculate longest common subsequence", 3, StringHelper.longestCommonSubsequence(text1, text2));
    }

    @Test
    public void testLongestCommonSubsequence2() {
        String text1 = "abc";
        String text2 = "def";
        Assert.assertEquals("Failed to calculate longest common subsequence", 0, StringHelper.longestCommonSubsequence(text1, text2));
    }

    @Test
    public void testLongestCommonSubsequence3() {
        String text1 = "bsbininm";
        String text2 = "jmjkbkjkv";
        Assert.assertEquals("Failed to calculate longest common subsequence", 1, StringHelper.longestCommonSubsequence(text1, text2));
    }

    @Test
    public void testLongestCommonSubsequence4() {
        String text1 = "oxcpqrsvwf";
        String text2 = "shmtulqrypy";
        Assert.assertEquals("Failed to calculate longest common subsequence", 2, StringHelper.longestCommonSubsequence(text1, text2));
    }
}
