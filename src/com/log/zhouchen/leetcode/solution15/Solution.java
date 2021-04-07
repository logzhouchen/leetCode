package com.log.zhouchen.leetcode.solution15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author: shenzhouchen
 * @date: 2021/3/30 11:50 PM
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
                int sum = nums[j] + nums[k];
                if (sum == left) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[j]);
                    temp.add(nums[k]);

                    List<Integer> last = result.size() > 0 ? result.get(result.size() - 1) : null;
                    if (!equals(last, temp)) {
                        result.add(temp);
                    }

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

    private boolean equals(List<Integer> formor, List<Integer> now) {
        if (formor== null || formor.size() != now.size()) {
            return false;
        }

        for (int i = 0; i < formor.size(); i++) {
            if (!formor.get(i).equals(now.get(i))) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{0};

        Solution solution = new Solution();
        System.out.println(solution.threeSum(nums));
    }
}
