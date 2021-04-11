package com.log.zhouchen.leetcode.solution5;

/**
 * @author: shenzhouchen
 * @date: 2021/4/11 9:45 PM
 **/
public class Solution {

    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }

        int start = 0, end = 0;
        int length = s.length();
        boolean[][] array = new boolean[length][length];

        for (int i = 0; i < length; i++) {
            for (int j = 0; j <= i; j++) {

                if (i - j < 2) {
                    array[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    array[i][j] = s.charAt(i) == s.charAt(j) && array[i - 1][j + 1];
                }

                if (array[i][j] && i - j > end - start) {
                    start = j;
                    end = i;
                }
            }
        }

        return s.substring(start, end + 1);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestPalindrome("babaabcdefggfedcba"));
        System.out.println(solution.longestPalindrome("babad"));
        System.out.println(solution.longestPalindrome("cbbd"));
        System.out.println(solution.longestPalindrome("aa"));
        System.out.println(solution.longestPalindrome("a"));
        System.out.println(solution.longestPalindrome(""));
    }
}
