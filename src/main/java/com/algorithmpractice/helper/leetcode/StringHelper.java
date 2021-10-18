package com.algorithmpractice.helper.leetcode;

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
}
