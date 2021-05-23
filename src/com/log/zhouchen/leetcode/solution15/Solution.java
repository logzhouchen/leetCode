package com.log.zhouchen.leetcode.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: shenzhouchen
 * @date: 2021/3/30 11:50 PM
 *
 * 3数之和为0的所有组合
 **/
public class Solution {

    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        // 升序排序
        Arrays.sort(nums);

        // 降维 3维->2维
        for (int i = 0; i < nums.length - 2; i++) {
            // 确保结果集不相等， 起始数字相同的情况前面已计算过了
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int left = 0 - nums[i];
            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                int sum = nums[j] + nums[k];
                if (sum == left) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);
                    result.add(temp);

                    j++;
                    k--;
                } else if (sum < left ) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-1,0,1,2,-1,-4};

        Solution solution = new Solution();
        System.out.println(solution.threeSum(nums));
    }
}
