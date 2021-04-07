package com.log.zhouchen.leetcode.solution813;

import java.math.BigDecimal;

/**
 * @author: shenzhouchen
 * @date: 2020/3/8 9:36 PM
 **/
public class Solution {

    private BigDecimal max = BigDecimal.ZERO;

    public double largestSumOfAverages(int[] A, int K) {
        recursive(A, K, 0, BigDecimal.ZERO);
        return max.doubleValue();
    }


    private BigDecimal recursive(int[] A, int K, int start, BigDecimal sum) {
        System.out.println(K + " " + start + " " + sum.doubleValue());
        BigDecimal result = new BigDecimal(-1);
        int numLeft = A.length - start;
        if (K > numLeft) {
            // 异常情况处理，剩余的数字 少于 要分的组（每组一个数字都不够了），直接返回错误，上层在其当前背包不用再重试放更多数字了
            return result;
        }
        if (K == numLeft) {
            // 递归终止条件1，剩下数字正好每个组一个
            result = sum;
            for (int j = start; j < A.length; j++) {
                result = result.add(new BigDecimal(A[j]));
            }
            max = max.compareTo(result) < 0 ? result : max;
            return max;
        }
        if (K == 1) {
            // 递归终止条件2，剩下数字只需要一个分组
            result = sum.add(averageOfInterval(A, start, A.length - 1));
            max = max.compareTo(result) < 0 ? result : max;
            return max;
        }

        for (int i = start; i < A.length; i++) {
            result = sum.add(averageOfInterval(A, start, i));
            BigDecimal rs = recursive(A, K - 1, i + 1, result);
            if (rs.compareTo(BigDecimal.ZERO) < 0) {
                // 说明该种情况下剩余数字不够分了，本次划分不能再占用更多数字了，可直接return，上层可在其当前背包可做其他尝试
                return BigDecimal.ZERO;
            }
        }
        return BigDecimal.ZERO;
    }

    /**
     * 计算数组中下表start到end的总和
     */
    private BigDecimal averageOfInterval(int[] A, int start, int end) {
        if (start > end || start < 0 || end >= A.length) {
            return BigDecimal.ZERO;
        }
        int rs = 0;
        for (int i = start; i <= end; i++) {
            rs += A[i];
        }
        BigDecimal a = new BigDecimal(rs);
        BigDecimal b = new BigDecimal(end - start + 1);
        return a.divide(b, 10, BigDecimal.ROUND_HALF_UP);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.largestSumOfAverages(new int[]{4663,3020,7789,1627,9668,1356,4207,1133,8765,4649,205,6455,8864,3554,3916,5925,3995,4540,3487,5444,8259,8802,6777,7306,989,4958,2921,8155,4922,2469,6923,776,9777,1796,708,786,3158,7369,8715,2136,2510,3739,6411,7996,6211,8282,4805,236,1489,7698}, 27));
    }
}
