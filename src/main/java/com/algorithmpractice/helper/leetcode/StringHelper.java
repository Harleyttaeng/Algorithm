package com.algorithmpractice.helper.leetcode;

import java.util.Arrays;

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
}
