package com.log.zhouchen.leetcode.solution167;

/**
 * @author: shenzhouchen
 * @date: 2021/4/30 1:29 AM
 **/
public class Solution {

    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];

        // 升序排列
        int i = 0, j = nums.length - 1;
        while (i < j) {
            int sum = nums[i] + nums[j];

            if (sum > target) {
                j--;
            } else if (sum < target) {
                i++;
            } else {
                result[0] = i + 1;
                result[1] = j + 1;
                break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] result = solution.twoSum(new int[]{2,7,11,15}, 9);
        for (int item : result) {
            System.out.println(item);
        }
    }
}
