package com.log.zhouchen.leetcode.solution18;

import java.util.*;

/**
 * @author: shenzhouchen
 * @date: 2021/5/7 11:51 PM
 **/
public class Solution {

    public List<List<Integer>> fourSum(int[] arrays, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (arrays == null || arrays.length < 4) {
            return result;
        }

        // basic in asc
        Arrays.sort(arrays);
        for (int i = 0; i < arrays.length - 3; i++) {
            if (i > 0 && arrays[i] == arrays[i - 1]) {
                continue;
            }
            if (arrays[i] > target && arrays[i] >= 0) {
                break;
            }

            for (int j = i + 1; j < arrays.length - 2; j++) {
                if (j > i + 1 && arrays[j] == arrays[j - 1]) {
                    continue;
                }
                if (arrays[i] + arrays[j] > target && arrays[j] >= 0) {
                    break;
                }

                int m = j + 1, n = arrays.length - 1;
                int left = target - arrays[i] - arrays[j];
                while (m < n) {
                    if (m > j + 1 && arrays[m] == arrays[m - 1]) {
                        m++;
                        continue;
                    }
                    if (n < arrays.length - 1 && arrays[n] == arrays[n + 1]) {
                        n--;
                        continue;
                    }

                    int sum = arrays[m] + arrays[n];
                    if (sum == left) {
                        List<Integer> temp = new ArrayList<>(12);
                        temp.add(arrays[i]);
                        temp.add(arrays[j]);
                        temp.add(arrays[m]);
                        temp.add(arrays[n]);
                        result.add(temp);

                        m++;
                        n--;
                    } else if (sum < left) {
                        m++;
                    } else {
                        n--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] array = new int[]{1, -2, -5, -4, -3, 3, 3, 5};

        Solution solution = new Solution();
        System.out.println(solution.fourSum(array, -11));
    }
}