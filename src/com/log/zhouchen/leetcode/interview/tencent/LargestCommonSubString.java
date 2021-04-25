package com.log.zhouchen.leetcode.interview.tencent;

/**
 * @author: shenzhouchen
 * @date: 2021/4/22 9:40 PM
 *
 * 找出两个数组（可能有重复数字）最大公共连续子数组长度
 * 输入：
 * [1,2,3,2,1]
 * [3,2,1,4,7]
 *
 * 输出: 3
 *
 * 参考：
 * https://blog.csdn.net/qbyhqp/article/details/82050121
 **/
public class LargestCommonSubString {

    public int findLargestCommonSubString(String a, String b) {
        if (a == null || a.length() == 0 || b == null || b.length() == 0) {
            return 0;
        }
        int max = 0;

        // res[i][j]表示 以a[i],b[j]字符结尾的最长公共子串长度
        int[][] res = new int[a.length() + 1][b.length() + 1];
        for (int i = 1; i <= a.length(); i++) {
            for (int j = 1; j <= b.length(); j++) {
                if (a.charAt(i - 1) == b.charAt(j - 1)) {
                    res[i][j] = res[i - 1][j - 1] + 1;
                    max = Math.max(res[i][j], max);
                } else {
                    res[i][j] = 0;
                }
            }
        }

        return max;
    }

    public static void main(String[] args) {
        String a = "12321";
        String b = "32147";

        LargestCommonSubString solution = new LargestCommonSubString();
        System.out.println(solution.findLargestCommonSubString(a, b));
    }
}
