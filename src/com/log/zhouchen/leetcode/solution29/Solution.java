package com.log.zhouchen.leetcode.solution29;

/**
 * @author: shenzhouchen
 * @date: 2021/3/31 12:30 AM
 **/
public class Solution {
    public int divide(int dividend, int divisor) {

        boolean negative = false;
        if (dividend > 0 && divisor < 0) {
            negative = true;
        }
        if (dividend < 0 && divisor > 0) {
            negative = true;
        }
        dividend = Math.abs(dividend);
        divisor = Math.abs(divisor);

        int result = -1, sum = 0;
        while (sum <= dividend || sum < 0) {
            sum += divisor;
            result++;
        }

        return negative ? 0 - result : result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.divide(0, 1));
        System.out.println(solution.divide(1, 1));
        System.out.println(solution.divide(10, 3));
        System.out.println(solution.divide(7, -3));
    }
}
