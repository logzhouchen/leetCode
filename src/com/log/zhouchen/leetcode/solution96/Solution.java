package com.log.zhouchen.leetcode.solution96;

/**
 * @author: shenzhouchen
 * @date: 2021/5/23 10:41 PM
 **/
public class Solution {

    public int numTrees(int n) {
        int[] result = new int[n + 1];
        result[0] = 1;
        result[1] = 1;

        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                result[i] += result[j] * result[i - 1 - j];
            }
        }

        return result[n];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numTrees(3));
    }
}
