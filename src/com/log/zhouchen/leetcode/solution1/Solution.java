package com.log.zhouchen.leetcode.solution1;

import java.util.Arrays;

/**
 * @author: shenzhouchen
 * @date: 2021/4/30 1:48 AM
 *
 *
 * https://blog.csdn.net/siyue0211/article/details/80947251
 **/
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[]{-1, -1};

        // 升序排列
        int[] copyNums = new int[nums.length];
        System.arraycopy(nums, 0, copyNums, 0, nums.length);
        Arrays.sort(copyNums);

        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = copyNums[i] + copyNums[j];

            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                break;
            }
        }

        for (int k = 0; k < nums.length; k++) {
            if (nums[k] == copyNums[i] && result[0] == -1) {
                result[0] = k;
                continue;
            }
            if (nums[k] == copyNums[j] && result[1] == -1) {
                result[1] = k;
                continue;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.twoSum(new int[]{-1,-2,-3,-4,-5}, -8);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
