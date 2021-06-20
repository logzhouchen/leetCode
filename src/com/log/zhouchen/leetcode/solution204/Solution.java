package com.log.zhouchen.leetcode.solution204;

import java.util.Arrays;

/**
 * @author: shenzhouchen
 * @date: 2021/6/15 8:34 AM
 **/
public class Solution {

    public int countPrimes(int n) {
        int count = 0;
        int[] res = new int[n];
        Arrays.fill(res, 1);

        for (int i = 2; i < n; i++) {
            if (res[i] == 1) {
                count++;

                if ((long)i * (long)i < n) {
                    for (int j = i * i; j < n; j = j + i) {
                        res[j] = 0;
                    }
                }
            }
        }

        return count;
    }


    // o(n * √n)  通不过
    public int countPrimes1(int n) {
        int count = 0;

        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count ++;
            }
        }

        return count;
    }

    private boolean isPrime(int num) {
        for (int i = 2; i * i <= num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }



    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.countPrimes(499979));
        System.out.println(solution.countPrimes(10));
        System.out.println(solution.countPrimes(0));
        System.out.println(solution.countPrimes(1));
    }
}
