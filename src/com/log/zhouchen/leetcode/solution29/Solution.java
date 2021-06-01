package com.log.zhouchen.leetcode.solution29;

/**
 * @author: shenzhouchen
 * @date: 2021/3/31 12:30 AM
 **/
public class Solution {
    public int divide(int dividend, int divisor) {
        if (dividend == 0) {
            return 0;
        } else if (divisor == 1) {
            return dividend;
        } else if (divisor == -1) {
            if (dividend == Integer.MIN_VALUE) {
                return Integer.MAX_VALUE;
            } else {
                return 0 - dividend;
            }
        }


        long a = dividend;
        long b = divisor;

        boolean negative = false;
        if ((a > 0 && b < 0) || (a < 0 && b > 0)) {
            negative = true;
        }
        a = Math.abs(a);
        b = Math.abs(b);

        int res = div(a, b);
        return negative ? 0 - res : res;
    }

    private int div(long a, long b) {
        if (a < b) {
            return 0;
        }

        int result = 1;
        long temp = b;
        while (temp + temp < a) {
            temp = temp + temp;
            result *= 2;
        }

        return result + div(a - temp, b);
    }



    public static void main(String[] args) {
        Solution solution = new Solution();

        // 10 7 4 1 = 3
        System.out.println(solution.divide(Integer.MIN_VALUE, 2));
        System.out.println(solution.divide(10, 3));
    }
}
