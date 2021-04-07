package com.log.zhouchen.leetcode.solution397;

/**
 * 给定一个正整数 n，你可以做如下操作：
 1. 如果 n 是偶数，则用 n / 2替换 n。
 2. 如果 n 是奇数，则可以用 n + 1或n - 1替换 n。
 n 变为 1 所需的最小替换次数是多少？

 示例一:
 输入: 8
 输出: 3
 解释:
 8 -> 4 -> 2 -> 1

 示例二:
 输入: 7
 输出: 4
 解释:
 7 -> 8 -> 4 -> 2 -> 1
 或
 7 -> 6 -> 3 -> 2 -> 1

 示例三:
 输入: 65535
 输出: 17

 示例四:
 输入: 2147483647 = Integer.MAX_VALUE
 输出: 32

 * @author: shenzhouchen
 * @date: 2020/1/25 8:08 PM
 **/
public class Solution {
    public int integerReplacement(int n) {
        return (int) integerReplacement1((long) n);
    }

    /**
     * 递归解法，但是数字过大 会造成 堆栈溢出
     */
    public long integerReplacement(long n) {
        // 递归结束条件
        if (n == 1) {
            return 0;
        }

        if (n % 2 == 0) {
            // 偶数，则用 n/2 替换 n
            return integerReplacement(n / 2) + 1;
        } else {
            // 奇数
            return 2 + Math.min(integerReplacement((n + 1) / 2), integerReplacement((n - 1) / 2));
        }
    }

    /**
     * 循环解答
     */
    public long integerReplacement1(long n) {
        long count = 0;
        while (n != 1) {
            if (n == 3) {
                count += 2;
                break;
            }

            if ((n & 1) == 0) {
                // 偶数
                n = n >> 1;
            } else {
                // 奇数，最后1位必定为1
                if ((n & 3) == 3) {
                    n = n + 1;
                } else {
                    n = n - 1;
                }
            }
            count ++;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.MIN_VALUE);
        System.out.println(Integer.MAX_VALUE);

        Solution solution = new Solution();
        System.out.println(solution.integerReplacement(3));
    }
}
