package com.log.zhouchen.leetcode.interview.tencent;

/**
 * @author: shenzhouchen
 * @date: 2021/4/26 12:52 AM
 **/
public class LargestCommonSubSequence {


    public int findLargestCommonSubSequence(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return 0;
        }

        // res[i][j]表示 a[0,i) 和 b[0,j)的最长公共子序列
        int[][] res = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                } else {
                    res[i][j] = Math.max(res[i - 1][j], res[i][j - 1]);
                }
            }
        }

        return res[a.length()][b.length()];
    }

    public static void main(String[] args) {
        String a = "13456778";
        String b = "357486782";

        LargestCommonSubSequence solution = new LargestCommonSubSequence();
        System.out.println(solution.findLargestCommonSubSequence(a, b));
    }
}
