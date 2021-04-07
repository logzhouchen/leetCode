package com.log.zhouchen.leetcode.solution416;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 注意:
 每个数组中的元素不会超过 100
 数组的大小不会超过 200

 示例 1:
 输入: [1, 5, 11, 5]
 输出: true
 解释: 数组可以分割成 [1, 5, 5] 和 [11]
 *
 *
 * @author: shenzhouchen
 * @date: 2020/1/27 1:57 PM
 **/
public class Solution {

    public boolean canPartition(int[] nums) {
        // 1. 按照升序进行排序
        Arrays.sort(nums);

        // 2. 计算总和，判断是否是偶数，能拆分成等值2小组
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }

        // 2.1 如果是奇数，肯定不能拆分成等值2小组
        if ((sum & 1) == 1) {
            return false;
        }
        // 2.2 如果是偶数，计算每一小组总和
        int targetSum = sum / 2;

        // 3. 问题演变成，从array数组中找寻和为 targetSum的子集
        List<Integer> list = new ArrayList<>();
        boolean result = findSubArray(nums, 0, nums.length - 1, targetSum, list);
        if (result) {
            for (Integer item : list) {
                System.out.print(item + ", ");
            }
            System.out.println();
        }

        return result;
    }

    private boolean findSubArray(int[] array, int i, int j, int targetSum, List<Integer> list) {
        for (;j >= i; j--) {
            if (array[j] > targetSum) {
                return false;
            }
            if (array[j] == targetSum) {
                list.add(targetSum);
                return true;
            }

            // array[j] 被当作一次尝试
            list.add(array[j]);
            boolean result = findSubArray(array, i, j-1, targetSum - array[j], list);
            if (result) {
                return true;
            }

            // 去除array[j]
            list.remove(list.size() - 1);
        }
        return false;
    }

    public static void main(String[] args) {
        int[] array = new int[7];
        array[0] = 1;
        array[1] = 5;
        array[2] = 11;
        array[3] = 5;
        array[4] = 2;
        array[5] = 4;
        array[6] = 6;

        Solution solution = new Solution();
        System.out.println(solution.canPartition(array));
    }
}
