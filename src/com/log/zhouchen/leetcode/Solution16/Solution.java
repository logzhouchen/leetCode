package com.log.zhouchen.leetcode.Solution16;

import java.util.Arrays;

/**
 * @author: shenzhouchen
 * @date: 2021/4/11 10:15 PM
 **/
public class Solution {
    public int threeSumClosest(int[] nums, int target) {
        // 递增排序
        Arrays.sort(nums);

        int result = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < nums.length - 2; i++) {
            int s = i + 1, e = nums.length - 1;
            while (s < e && e < nums.length) {
                int sum = nums[i] + nums[s] + nums[e];
                if (Math.abs(sum - target) < Math.abs(result - target)) {
                    result = sum;
                }

                if (sum < target) {
                    s++;
                } else if (sum > target) {
                    e--;
                } else {
                    break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = new int[]{-1,2,1,-4, -4};
        int[] nums = new int[]{0,1,2,-3};
        System.out.println(solution.threeSumClosest(nums, 1));
    }
}
