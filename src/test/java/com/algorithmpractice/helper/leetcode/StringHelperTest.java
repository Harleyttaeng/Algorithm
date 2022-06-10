package com.algorithmpractice.helper.leetcode;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testWordBreak1() {
        String s = "NeetCode";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("Neet");
        wordDict.add("Code");
        Assert.assertTrue("Failed to assess if word is breakable", StringHelper.wordBreak(s, wordDict));
    }

    @Test
    public void testWordBreak2() {
        String s = "aaaaaaa";
        List<String> wordDict = new ArrayList<>();
        wordDict.add("aaaa");
        wordDict.add("aaa");
        Assert.assertTrue("Failed to assess if word is breakable", StringHelper.wordBreak(s, wordDict));
    }

    @Test
    public void testNumDecodings1() {
        String s = "226";
        Assert.assertEquals("Failed to calculate number of ways of decoding", 3, StringHelper.numDecodings(s));
    }

    @Test
    public void testNumDecodings2() {
        String s = "06";
        Assert.assertEquals("Failed to calculate number of ways of decoding", 0, StringHelper.numDecodings(s));
    }

    @Test
    public void testNumDecodings3() {
        String s = "10";
        Assert.assertEquals("Failed to calculate number of ways of decoding", 1, StringHelper.numDecodings(s));
    }

    @Test
    public void testNumDecodings4() {
        String s = "2101";
        Assert.assertEquals("Failed to calculate number of ways of decoding", 1, StringHelper.numDecodings(s));
    }

    @Test
    public void testNumDecodings5() {
        String s = "1123";
        Assert.assertEquals("Failed to calculate number of ways of decoding", 5, StringHelper.numDecodings(s));
    }

    @Test
    public void testNumDecodings6() {
        String s = "27";
        Assert.assertEquals("Failed to calculate number of ways of decoding", 1, StringHelper.numDecodings(s));
    }

    @Test
    public void testNumDecodings7() {
        String s = "1201234";
        Assert.assertEquals("Failed to calculate number of ways of decoding", 3, StringHelper.numDecodings(s));
    }

    @Test
    public void testTimeConversion1() {
        String s = "07:05:45PM";
        Assert.assertEquals("Failed to convert time", "19:05:45", StringHelper.timeConversion(s));
    }

    @Test
    public void testTimeConversion2() {
        String s = "06:40:03AM";
        Assert.assertEquals("Failed to convert time", "06:40:03", StringHelper.timeConversion(s));
    }

    @Test
    public void testTimeConversion3() {
        String s = "12:45:54PM";
        Assert.assertEquals("Failed to convert time", "12:45:54", StringHelper.timeConversion(s));
    }

    @Test
    public void testSuperDigit1() {
        Assert.assertEquals("Failed to calculate super digit", 2, StringHelper.superDigit("9875",1));
    }

    @Test
    public void testSuperDigit2() {
        Assert.assertEquals("Failed to calculate super digit", 3, StringHelper.superDigit("7404954009694227446246375747227852213692570890717884174001587537145838723390362624487926131161112710589127423098959327020544003395792482625191721603328307774998124389641069884634086849138515079220750462317357487762780480576640689175346956135668451835480490089962406773267569650663927778867764315211280625033388271518264961090111547480467065229843613873499846390257375933040086863430523668050046930387013897062106309406874425001127890574986610018093859693455518413268914361859000614904461902442822577552997680098389183082654625098817411306985010658756762152160904278169491634807464356130877526392725432086439934006728914411061861235300979536190100734360684054557448454640750198466877185875290011114667186730452681943043971812380628117527172389889545776779555664826488520325234792648448625225364535053605515386730925070072896004645416713682004600636574389040662827182696337187610904694029221880801372864040345567230941110986028568372710970460116491983700312243090679537497139499778923997433720159174153",100000));
    }

    @Test
    public void testIsBalanced() {
        Assert.assertEquals("YES",StringHelper.isBalanced("{[()]}"));
    }
}

