package com.algorithmpractice.helper.leetcode;

import java.util.*;

public class StringHelper {

    public static boolean isCharAMatch(char s, char p) {
        char wildCardChar = '.';
        return s == p || p == wildCardChar; 
    }

    /**
     * 10. Regular Expression Matching
     * Given an input string s and a pattern p, implement regular expression matching with support for '.' and '*' where:
     * '.' Matches any single character.
     * '*' Matches zero or more of the preceding element.
     * The matching should cover the entire input string (not partial).
     * 
     * @param s input string
     * @param p input regex pattern
     * @return if string matches the pattern
     */
    public static boolean isMatch(String s, String p) {
        boolean[][] dpMatrix = new boolean[s.length()+1][p.length()+1];
        s = " " + s;
        p = " " + p;
        char pChar;
        char sChar;
        dpMatrix[0][0] = true;
        for (int i=1; i<=p.length()-1;i++){
            if (p.charAt(i) == '*') {
                dpMatrix[0][i] = dpMatrix[0][i-2];
            } else {
                dpMatrix[0][i] = false;
            }
        }
        for (int j=1; j<=s.length()-1;j++){
            dpMatrix[j][0]=false;
        }
        
        for (int i=1; i<=s.length()-1;i++) {
            sChar = s.charAt(i);
            for (int j=1;j<=p.length()-1;j++) {
                pChar = p.charAt(j);
                if (isCharAMatch(sChar, pChar)) {
                    dpMatrix[i][j] = dpMatrix[i-1][j-1];
                } else if (pChar == '*') {
                    // 0 occurrence
                    if ((isCharAMatch(sChar, p.charAt(j-2)) || p.charAt(j-2) == '*') && dpMatrix[i][j - 2]) {
                        dpMatrix[i][j] = dpMatrix[i][j-2];
                        // 1 or more occurrences
                    } else if (isCharAMatch(sChar, p.charAt(j-1)) && dpMatrix[i-1][j]) {
                        dpMatrix[i][j] = dpMatrix[i-1][j];
                    } else {
                        dpMatrix[i][j] = false;
                    }
                }
            }
        }
        return dpMatrix[s.length()-1][p.length()-1];
    }

    /**
     * 91. Decode Ways
     * A message containing letters from A-Z can be encoded into numbers using the following mapping:
     *
     * 'A' -> "1"
     * 'B' -> "2"
     * ...
     * 'Z' -> "26"
     * To decode an encoded message, all the digits must be grouped then mapped back into letters using the reverse of the mapping above (there may be multiple ways). For example, "11106" can be mapped into:
     *
     * "AAJF" with the grouping (1 1 10 6)
     * "KJF" with the grouping (11 10 6)
     * Note that the grouping (1 11 06) is invalid because "06" cannot be mapped into 'F' since "6" is different from "06".
     *
     * Given a string s containing only digits, return the number of ways to decode it.
     *
     * The test cases are generated so that the answer fits in a 32-bit integer.
     *
     * @param s input string
     * @return number of ways input string can be decoded
     */
    public static int numDecodings(String s) {
        if (String.valueOf(s.charAt(0)).equals("0")) {
            return 0;
        }
        int length = s.length();
        int[] maxNumberEncodingRecords = new int[length];
        maxNumberEncodingRecords[0] = 1;
        Set<String> encodingMap = new HashSet<>();
        for (int i = 0; i <= 25; i++) {
            encodingMap.add(String.valueOf(i + 1));
        }

        for (int j = 1; j <= length - 1; j++) {
            String currentDigit = String.valueOf(s.charAt(j));
            if (currentDigit.equals("0") && encodingMap.contains(s.charAt(j - 1) + currentDigit)) {
                maxNumberEncodingRecords[j] = j == 1 ? 1 : maxNumberEncodingRecords[j-2];
            } else if (!currentDigit.equals("0")) {
                maxNumberEncodingRecords[j] = j == 1 ? (encodingMap.contains(s.charAt(0) + currentDigit) ? 2 : 1) : (encodingMap.contains(s.charAt(j - 1) + currentDigit) ? maxNumberEncodingRecords[j-1] + maxNumberEncodingRecords[j-2] : maxNumberEncodingRecords[j-1]);
            } else {
                return 0;
            }
        }
        return maxNumberEncodingRecords[length-1];
    }

    /**
     * 139. Word Break
     *
     * Given a string s and a dictionary of strings wordDict, return true if s can be segmented into a space-separated sequence of one or more dictionary words.
     *
     * Note that the same word in the dictionary may be reused multiple times in the segmentation.
     *
     */
    public static boolean wordBreak(String s, List<String> wordDict) {
        int sLength = s.length();
        HashSet<String> wordDictSet = new HashSet<>(wordDict);
        Boolean[] indexVisitRecord = new Boolean[sLength + 1];
        Arrays.fill(indexVisitRecord, false);
        indexVisitRecord[sLength] = true;

        for (int i = sLength - 1; i >= 0; i--) {
            for (int j = sLength; i < j; j--) {
                if (indexVisitRecord[j] && wordDictSet.contains(s.substring(i, j))) {
                    indexVisitRecord[i] = true;
                    break;
                }
            }

        }
        return indexVisitRecord[0];
    }

    /**
     * 1143. Longest Common Subsequence
     *
     * Given two strings text1 and text2, return the length of their longest common subsequence. If there is no common subsequence, return 0.
     *
     * A subsequence of a string is a new string generated from the original string with some characters (can be none) deleted without changing the relative order of the remaining characters.
     *
     * For example, "ace" is a subsequence of "abcde".
     * A common subsequence of two strings is a subsequence that is common to both strings.
     */
    public static int longestCommonSubsequence(String text1, String text2) {
        Integer[][] dpMatrix = new Integer[text2.length()][text1.length()];
        int indexCheckRow = text1.indexOf(text2.charAt(0));
        int indexCheckColumn = text2.indexOf(text1.charAt(0));

        if (indexCheckRow == -1) {
            Arrays.fill(dpMatrix[0],0);
        } else {
            for (int i = 0; i < indexCheckRow; i++) {
                dpMatrix[0][i] = 0;
            }
            for (int j = indexCheckRow; j <= text1.length()-1; j++) {
                dpMatrix[0][j] = 1;
            }
        }
        if (indexCheckColumn == -1) {
            for (Integer[] ele: dpMatrix) {
                ele[0] = 0;
            }
        } else {
            for (int i = 0; i < indexCheckColumn; i++) {
                dpMatrix[i][0] = 0;
            }
            for (int j = indexCheckColumn; j <= text2.length()-1; j++) {
                dpMatrix[j][0] = 1;
            }
        }

        for (int i = 1; i <= text2.length() - 1; i++) {
            for (int j = 1; j <= text1.length() - 1; j++) {
                if (text2.charAt(i) != text1.charAt(j)) {
                    dpMatrix[i][j] = Math.max(dpMatrix[i][j-1], dpMatrix[i-1][j]);
                } else {
                    dpMatrix[i][j] = 1 + dpMatrix[i-1][j-1];
                }
            }
        }
        return dpMatrix[text2.length()-1][text1.length()-1];
    }

    /**
     *
     * Given a time in -hour AM/PM format, convert it to military (24-hour) time.
     *
     * Note: - 12:00:00AM on a 12-hour clock is 00:00:00 on a 24-hour clock.
     * - 12:00:00PM on a 12-hour clock is 12:00:00 on a 24-hour clock.
     *
     * Example
     * Return '12:01:00'.
     * Return '00:01:00'.
     *
     * Function Description
     */
    public static String timeConversion(String s) {
        Map<String, String> twelveTo24Map = new HashMap<>();
        twelveTo24Map.put("12", "00");
        int twentyFourStartingNumber = 13;

        for (int i = 1; i <= 11; i++) {
            if (String.valueOf(i).length() == 1) {
                twelveTo24Map.put("0" + i, String.valueOf(twentyFourStartingNumber));
            } else {
                twelveTo24Map.put(String.valueOf(i), String.valueOf(twentyFourStartingNumber));
            }
            twentyFourStartingNumber++;
        }

        if (s.substring(8).equals("PM")) {
            if (s.startsWith("12")) {
                return s.substring(0, 8);
            } else {
                return twelveTo24Map.get(s.substring(0, 2)) + s.substring(2, 8);
            }
        } else {
            if (s.startsWith("12")) {
                return "00" + s.substring(2, 8);
            } else {
                return s.substring(0, 8);
            }
        }
    }


    /*
     * Complete the 'superDigit' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. STRING n
     *  2. INTEGER k
     *
     * For example, the super digit of 9875 will be calculated as:
        super_digit(9875)   9+8+7+5 = 29
        super_digit(29) 	2 + 9 = 11
        super_digit(11)		1 + 1 = 2
        super_digit(2)		= 2
     */

    public static int superDigit(String n, int k) {
        StringBuilder superDigitInput = new StringBuilder();
        for (int i = 0; i <= k-1; i++) {
            superDigitInput.append(n);
        }
        return superDigitAux(superDigitInput.toString());
    }

    public static int superDigitAux(String n) {
        if (n.length() == 1) {
            return (int) n.charAt(0) - '0';
        } else {
            int superDigitResult = 0;
            for (int i = 0; i <= n.length()-1; i++) {
                superDigitResult = superDigitResult + (int) n.charAt(i) - '0';
            }
            return StringHelper.superDigit(String.valueOf(superDigitResult), 1);
        }
    }

    //  {[()]}
    public static String isBalanced(String s) {
        Stack<String> utilStack = new Stack<>();

        for (int i = 0; i <= s.length() - 1; i++) {
            String currentBracket = String.valueOf(s.charAt(i));
            if (currentBracket.equals("(") || currentBracket.equals("{") || currentBracket.equals("[")) {
                utilStack.push(currentBracket);
            } else {
                if (utilStack.isEmpty()) {
                    return "NO";
                }
                String popVal = utilStack.pop();
                if (popVal.equals("(") && !currentBracket.equals(")")) {
                    return "NO";
                }
                if (popVal.equals("[") && !currentBracket.equals("]")) {
                    return "NO";
                }
                if (popVal.equals("{") && !currentBracket.equals("}")) {
                    return "NO";
                }
            }
        }
        if (utilStack.isEmpty()) {
            return "YES";
        } else {
            return "NO";
        }
    }

}
