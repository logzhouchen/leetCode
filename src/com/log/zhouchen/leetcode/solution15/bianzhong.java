package com.log.zhouchen.leetcode.solution15;

import java.util.Arrays;

/**
 * @author: shenzhouchen
 * @date: 2021/5/6 11:33 PM
 *
 * 给定一个长度为n的数组和一个整数M，在这个数组里选择三个数，三个数的和小于等于M，返回有多少种方法
 **/
public class bianzhong {

    public int threeSum(int[] nums, int target) {
        int count = 0;
        if (nums == null) {
            return count;
        }

        // 升序排列
        Arrays.sort(nums);
        int[] duplicated = new int[nums.length];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                duplicated[i] = duplicated[i - 1] + 1;
            } else {
                duplicated[i] = duplicated[i - 1];
            }
        }

        for (int i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            int j = i + 1, k = nums.length - 1;
            while (j < k) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    j++;
                    continue;
                }

                int sum = nums[i] + nums[j] + nums[k];
                if (sum <= target) {
                    count = count + k - j - (duplicated[k] - duplicated[j]);
                    if (nums[j] == nums[j + 1]) {
                        count++;
                    }
                    j++;
                } else {
                    k--;
                }
            }
        }

        return count;
    }

    /**
     * 1,2,2,2,3,3,4,5
     *
     * 1,2,5
     * 1,2,4
     * 1,2,3
     * 1,2,2
     * 1,3,5
     * 1,3,4
     * 1,3,3
     * 1,4,5
     * 2,2,5
     * 2,2,4
     * 2,2,3
     * 2,2,2
     * 2,3,5
     * 2,3,4
     * 2,3,3
     * 3,3,4
     */
    public static void main(String[] args) {
        int[] nums = new int[]{3,2,5,2,1,4,2,3};

        bianzhong solution = new bianzhong();
        System.out.println(solution.threeSum(nums, 10));
    }
}
